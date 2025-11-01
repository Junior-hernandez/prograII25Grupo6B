package gt.edu.umg.controllers;


import gt.edu.umg.entities.Postulante;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import javax.inject.inject;
import static javax.management.Query.gt;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * @author biron
 */

@path("/Postulante")
public class PostulantesController {

    @inject
    PostulanteRepository PostulanteRepository;
    
    @POST
    public Response saveNewPostulante(Postulante nuevoPostulante){
    
        JSONObject JsonRespuesta = new JSONObject();  

     try{       
        PostulanteRepository.Create(nuevoPostulante);
        
        JsonRespuesta.put("estado", 1);
        JsonRespuesta.put("Mensaje", "Postulante Creado");
        
        return response.ok().entity(JsonRespuesta).build();
        
       
     }   catch (Exception e){
    
             JsonRespuesta.put("estado", 0);
             JsonRespuesta.put("Mensaje", "Postulante no Creado");
             return response.serverError().entity(JsonRespuesta).build();
    
        }
    }
    @GET
    public Response findPostulante(){
        JSONObject JsonRespuesta = new JSONObject();
        
        try{
            list<Postulante> lstPostulante = PostulanteRepository.findPostulante();
            
            ObjectMapper o objMapper = new ObjectMapper();
            string jsonArray = objMapper.writeValueAsString(lstPostulante);
            
            JSONParser parser = new JSONParser();
            JSONArray jsonPostulante = (JSONArray) parser.parse(jsonArray);
            
            JsonRespuesta.put("Estado", 1);
            JsonRespuesta.put("Mensaje", "consulta Exitosa");
            JsonRespuesta.put("Postulante",jsonpostulante );        
            return Response.ok().entity(JsonRespuesta).build();
        } catch (Exception e){
            JsonRespuesta.put("Estado", 0);
            JsonRespuesta.put("Mensaje", "consulta no Exitosa");
           return Response.serverError().build(); 
        }
        
        return Response.ok().build();
        
    }
    
    @PUT 
    public Response editar(PostulanteEdit postulanteEdit) {
        
        int id = postulanteEdit.getId();
        if (postulanteRepository.GetById(id) == null) {
           
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        postulanteRepository.Edit(postulanteEdit);
        
        return Response.noContent().build();
    }

    @DELETE 
    public Response eliminar(PostulanteDeleteRequest deleteRequest) {
        
        int id = deleteRequest.getId();

        if (postulanteRepository.GetById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        postulanteRepository.Delete(id);
        
        return Response.noContent().build();
    }

}
