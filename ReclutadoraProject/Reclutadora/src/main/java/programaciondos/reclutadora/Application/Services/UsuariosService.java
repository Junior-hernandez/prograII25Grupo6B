package programaciondos.reclutadora.Application.Services;
//

import java.util.List;
import javax.persistence.PersistenceException;
import programaciondos.reclutadora.Application.Exceptions.EntityNotFoundException;
import programaciondos.reclutadora.Domain.Interfaces.IRepositories.IRepository;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Usuarios;

public class UsuariosService {
	private final IRepository<Usuarios> _repo;
	
	public UsuariosService(IRepository<Usuarios> repo){
		_repo = repo;
	}
	
	public List<Usuarios> GetAll(){
		var usuarios = _repo.GetAll();
		
		if(usuarios == null) 
			throw new EntityNotFoundException("No se pudo obtener la lista de Usuarios");
		return usuarios;
	}
	
	public Usuarios GetById(int id){
		if(id < 1) 
			throw new IllegalArgumentException("El Id no puede ser menor a 1");
		
		var usuario = _repo.GetById(id);
		
		if(usuario == null) 
			throw new EntityNotFoundException("No se pudo obtener el usuario con id: " + id);
		
		return usuario;
	}
	// Al crear un usuario hay que asignarle un rol con un servicio coordinador (AuthService)
	public void Add(Usuarios usuario){
		if(usuario == null) 
			throw new IllegalArgumentException("El Usuario no puede ser nulo");
		
		if(usuario.getNombre() == null || usuario.getContrasenia() == null) 
			throw new IllegalArgumentException("Formato invalido");

		_repo.Add(usuario);
	}
	
	// Editar usuario no será manejado por ningún service coordinador 
	// Por eso maneja sus propios logs y devuelve una excepcion para el controller (para un 404)
	public void Edit(Usuarios usuario){
		try{
			if(usuario == null) 
				throw new IllegalArgumentException("El Usuario no puede ser nulo");
			
			if(usuario.getNombre() == null || usuario.getContrasenia() == null) 
				throw new IllegalArgumentException("Formato invalido");
			
			_repo.Edit(usuario);
			
		}catch(PersistenceException ex){
			throw new EntityNotFoundException("No se pudo editar el usuario" + usuario.getNombre(), ex);
		}
	}
	
	// Darse de baja implica eliminar referencia a rol, por ende será manejado por un srevice coordinador
	public void DeleteById(int id){
		if(id < 1)
			throw new IllegalArgumentException("El id no puede ser menor a 1");
		
		Usuarios usuario = _repo.GetById(id);
		
		if( usuario == null) 
			throw new EntityNotFoundException("No se pudo encontrar el usuario con id: " + id );

		_repo.Delete(usuario);
	}
}
