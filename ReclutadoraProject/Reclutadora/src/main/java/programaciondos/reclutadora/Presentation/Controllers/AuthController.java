package programaciondos.reclutadora.Presentation.Controllers;

import javax.persistence.EntityManagerFactory;
import programaciondos.reclutadora.Application.DTOs.UsuariosDTOs.UsuarioLoginRequestDTO;
import programaciondos.reclutadora.Application.Exceptions.InvalidCredentialsException;
import programaciondos.reclutadora.Application.Exceptions.UserForbiddenException;
import programaciondos.reclutadora.Application.Services.AuthService;
import programaciondos.reclutadora.Presentation.Menus.Postulante.MenuPostulantes;

public class AuthController {
	private final EntityManagerFactory _emf;
	public AuthController(EntityManagerFactory emf){
		_emf = emf;
	}
	
	public void iniciarSesion(UsuarioLoginRequestDTO usrLogin){
		try{
			var em = _emf.createEntityManager();
			var auth = new AuthService(em);

			var usuario = auth.IniciarSesion(usrLogin);

			var rol = usuario.getRolUsuarioList().get(0).getIdRol();

			switch (rol.getNombre().toUpperCase()) {
				case "ADMIN" -> {}
				case "EMPRESA" -> {}
				case "POSTULANTE" -> {
					var menuPostulantes = new MenuPostulantes(usuario);
					menuPostulantes.Principal();
				}
				default -> throw new UserForbiddenException("El usuario no tiene un rol valido");
			}
		}catch(UserForbiddenException | InvalidCredentialsException | IllegalArgumentException ex){
			System.out.println(ex.getMessage());
		}catch(Exception ex){
			System.out.println("Parece que hubo un problema, intentalo mas tarde");
		}
	}
	
	
//	public Empresas registrarEmpresa(UsuarioRequestDTO usrDTO, EmpresaRequestDTO empDTO){
//		var em = _emf.createEntityManager();
//		var auth = new AuthService(em);
//		var empresa = auth.RegistrarseEmpresa(usrDTO, empDTO)
//	}
}
