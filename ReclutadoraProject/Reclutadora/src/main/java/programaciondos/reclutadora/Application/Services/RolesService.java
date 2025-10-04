package programaciondos.reclutadora.Application.Services;

import programaciondos.reclutadora.Application.Exceptions.EntityNotFoundException;
import programaciondos.reclutadora.Domain.Interfaces.IRepositories.IRepository;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Roles;

public class RolesService {
	private final IRepository<Roles> _repo;
	public RolesService(IRepository<Roles> repo){
		_repo = repo;
	}
	
	public Roles GetById(int id){
		if(id < 1) throw new IllegalArgumentException("El id no puede ser menor a 1");
		
		var rol = _repo.GetById(id);
		
		if(rol == null) throw new EntityNotFoundException("No se pudo entontrar el rol con el id: " + id);
		
		return rol;
	}

}
