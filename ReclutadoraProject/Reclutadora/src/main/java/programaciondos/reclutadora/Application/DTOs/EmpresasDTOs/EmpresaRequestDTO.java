package programaciondos.reclutadora.Application.DTOs.EmpresasDTOs;

public class EmpresaRequestDTO {
	private String Nombre;
	private String Biografia;
	private String Direccion;

	public EmpresaRequestDTO(String nombre, String biografia, String direccion){
		Nombre = nombre;
		Biografia = biografia;
		Direccion = direccion;
	}
	
	public String getNombre() {
		return Nombre;
	}

	public String getBiografía() {
		return Biografia;
	}

	public String getDireccion() {
		return Direccion;
	}
	
}
