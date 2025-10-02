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
@Table(name = "RolUsuario")
@NamedQueries({
	@NamedQuery(name = "RolUsuario.findAll", query = "SELECT r FROM RolUsuario r"),
	@NamedQuery(name = "RolUsuario.findByIdRolUsuario", query = "SELECT r FROM RolUsuario r WHERE r.idRolUsuario = :idRolUsuario")})
public class RolUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdRolUsuario")
	private Integer idRolUsuario;
	@JoinColumn(name = "IdRol", referencedColumnName = "IdRol")
    @ManyToOne(optional = false)
	private Roles idRol;
	@JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
    @ManyToOne(optional = false)
	private Usuarios idUsuario;

	public RolUsuario() {
	}

	public RolUsuario(Integer idRolUsuario) {
		this.idRolUsuario = idRolUsuario;
	}

	public Integer getIdRolUsuario() {
		return idRolUsuario;
	}

	public void setIdRolUsuario(Integer idRolUsuario) {
		this.idRolUsuario = idRolUsuario;
	}

	public Roles getIdRol() {
		return idRol;
	}

	public void setIdRol(Roles idRol) {
		this.idRol = idRol;
	}

	public Usuarios getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuarios idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idRolUsuario != null ? idRolUsuario.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RolUsuario)) {
			return false;
		}
		RolUsuario other = (RolUsuario) object;
		if ((this.idRolUsuario == null && other.idRolUsuario != null) || (this.idRolUsuario != null && !this.idRolUsuario.equals(other.idRolUsuario))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.RolUsuario[ idRolUsuario=" + idRolUsuario + " ]";
	}
	
}
