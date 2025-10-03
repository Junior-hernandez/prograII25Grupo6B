package programaciondos.reclutadora.Application.Services;

import java.util.List;
import programaciondos.reclutadora.Application.Exceptions.EntityNotFoundException;
import programaciondos.reclutadora.Domain.Interfaces.IRepositories.IRepository;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Empresas;

public class EmpresasService {
  private IRepository<Empresas> empresaRepository;
  
  public EmpresasService(IRepository<Empresas> empresaRepository){
    this.empresaRepository = empresaRepository;
  }
  
  public List<Empresas> GetAll(){
    List<Empresas> empresas = empresaRepository.GetAll();
    return empresas;
  }
  
  public Empresas GetById(int id){
    
    if(id < 1){
      throw new IllegalArgumentException("EL id no puede ser menor a 1");
    }
    
    Empresas empresa = empresaRepository.GetById(id);
    
    if(empresa == null){
      throw new EntityNotFoundException("No se encontro la empresa");
    }
    return empresa;
  }
  
  public void Add(Empresas empresa){
    if(empresa == null){
      throw new IllegalArgumentException("La empresa no puede ser nula");
    }
    
    empresaRepository.Add(empresa);
  }
  
  public void Edit(Empresas empresa){
    if(empresa == null){
      throw new IllegalArgumentException("La empresa no puede ser nula");
    }
    
    empresaRepository.Edit(empresa);
  }
  
  public void DeleteById(int id){
    
    if(id < 1){
      throw new IllegalArgumentException("EL id no puede ser menor a 1");
    }
    
    Empresas empresa = empresaRepository.GetById(id);
    
    if(empresa == null){
      throw new EntityNotFoundException("No se encontro la empresa");
    }
    empresaRepository.Delete(empresa);
  }
  
}