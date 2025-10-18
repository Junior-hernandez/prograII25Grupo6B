package programaciondos.reclutadora.Application.DTOs.UsuariosDTOs;

public class UsuarioRequestDTO {
	private String Nombre;
	private String Email;
	private String Contrasenia;
	
	public UsuarioRequestDTO(String nombre, String email, String contrasenia){
		Nombre = nombre;
		Email = email;
		Contrasenia = contrasenia;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getEmail() {
		return Email;
	}

	public String getContrasenia() {
		return Contrasenia;
	}
	
	
}
