package programaciondos.reclutadora.Infrasctructure.Repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import programaciondos.reclutadora.Domain.Interfaces.IRepositories.IRepository;

public abstract class Repository<T> implements IRepository<T>{
	private final EntityManager _em; // El EM se recibe en el constructor
	private final Class<T> _entityClass; 
	
	public Repository(EntityManager em, Class<T> entityClass){
		_em = em;
		_entityClass = entityClass;
	}
	
	@Override
	public List<T> GetAll() {
		try{
			String jpql = "SELECT e FROM " + _entityClass.getSimpleName() + " e";
			return _em.createQuery(jpql, _entityClass).getResultList();			
		}catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public T GetById(int id) {
		try{
			return _em.find(_entityClass, id);
		}catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public void Add(T value) {
		try{
			_em.persist(value);
		}catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public void Edit(T value) {
		try{
			_em.merge(value);
		}catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public void Delete(int id) {
		try{
			T value = GetById(id);
			if(value == null) throw new IllegalArgumentException("");
			
			_em.remove(value);
		}catch(Exception ex){
			throw ex;
		}
	}
	
}
