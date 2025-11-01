package gt.edu.umg.Repositories;

import gt.edu.umg.Entities.Postulante;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped 
public class PostulanteRepository {

    @Inject
    EntityManager em;

   
    @Transactional
    public void Create(Postulante nuevoPostulante) {
        em.persist(nuevoPostulante);
    }

    public List<Postulante> findPostulante() {
        try {
            Query q = em.createQuery("SELECT p FROM Postulante p order by p.id desc");
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("Error en findPostulante: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public void Edit(Postulante postulanteAEditar) {
        try {
            em.merge(postulanteAEditar);
        } catch (Exception e) {
            System.out.println("Error en Edit: " + e.getMessage());
        }
    }

    @Transactional
    public void Delete(int id) {
        try {
           
            Postulante postulanteAEliminar = em.find(Postulante.class, id);
            if (postulanteAEliminar != null) {
                em.remove(postulanteAEliminar);
            } else {
                System.out.println("No se encontró postulante con ID: " + id + " para eliminar.");
            }
        } catch (Exception e) {
            System.out.println("Error en Delete: " + e.getMessage());
        }
    }
    
    public Postulante findById(int id) {
        try {
            return em.find(Postulante.class, id);
        } catch (Exception e) {
            System.out.println("Error en findById: " + e.getMessage());
            return null;
        }
    }
}
 