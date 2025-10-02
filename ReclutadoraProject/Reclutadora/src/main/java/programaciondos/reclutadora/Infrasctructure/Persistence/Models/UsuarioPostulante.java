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
@Table(name = "UsuarioPostulante")
@NamedQueries({
	@NamedQuery(name = "UsuarioPostulante.findAll", query = "SELECT u FROM UsuarioPostulante u"),
	@NamedQuery(name = "UsuarioPostulante.findByIdUsuarioPostulante", query = "SELECT u FROM UsuarioPostulante u WHERE u.idUsuarioPostulante = :idUsuarioPostulante")})
public class UsuarioPostulante implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdUsuarioPostulante")
	private Integer idUsuarioPostulante;
	@JoinColumn(name = "IdPostulante", referencedColumnName = "IdPostulante")
    @ManyToOne(optional = false)
	private Postulantes idPostulante;
	@JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
    @ManyToOne(optional = false)
	private Usuarios idUsuario;

	public UsuarioPostulante() {
	}

	public UsuarioPostulante(Integer idUsuarioPostulante) {
		this.idUsuarioPostulante = idUsuarioPostulante;
	}

	public Integer getIdUsuarioPostulante() {
		return idUsuarioPostulante;
	}

	public void setIdUsuarioPostulante(Integer idUsuarioPostulante) {
		this.idUsuarioPostulante = idUsuarioPostulante;
	}

	public Postulantes getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(Postulantes idPostulante) {
		this.idPostulante = idPostulante;
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
		hash += (idUsuarioPostulante != null ? idUsuarioPostulante.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof UsuarioPostulante)) {
			return false;
		}
		UsuarioPostulante other = (UsuarioPostulante) object;
		if ((this.idUsuarioPostulante == null && other.idUsuarioPostulante != null) || (this.idUsuarioPostulante != null && !this.idUsuarioPostulante.equals(other.idUsuarioPostulante))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.UsuarioPostulante[ idUsuarioPostulante=" + idUsuarioPostulante + " ]";
	}
	
}
