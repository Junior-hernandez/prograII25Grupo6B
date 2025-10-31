package gt.edu.umg.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Deyvid Hernandez
 */

@Entity
@Table (name="Empresas")
public class Empresa  implements Serializable {
	
	@Id
	@Column (name="IdEmpresa")
	private  int Id;
	
	@Column (name="Nombre", columnDefinition = "nvarchar(50)")
	private String Nombre;
	
	@Column (name="Biografia", columnDefinition = "nvarchar(250)")
	private String Biografia;
	
	@Column (name="Direccion", columnDefinition = "nvarchar(120)")
	private String Direccion;

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public String getBiografia() {
		return Biografia;
	}

	public void setBiografia(String Biografia) {
		this.Biografia = Biografia;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}	

	@Override
	public String toString() {
		return "Empresa{" + "Id=" + Id + ", Nombre=" + Nombre + ", Biografia=" + Biografia + ", Direccion=" + Direccion + '}';
	}
	
}
