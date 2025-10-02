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
@Table(name = "Permisos")
@NamedQueries({
	@NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p"),
	@NamedQuery(name = "Permisos.findByIdPermiso", query = "SELECT p FROM Permisos p WHERE p.idPermiso = :idPermiso"),
	@NamedQuery(name = "Permisos.findByNombre", query = "SELECT p FROM Permisos p WHERE p.nombre = :nombre"),
	@NamedQuery(name = "Permisos.findByDescripcion", query = "SELECT p FROM Permisos p WHERE p.descripcion = :descripcion")})
public class Permisos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPermiso")
	private Integer idPermiso;
	@Basic(optional = false)
    @Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
    @Column(name = "Descripcion")
	private String descripcion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPermiso")
	private List<RolPermiso> rolPermisoList;

	public Permisos() {
	}

	public Permisos(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	public Permisos(Integer idPermiso, String nombre, String descripcion) {
		this.idPermiso = idPermiso;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
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

	public List<RolPermiso> getRolPermisoList() {
		return rolPermisoList;
	}

	public void setRolPermisoList(List<RolPermiso> rolPermisoList) {
		this.rolPermisoList = rolPermisoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPermiso != null ? idPermiso.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Permisos)) {
			return false;
		}
		Permisos other = (Permisos) object;
		if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.Permisos[ idPermiso=" + idPermiso + " ]";
	}
	
}
