package gt.edu.umg.repositories;

import gt.edu.umg.Entities.Postulante;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PostulanteRepository implements PanacheRepositoryBase<Postulante, Integer> {

    public List<Postulante> GetAll() {
        return listAll();
    }

    public Postulante GetById(int id) {
        return findById(id);
    }

    public void Add(Postulante postulante) {
        persist(postulante);
    }

    public void Edit(Postulante postulante) {
        getEntityManager().merge(postulante);
    }

    public void Delete(int id) {
        deleteById(id);
    }
}
