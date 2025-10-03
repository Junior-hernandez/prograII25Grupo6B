package programaciondos.reclutadora.Domain.Interfaces.IRepositories;

import java.util.List;

public interface IRepository<T> {
	List<T> GetAll();
	T GetById(int id);
	void Add(T value);
	void Edit(T value);
	void Delete(T value);
}
