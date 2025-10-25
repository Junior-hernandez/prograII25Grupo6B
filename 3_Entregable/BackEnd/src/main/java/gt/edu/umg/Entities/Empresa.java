/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Deyvid Hernández
 */
@Entity
@Table (name="Empresas")
public class Empresa implements Serializable {
	@Id
	@Column(name="IdEmpresa")
	private int IdEmpresa;
	
	@Column (name="Nombre")
	private String Nombre;
	
	@Column (name="Biografia")
	private String Biografia;
	
	@Column (name="Direccion")
	private String Direccion;

	public int getIdEmpresa() {
		return IdEmpresa;
	}

	public void setIdEmpresa(int IdEmpresa) {
		this.IdEmpresa = IdEmpresa;
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
		return "Empresa{" + "IdEmpresa=" + IdEmpresa + ", Nombre=" + Nombre + ", Biografia=" + Biografia + ", Direccion=" + Direccion + '}';
	}
	
	
	
	
}
