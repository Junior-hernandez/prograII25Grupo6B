package programaciondos.reclutadora.Application.Services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Ofertas;

/**
 *
 * @author Junior Hernandez
 */
public class OfertasService {
	public static List<Ofertas>GetfertasList(EntityManager em){
		try{
			
			var sp = em.createStoredProcedureQuery("sp_GetOfertas", Ofertas.class);
			

			return (List<Ofertas>) sp.getResultList();
		}catch(NoResultException ex) {
			return null;
		}
	}
}
