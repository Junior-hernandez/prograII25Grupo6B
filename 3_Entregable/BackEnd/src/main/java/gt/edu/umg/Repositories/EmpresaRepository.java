/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.Repositories;

import gt.edu.umg.Entities.Empresa;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import java.util.List;
import javax.enterprise.context.RequestScoped;
/**
 *
 * @author Deyvid Hernández
 */

@RequestScoped
public class EmpresaRepository implements PanacheRepositoryBase<Empresa, Integer> { 
	
	public List<Empresa> GetAll(){
		return listAll();
	}
	
	public Empresa getById(int id){
		return findById(id);
	}
	
	public void add(Empresa empresa){
		persist(empresa);
	}
	   
	public void edit(Empresa empresa){
		getEntityManager().merge(empresa);
	}
	
	public void delete(int id){
		deleteById(id);
	}
}
