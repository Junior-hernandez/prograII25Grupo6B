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
@Table(name = "UsuarioEmpresa")
@NamedQueries({
	@NamedQuery(name = "UsuarioEmpresa.findAll", query = "SELECT u FROM UsuarioEmpresa u"),
	@NamedQuery(name = "UsuarioEmpresa.findByIdUsuarioEmpresa", query = "SELECT u FROM UsuarioEmpresa u WHERE u.idUsuarioEmpresa = :idUsuarioEmpresa")})
public class UsuarioEmpresa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdUsuarioEmpresa")
	private Integer idUsuarioEmpresa;
	@JoinColumn(name = "IdEmpresa", referencedColumnName = "IdEmpresa")
    @ManyToOne(optional = false)
	private Empresas idEmpresa;
	@JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
    @ManyToOne(optional = false)
	private Usuarios idUsuario;

	public UsuarioEmpresa() {
	}

	public UsuarioEmpresa(Integer idUsuarioEmpresa) {
		this.idUsuarioEmpresa = idUsuarioEmpresa;
	}

	public Integer getIdUsuarioEmpresa() {
		return idUsuarioEmpresa;
	}

	public void setIdUsuarioEmpresa(Integer idUsuarioEmpresa) {
		this.idUsuarioEmpresa = idUsuarioEmpresa;
	}

	public Empresas getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresas idEmpresa) {
		this.idEmpresa = idEmpresa;
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
		hash += (idUsuarioEmpresa != null ? idUsuarioEmpresa.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof UsuarioEmpresa)) {
			return false;
		}
		UsuarioEmpresa other = (UsuarioEmpresa) object;
		if ((this.idUsuarioEmpresa == null && other.idUsuarioEmpresa != null) || (this.idUsuarioEmpresa != null && !this.idUsuarioEmpresa.equals(other.idUsuarioEmpresa))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.UsuarioEmpresa[ idUsuarioEmpresa=" + idUsuarioEmpresa + " ]";
	}
	
}
