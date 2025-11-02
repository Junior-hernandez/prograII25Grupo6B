/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.Controllers;

import gt.edu.umg.Entities.Empresa;
import gt.edu.umg.Repositories.EmpresaRepository;
import java.awt.PageAttributes.MediaType;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Deyvid Hernandez
 */

@Path("/empresas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpresasController {
	
	@Inject EmpresaRepository _repo;
	
	@GET
	public Response getAll(){
		var empresas = _repo.GetAll();
		return Response.ok().entity(empresas).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") int id){
		var empresa = _repo.getById(id);
		
		return Response.ok().entity(empresa).build();
	}
	
	@POST
	@Transactional
	public Response add(Empresa empresa){
		
		_repo.add(empresa);
		
		return Response.ok().build();
	}
	
	@PUT
	@Transactional
	public Response edit(Empresa empresa){
		
		_repo.edit(empresa);
		
		return Response.ok().build();
	}
	
	@DELETE
	@Transactional
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		
		_repo.delete(id);
		
		return Response.ok().build();
	}
}
