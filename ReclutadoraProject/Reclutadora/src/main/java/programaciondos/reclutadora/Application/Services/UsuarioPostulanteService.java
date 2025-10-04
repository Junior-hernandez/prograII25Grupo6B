/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaciondos.reclutadora.Application.Services;

/**
 *
 * @author biron
 */

import programaciondos.reclutadora.Application.Exceptions.EntityNotFoundException;
import programaciondos.reclutadora.Domain.Interfaces.IRepositories.IRepository;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.UsuarioPostulante;

public class UsuarioPostulanteService {
	private final IRepository<UsuarioPostulante> repo;
	
	public UsuarioPostulanteService(IRepository<UsuarioPostulante> repo){
		this.repo = repo;
	}
	
	public UsuarioPostulante GetById(int id){
		if(id < 1) {
			throw new IllegalArgumentException("El id del UsuarioPostulante no puede ser menor a 1");
		}
		
		var usrPos = repo.GetById(id);
		if(usrPos == null) {
			throw new EntityNotFoundException("No se encontró el UsuarioPostulante con el id: " + id);
		}
		
		return usrPos;
	}
	
	public void Add(UsuarioPostulante usrPos){
		if(usrPos == null) {
			throw new IllegalArgumentException("El UsuarioPostulante no puede ser nulo");
		}
		if(usrPos.getIdUsuario() == null || usrPos.getIdPostulante() == null){
			throw new IllegalArgumentException("Error de formato, campos de UsuarioPostulante nulos");
		}
		
		repo.Add(usrPos);
	}
	
	public void DeleteById(int id){
		if(id < 1) {
			throw new IllegalArgumentException("El id del UsuarioPostulante no puede ser menor a 1");
		}
		
		var usrPos = repo.GetById(id);
		if(usrPos == null){
			throw new EntityNotFoundException("No se encontró el UsuarioPostulante con el id: " + id);
		}
		
		repo.Delete(usrPos);
	}
	
}


