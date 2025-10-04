package programaciondos.reclutadora.Application.Helpers;


import programaciondos.reclutadora.Application.DTOs.PostulantesDTOs.PostulanteRequestDTO;
import programaciondos.reclutadora.Application.DTOs.postulanteRequestDTOs.PostulanteRequestDTO;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Postulantes;

public class TransformPostulantes {
	
	public static Postulantes DtoToEntity(PostulanteRequestDTO dto ){
		Postulantes postulante = new Postulantes();
		postulante.setNombre(dto.getNombre());
		postulante.setBiografia(dto.getBiografia());
		
		return postulante;
	}
}



