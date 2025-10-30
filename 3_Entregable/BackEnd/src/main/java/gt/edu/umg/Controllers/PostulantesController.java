package gt.edu.umg.controllers;

import gt.edu.umg.entities.Postulante;
import gt.edu.umg.repositories.PostulanteRepository;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * @author biron
 */
@Path("/postulantes")
@Produces(MediaType.APPLICATION_JSON)
public class PostulantesController {

    @Inject
    PostulanteRepository postulanteRepository;

    
    @GET
    public List<Postulante> GetAll() {
        return postulanteRepository.listAll();
    }
}

