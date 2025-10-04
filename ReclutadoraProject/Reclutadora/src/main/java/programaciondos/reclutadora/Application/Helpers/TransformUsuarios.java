package programaciondos.reclutadora.Application.Helpers;

import programaciondos.reclutadora.Application.DTOs.UsuariosDTOs.UsuarioRequestDTO;
import programaciondos.reclutadora.Infrasctructure.Persistence.Models.Usuarios;

public class TransformUsuarios {
	public static Usuarios DtoToEntity(UsuarioRequestDTO dto){
		var usuario = new Usuarios();
		usuario.setNombre(dto.getNombre());
		usuario.setEmail(dto.getEmail());
		usuario.setContrasenia(dto.getContrasenia());
		
		return usuario;
	}
}
