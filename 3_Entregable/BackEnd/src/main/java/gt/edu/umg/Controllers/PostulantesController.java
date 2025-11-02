package gt.edu.umg.Controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import gt.edu.umg.Entities.Postulante;
import gt.edu.umg.Repositories.PostulanteRepository;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * @author biron
 */


@Path("/postulantes")
public class PostulantesController {

    @Inject
    PostulanteRepository postulanteRepository;
    
	@GET
    public Response getAll(){
        JSONObject JsonRespuesta = new JSONObject();
        
        try{
            List<Postulante> lstPostulante = postulanteRepository.findPostulante();
            
			// Mapeamos la lista a String 
            ObjectMapper objMapper = new ObjectMapper();
            String jsonArray = objMapper.writeValueAsString(lstPostulante);
            
			// Parseamos String a JSON Array
            JSONParser parser = new JSONParser();
            JSONArray jsonPostulante = (JSONArray) parser.parse(jsonArray);
            
			// Añadimos propiedades y la lista
            JsonRespuesta.put("Estado", 1);
            JsonRespuesta.put("Mensaje", "consulta Exitosa");
            JsonRespuesta.put("postulantes",jsonPostulante );        
			
			// Retornamos un OK
            return Response.ok().entity(JsonRespuesta).build();
			
        } catch (Exception e){
            JsonRespuesta.put("Estado", 0);
            JsonRespuesta.put("Mensaje", "consulta no Exitosa");
           return Response.serverError().build(); 
        }        
    }
	
	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") int id){		 
		try{
			JSONObject jsonRespuesta = new JSONObject();
			
						
			var postulante = postulanteRepository.findById(id);
			
			ObjectMapper objMapper = new ObjectMapper();
			String jsonObject = objMapper.writeValueAsString(postulante);
			
			
			JSONParser parser = new JSONParser();
			JSONObject jsonPostulante = (JSONObject) parser.parse(jsonObject);
			
			jsonRespuesta.put("postulante", jsonPostulante);
			
			return Response.ok().entity(jsonPostulante).build();
			
		}catch(Exception ex){
			var errorMessage = "Hubo un problema, vuelve a intentarlo más tarde";
			return Response.serverError().entity(errorMessage).build();
		}
	}
	
    @POST
    public Response add(Postulante nuevoPostulante){
    
        JSONObject JsonRespuesta = new JSONObject();  

     try{       
        postulanteRepository.Create(nuevoPostulante);
        
        JsonRespuesta.put("estado", 1);
        JsonRespuesta.put("Mensaje", "Postulante Creado");
        
        return Response.ok().entity(JsonRespuesta).build();
        
       
     }   catch (Exception e){
    
             JsonRespuesta.put("estado", 0);
             JsonRespuesta.put("Mensaje", "Postulante no Creado");
             return Response.serverError().entity(JsonRespuesta).build();
    
        }
    }
	
    @PUT 
	@Consumes(MediaType.APPLICATION_JSON)
    public Response edit(Postulante postulante) {
        
        int id = postulante.getId();
        if (postulanteRepository.findById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        postulanteRepository.Edit(postulante);
        return Response.noContent().build();
    }

    @DELETE
	@Path("{id}")
    public Response delete(@PathParam("id") int id) {

        if (postulanteRepository.findById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        postulanteRepository.Delete(id);
        
        return Response.noContent().build();
    }

}
