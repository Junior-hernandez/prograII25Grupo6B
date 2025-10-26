/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.Repositories;

import gt.edu.umg.Entities.Empresa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Deyvid Hernández
 */

public class EmpresaRepository implements PanacheRepository<Empresa> { 
	public List<Empresa> GetAll(){
		try{
			Query query = getEntityManager().createQuery("SELECT e FROM Empresas e");
			
			return query.getResultList();
			
		}catch(Exception e){
			System.out.println("HUBO UN ERROR " + e);
			return null;
		}
		
	}
	
	
}
