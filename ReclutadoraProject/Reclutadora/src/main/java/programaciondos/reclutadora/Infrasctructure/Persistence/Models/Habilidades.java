/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaciondos.reclutadora.Infrasctructure.Persistence.Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Junior Hernandez
 */
@Entity
@Table(name = "Habilidades")
@NamedQueries({
	@NamedQuery(name = "Habilidades.findAll", query = "SELECT h FROM Habilidades h"),
	@NamedQuery(name = "Habilidades.findByIdHabilidad", query = "SELECT h FROM Habilidades h WHERE h.idHabilidad = :idHabilidad"),
	@NamedQuery(name = "Habilidades.findByNombre", query = "SELECT h FROM Habilidades h WHERE h.nombre = :nombre"),
	@NamedQuery(name = "Habilidades.findByDescripcion", query = "SELECT h FROM Habilidades h WHERE h.descripcion = :descripcion")})
public class Habilidades implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdHabilidad")
	private Integer idHabilidad;
	@Basic(optional = false)
    @Column(name = "Nombre")
	private String nombre;
	@Column(name = "Descripcion")
	private String descripcion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idHabilidad")
	private List<HabilidadPostulante> habilidadPostulanteList;

	public Habilidades() {
	}

	public Habilidades(Integer idHabilidad) {
		this.idHabilidad = idHabilidad;
	}

	public Habilidades(Integer idHabilidad, String nombre) {
		this.idHabilidad = idHabilidad;
		this.nombre = nombre;
	}

	public Integer getIdHabilidad() {
		return idHabilidad;
	}

	public void setIdHabilidad(Integer idHabilidad) {
		this.idHabilidad = idHabilidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<HabilidadPostulante> getHabilidadPostulanteList() {
		return habilidadPostulanteList;
	}

	public void setHabilidadPostulanteList(List<HabilidadPostulante> habilidadPostulanteList) {
		this.habilidadPostulanteList = habilidadPostulanteList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idHabilidad != null ? idHabilidad.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Habilidades)) {
			return false;
		}
		Habilidades other = (Habilidades) object;
		if ((this.idHabilidad == null && other.idHabilidad != null) || (this.idHabilidad != null && !this.idHabilidad.equals(other.idHabilidad))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.Habilidades[ idHabilidad=" + idHabilidad + " ]";
	}
	
}
