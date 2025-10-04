package programaciondos.reclutadora.Application.DTOs.UsuariosDTOs;

public class UsuarioLoginRequestDTO {
	private String email;
	private String contrasenia;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
}
