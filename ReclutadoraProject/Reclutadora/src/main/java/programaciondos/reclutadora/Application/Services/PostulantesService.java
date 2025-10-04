/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaciondos.reclutadora.Application.Services;

import java.util.List;
import programaciondos.reclutadora.Application.Exceptions.EntityNotFoundException;
import programaciondos.reclutadora.Domain.Interfaces.IRepositories.IRepository;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Postulantes;

/**
 *
 * @author biron
 */

public class PostulantesService {

	private final IRepository<Postulantes> repo;

	public PostulantesService(IRepository<Postulantes> repo){
	  this.repo = repo;
	}

	public List<Postulantes> GetAll(){
		List<Postulantes> postulante = repo.GetAll();
		return postulante;
	}

	public Postulantes GetById(int id){

		if(id < 1){
			throw new IllegalArgumentException("EL id no puede ser menor a 1");
		}

		Postulantes postulante = repo.GetById(id);

		if(postulante == null){
			throw new EntityNotFoundException("No se encontro el postuante");
		}
		return postulante;
	}

	public void Add(Postulantes postulante){
		if(postulante == null){
			throw new IllegalArgumentException("El postualnte no puede ser nulo");
		}

		repo.Add(postulante);
	}

	public void Edit(Postulantes postulante){
		if(postulante == null){
			throw new IllegalArgumentException("El postulante no puede ser nulo");
		}

		repo.Edit(postulante);
	}

	public void DeleteById(int id){
    
		if(id < 1){
			throw new IllegalArgumentException("EL id no puede ser menor a 1");
		}
    
		Postulantes postulante = repo.GetById(id);
    
		if(postulante == null){
			throw new EntityNotFoundException("No se encontro el postulante");
		}
		
		repo.Delete(postulante);
	}
  
}


