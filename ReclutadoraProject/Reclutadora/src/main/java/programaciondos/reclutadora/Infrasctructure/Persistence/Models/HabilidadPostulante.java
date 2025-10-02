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
@Table(name = "HabilidadPostulante")
@NamedQueries({
	@NamedQuery(name = "HabilidadPostulante.findAll", query = "SELECT h FROM HabilidadPostulante h"),
	@NamedQuery(name = "HabilidadPostulante.findByIdHabilidadPostulante", query = "SELECT h FROM HabilidadPostulante h WHERE h.idHabilidadPostulante = :idHabilidadPostulante")})
public class HabilidadPostulante implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdHabilidadPostulante")
	private Integer idHabilidadPostulante;
	@JoinColumn(name = "IdHabilidad", referencedColumnName = "IdHabilidad")
    @ManyToOne(optional = false)
	private Habilidades idHabilidad;
	@JoinColumn(name = "IdPostulante", referencedColumnName = "IdPostulante")
    @ManyToOne(optional = false)
	private Postulantes idPostulante;

	public HabilidadPostulante() {
	}

	public HabilidadPostulante(Integer idHabilidadPostulante) {
		this.idHabilidadPostulante = idHabilidadPostulante;
	}

	public Integer getIdHabilidadPostulante() {
		return idHabilidadPostulante;
	}

	public void setIdHabilidadPostulante(Integer idHabilidadPostulante) {
		this.idHabilidadPostulante = idHabilidadPostulante;
	}

	public Habilidades getIdHabilidad() {
		return idHabilidad;
	}

	public void setIdHabilidad(Habilidades idHabilidad) {
		this.idHabilidad = idHabilidad;
	}

	public Postulantes getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(Postulantes idPostulante) {
		this.idPostulante = idPostulante;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idHabilidadPostulante != null ? idHabilidadPostulante.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof HabilidadPostulante)) {
			return false;
		}
		HabilidadPostulante other = (HabilidadPostulante) object;
		if ((this.idHabilidadPostulante == null && other.idHabilidadPostulante != null) || (this.idHabilidadPostulante != null && !this.idHabilidadPostulante.equals(other.idHabilidadPostulante))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.HabilidadPostulante[ idHabilidadPostulante=" + idHabilidadPostulante + " ]";
	}
	
}
