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
@Table(name = "Roles")
@NamedQueries({
	@NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
	@NamedQuery(name = "Roles.findByIdRol", query = "SELECT r FROM Roles r WHERE r.idRol = :idRol"),
	@NamedQuery(name = "Roles.findByNombre", query = "SELECT r FROM Roles r WHERE r.nombre = :nombre"),
	@NamedQuery(name = "Roles.findByDescripcion", query = "SELECT r FROM Roles r WHERE r.descripcion = :descripcion")})
public class Roles implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdRol")
	private Integer idRol;
	@Basic(optional = false)
    @Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
    @Column(name = "Descripcion")
	private String descripcion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
	private List<RolUsuario> rolUsuarioList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
	private List<RolPermiso> rolPermisoList;

	public Roles() {
	}

	public Roles(Integer idRol) {
		this.idRol = idRol;
	}

	public Roles(Integer idRol, String nombre, String descripcion) {
		this.idRol = idRol;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
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

	public List<RolUsuario> getRolUsuarioList() {
		return rolUsuarioList;
	}

	public void setRolUsuarioList(List<RolUsuario> rolUsuarioList) {
		this.rolUsuarioList = rolUsuarioList;
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
		hash += (idRol != null ? idRol.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Roles)) {
			return false;
		}
		Roles other = (Roles) object;
		if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.Roles[ idRol=" + idRol + " ]";
	}
	
}
