package programaciondos.reclutadora.Application.Services;

import java.util.List;
import programaciondos.reclutadora.Application.Exceptions.EntityNotFoundException;
import programaciondos.reclutadora.Domain.Interfaces.IRepositories.IRepository;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.RolUsuario;

public class RolUsuarioService {
	private final IRepository<RolUsuario> _repo;
	public RolUsuarioService(IRepository repo){
		_repo = repo;
	}
	
	public List<RolUsuario> GetAll(){
		var rolUsuario = _repo.GetAll();
		
		if(rolUsuario == null) 
			throw new EntityNotFoundException("No se pudo obtener la lista de RoleUsuarios");
		
		return rolUsuario;
	}
	
	public RolUsuario GetById(int id){
		if(id < 1) 
			throw new IllegalArgumentException("El Id no puede ser menor a 1");

		var rolUsuario = _repo.GetById(id);
		
		if(rolUsuario == null)
			throw new EntityNotFoundException("No se pudo obtener el usuario con id: " + id);
		
		return rolUsuario;
	}
	
	// Esto se usará luego de crear el usuario y especificar su rol (Empresa/Postulante)
	public void Add(RolUsuario rolUsuario){
		if(rolUsuario == null) 
			throw new IllegalArgumentException("El rolUsuario no puede ser nulo");
		
		// Esto se valida como nulo porque la JPA entity en getIdRol/Usuario devuelve un objeto y no un número
		if(rolUsuario.getIdRol() == null || rolUsuario.getIdUsuario() == null )
			throw new IllegalArgumentException("Formato invalido");

		_repo.Add(rolUsuario);
	}
	
	// Las relaciones entre roles y usuarios estarán predefinidas 
	// y no se podrá cambiar desde el sistema una vez asignadas
	public void Edit(RolUsuario rolUsuario){ throw new UnsupportedOperationException(); }
	
	// Eliminar una relacion entre rol y usuario se hará antes de eliminar el usuario
	public void DeleteById(int id){
		if(id < 1 )
			throw new IllegalArgumentException("El id no puede ser menor a 1");
		
		RolUsuario rolUsuario = _repo.GetById(id);
		
		if( rolUsuario == null) 
			throw new EntityNotFoundException("No se encotró el usuario con id: " + id);

		_repo.Delete(rolUsuario);
	}
}
