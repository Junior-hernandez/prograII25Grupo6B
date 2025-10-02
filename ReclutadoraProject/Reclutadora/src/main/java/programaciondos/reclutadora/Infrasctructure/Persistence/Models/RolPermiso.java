/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaciondos.reclutadora.Infrasctructure.Persistence.Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Junior Hernandez
 */
@Entity
@Table(name = "RolPermiso")
@NamedQueries({
	@NamedQuery(name = "RolPermiso.findAll", query = "SELECT r FROM RolPermiso r"),
	@NamedQuery(name = "RolPermiso.findByIdRolPermiso", query = "SELECT r FROM RolPermiso r WHERE r.idRolPermiso = :idRolPermiso")})
public class RolPermiso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdRolPermiso")
	private Integer idRolPermiso;
	@JoinColumn(name = "IdPermiso", referencedColumnName = "IdPermiso")
    @ManyToOne(optional = false)
	private Permisos idPermiso;
	@JoinColumn(name = "IdRol", referencedColumnName = "IdRol")
    @ManyToOne(optional = false)
	private Roles idRol;

	public RolPermiso() {
	}

	public RolPermiso(Integer idRolPermiso) {
		this.idRolPermiso = idRolPermiso;
	}

	public Integer getIdRolPermiso() {
		return idRolPermiso;
	}

	public void setIdRolPermiso(Integer idRolPermiso) {
		this.idRolPermiso = idRolPermiso;
	}

	public Permisos getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(Permisos idPermiso) {
		this.idPermiso = idPermiso;
	}

	public Roles getIdRol() {
		return idRol;
	}

	public void setIdRol(Roles idRol) {
		this.idRol = idRol;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idRolPermiso != null ? idRolPermiso.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RolPermiso)) {
			return false;
		}
		RolPermiso other = (RolPermiso) object;
		if ((this.idRolPermiso == null && other.idRolPermiso != null) || (this.idRolPermiso != null && !this.idRolPermiso.equals(other.idRolPermiso))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.RolPermiso[ idRolPermiso=" + idRolPermiso + " ]";
	}
	
}
