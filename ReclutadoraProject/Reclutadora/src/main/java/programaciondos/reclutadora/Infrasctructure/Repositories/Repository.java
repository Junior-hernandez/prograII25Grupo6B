package programaciondos.reclutadora.Infrasctructure.Repositories;

import java.util.List;
import javax.persistence.EntityManager;
import programaciondos.reclutadora.Domain.Interfaces.IRepositories.IRepository;

public  class Repository<T> implements IRepository<T>{
	private final EntityManager _em; // El EM se recibe en el constructor
	private final Class<T> _entityClass;
	
	public Repository(EntityManager em, Class<T> entityClass){
		_em = em;
		_entityClass = entityClass;
	}
	
	@Override
	public List<T> GetAll() {
		String jpql = "SELECT e FROM " + _entityClass.getSimpleName() + " e";
		return _em.createQuery(jpql, _entityClass).getResultList();
	}

	@Override
	public T GetById(int id) {
		return _em.find(_entityClass, id);
	}

	@Override
	public void Add(T value) {
		_em.persist(value);
	}

	@Override
	public void Edit(T value) {
		_em.merge(value);
	}

	@Override
	public void Delete(T value){
		_em.remove(value);
	}
	
}
