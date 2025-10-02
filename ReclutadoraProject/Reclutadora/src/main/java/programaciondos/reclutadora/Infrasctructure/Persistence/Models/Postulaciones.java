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
@Table(name = "Postulaciones")
@NamedQueries({
	@NamedQuery(name = "Postulaciones.findAll", query = "SELECT p FROM Postulaciones p"),
	@NamedQuery(name = "Postulaciones.findByIdPostulacion", query = "SELECT p FROM Postulaciones p WHERE p.idPostulacion = :idPostulacion")})
public class Postulaciones implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPostulacion")
	private Integer idPostulacion;
	@JoinColumn(name = "IdOferta", referencedColumnName = "IdOferta")
    @ManyToOne(optional = false)
	private Ofertas idOferta;
	@JoinColumn(name = "IdPostulante", referencedColumnName = "IdPostulante")
    @ManyToOne(optional = false)
	private Postulantes idPostulante;

	public Postulaciones() {
	}

	public Postulaciones(Integer idPostulacion) {
		this.idPostulacion = idPostulacion;
	}

	public Integer getIdPostulacion() {
		return idPostulacion;
	}

	public void setIdPostulacion(Integer idPostulacion) {
		this.idPostulacion = idPostulacion;
	}

	public Ofertas getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Ofertas idOferta) {
		this.idOferta = idOferta;
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
		hash += (idPostulacion != null ? idPostulacion.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Postulaciones)) {
			return false;
		}
		Postulaciones other = (Postulaciones) object;
		if ((this.idPostulacion == null && other.idPostulacion != null) || (this.idPostulacion != null && !this.idPostulacion.equals(other.idPostulacion))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.Postulaciones[ idPostulacion=" + idPostulacion + " ]";
	}
	
}
