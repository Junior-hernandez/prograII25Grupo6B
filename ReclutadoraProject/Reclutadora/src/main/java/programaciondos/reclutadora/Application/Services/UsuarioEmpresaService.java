package programaciondos.reclutadora.Application.Services;

import programaciondos.reclutadora.Application.Exceptions.EntityNotFoundException;
import programaciondos.reclutadora.Domain.Interfaces.IRepositories.IRepository;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.UsuarioEmpresa;

public class UsuarioEmpresaService {
  private final IRepository<UsuarioEmpresa> empresaRepository;
  
  public UsuarioEmpresaService(IRepository<UsuarioEmpresa> empresaRepository){
    this.empresaRepository = empresaRepository;
  }
  
  public UsuarioEmpresa GetById(int id){
    if(id < 1) throw new IllegalArgumentException("El id del UsuarioEmpresa no puede ser menor a 1");
    
    var usrEmp = empresaRepository.GetById(id);
    if(usrEmp == null) throw new EntityNotFoundException("No se encontró el UsuarioEmpresa con el id: " + id);
    
    return usrEmp;
  }
  
  public void Add(UsuarioEmpresa usrEmp){
    if(usrEmp == null){
      throw new IllegalArgumentException("El UsuarioEmpresa no puede ser nulo");
    }
    if(usrEmp.getIdUsuario() == null || usrEmp.getIdEmpresa() == null){
      throw new IllegalArgumentException("Error de formato campos de UsuarioEmpresa nulos");
    }
    
    empresaRepository.Add(usrEmp);
  }
  
  public void DeleteById(int id){
    if(id < 1){
      throw new IllegalArgumentException("El id del UsuarioEmpresa no puede ser menor a 1");
    }
    
    var usrEmp = empresaRepository.GetById(id);
    if(usrEmp == null){
      throw new EntityNotFoundException("No se encontró el UsuarioEmpresa con el id: " + id);
    }
    
    empresaRepository.Delete(usrEmp);
  }
  
}