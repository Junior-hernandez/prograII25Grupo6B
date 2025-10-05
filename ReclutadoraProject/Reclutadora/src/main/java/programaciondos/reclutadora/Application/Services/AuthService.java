package programaciondos.reclutadora.Application.Services;

import javax.persistence.EntityManager;
import programaciondos.reclutadora.Application.DTOs.EmpresasDTOs.EmpresaRequestDTO;
import programaciondos.reclutadora.Application.DTOs.PostulantesDTOs.PostulanteRequestDTO;
import programaciondos.reclutadora.Application.DTOs.UsuariosDTOs.UsuarioLoginRequestDTO;
import programaciondos.reclutadora.Application.DTOs.UsuariosDTOs.UsuarioRequestDTO;
import programaciondos.reclutadora.Application.Exceptions.InvalidCredentialsException;
import programaciondos.reclutadora.Application.Exceptions.UserForbiddenException;
import programaciondos.reclutadora.Application.Helpers.TransformEmpresas;
import programaciondos.reclutadora.Application.Helpers.TransformPostulantes;
import programaciondos.reclutadora.Application.Helpers.TransformUsuarios;
import programaciondos.reclutadora.Domain.Interfaces.IRepositories.IRepository;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Empresas;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Postulantes;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.RolUsuario;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Roles;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.UsuarioEmpresa;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.UsuarioPostulante;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Usuarios;
import programaciondos.reclutadora.Infrasctructure.Repositories.Repository;

public class AuthService {
	private final EntityManager _em;
	private final UsuariosService _usrService;
	private final RolesService _rolService;
	private final RolUsuarioService _ruService;
	private final EmpresasService _empService;
	private final UsuarioEmpresaService _usrEmpService;
	private final PostulantesService _posService;
	private final UsuarioPostulanteService _usrPosService;
	
	public AuthService(EntityManager em){
		_em = em;
		
		IRepository<Usuarios> usrRepo = new Repository<>(_em, Usuarios.class);
		IRepository<RolUsuario> usrlRepo = new Repository<>(_em, RolUsuario.class);
		IRepository<Empresas> empRepo = new Repository<>(_em, Empresas.class);
		IRepository<Postulantes> posRepo = new Repository<>(_em, Postulantes.class);
		IRepository<Roles> rolRepo = new Repository<>(_em, Roles.class);
		IRepository<UsuarioEmpresa> usrEmpRepo = new Repository<>(_em, UsuarioEmpresa.class);
		IRepository<UsuarioPostulante> usrPosRepo = new Repository<>(_em, UsuarioPostulante.class);
		
		
		_empService = new EmpresasService(empRepo);
		_usrService = new UsuariosService(usrRepo);
		_ruService = new RolUsuarioService(usrlRepo);
		_rolService = new RolesService(rolRepo);
		_usrEmpService = new UsuarioEmpresaService(usrEmpRepo);
		_posService = new PostulantesService(posRepo);
		_usrPosService = new UsuarioPostulanteService(usrPosRepo);
	}
	
	
	// Considerar pasar estos metodos a una clase separada por la logica extensa (con casos de uso :D)
	public void RegistrarseEmpresa(UsuarioRequestDTO usuarioDto, EmpresaRequestDTO empresaRequest){
		try{
			
			// Instanciacion de las entidades
			var usuario = TransformUsuarios.DtoToEntity(usuarioDto);
			var empresa = TransformEmpresas.DtoToEntity(empresaRequest);
			var rol = _rolService.GetById(2); // id Rol de emrpesa en DB en teoría
			var rolUsuario = new RolUsuario();
			var usuarioEmpresa = new UsuarioEmpresa();

			_em.getTransaction().begin();

			// Persistir
			_usrService.Add(usuario);
			_empService.Add(empresa);

			// Crear relacion entre Rol y Usuario
			rolUsuario.setIdRol(rol);
			rolUsuario.setIdUsuario(usuario);
			_ruService.Add(rolUsuario);


			// Crear relacion usuario empresa
			usuarioEmpresa.setIdUsuario(usuario);
			usuarioEmpresa.setIdEmpresa(empresa);
			_usrEmpService.Add(usuarioEmpresa);

			_em.getTransaction().commit();
			
		}catch(Exception ex){
			if(_em.getTransaction().isActive()) _em.getTransaction().rollback();
			throw ex;
		}
	}
	
	// También Considerar pasar estos metodos a una clase separada por la logica extensa
	public Postulantes RegistrarsePostulante(UsuarioRequestDTO usuarioDto, PostulanteRequestDTO postulanteRequest){
		try{
			
			// Instanciacion de las entidades
			var usuario = TransformUsuarios.DtoToEntity(usuarioDto);
			var postulante = TransformPostulantes.DtoToEntity(postulanteRequest);
			var rol = _rolService.GetById(3); // EL id del rol Postulante en la DB teóricamente
			var rolUsuario = new RolUsuario();
			var usuarioPostulante = new UsuarioPostulante();

			_em.getTransaction().begin();

			// Persistir
			_usrService.Add(usuario);
			_posService.Add(postulante);

			// Crear relacion entre Rol y Usuario
			rolUsuario.setIdRol(rol);
			rolUsuario.setIdUsuario(usuario);
			_ruService.Add(rolUsuario);

			// Crear relacion entre Usuario y postulante
			usuarioPostulante.setIdUsuario(usuario);
			usuarioPostulante.setIdPostulante(postulante);
			_usrPosService.Add(usuarioPostulante);

			_em.getTransaction().commit();
			
			return postulante;
			
		}catch(Exception ex){
			if(_em.getTransaction().isActive()) _em.getTransaction().rollback();
			throw ex;
		}
		
	}
	
	public Usuarios IniciarSesion(UsuarioLoginRequestDTO usuarioLogin){
		if(usuarioLogin == null) 
			throw new IllegalArgumentException("El UsuarioLoginRequest no puede ser nulo");
		
		var usuario = _usrService.ValidateUsuario(_em, usuarioLogin.getEmail(), usuarioLogin.getContrasenia());
		
		if(usuario == null) 
			throw new InvalidCredentialsException("Usuario o contraseña invalidos");
		
		
		var rol = usuario.getRolUsuarioList().get(0).getIdRol();
		
		switch (rol.getNombre().toUpperCase()) {
			case "ADMIN" -> {return usuario;}
			case "EMPRESA" -> {return usuario;}
			case "POSTULANTE" -> {return usuario;}
			default -> throw new UserForbiddenException("El usuario no tiene permisos de acceso al recurso");
		}

	}
	
	public void CerrarSesion(){
		// Aqui simplemente limpiamos la variable de sesión
	}
		
}