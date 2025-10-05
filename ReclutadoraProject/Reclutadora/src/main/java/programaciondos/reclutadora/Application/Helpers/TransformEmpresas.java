package programaciondos.reclutadora.Application.Helpers;

import programaciondos.reclutadora.Application.DTOs.EmpresasDTOs.EmpresaRequestDTO;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Empresas;

public class TransformEmpresas {
  public static Empresas DtoToEntity(EmpresaRequestDTO dto){
    var empresa = new Empresas();
    empresa.setNombre(dto.getNombre());
    empresa.setBiografia(dto.getBiografía());
    empresa.setDireccion(dto.getDireccion());
    
    return empresa;
  }
}