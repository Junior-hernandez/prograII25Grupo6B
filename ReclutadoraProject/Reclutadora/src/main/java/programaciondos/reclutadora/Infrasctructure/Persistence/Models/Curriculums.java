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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Junior Hernandez
 */
@Entity
@Table(name = "Curriculums")
@NamedQueries({
	@NamedQuery(name = "Curriculums.findAll", query = "SELECT c FROM Curriculums c"),
	@NamedQuery(name = "Curriculums.findByIdCurriculum", query = "SELECT c FROM Curriculums c WHERE c.idCurriculum = :idCurriculum"),
	@NamedQuery(name = "Curriculums.findByRutaArchivo", query = "SELECT c FROM Curriculums c WHERE c.rutaArchivo = :rutaArchivo")})
public class Curriculums implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCurriculum")
	private Integer idCurriculum;
	@Basic(optional = false)
    @Column(name = "RutaArchivo")
	private String rutaArchivo;
	@JoinColumn(name = "IdPostulante", referencedColumnName = "IdPostulante")
    @OneToOne(optional = false)
	private Postulantes idPostulante;

	public Curriculums() {
	}

	public Curriculums(Integer idCurriculum) {
		this.idCurriculum = idCurriculum;
	}

	public Curriculums(Integer idCurriculum, String rutaArchivo) {
		this.idCurriculum = idCurriculum;
		this.rutaArchivo = rutaArchivo;
	}

	public Integer getIdCurriculum() {
		return idCurriculum;
	}

	public void setIdCurriculum(Integer idCurriculum) {
		this.idCurriculum = idCurriculum;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
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
		hash += (idCurriculum != null ? idCurriculum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Curriculums)) {
			return false;
		}
		Curriculums other = (Curriculums) object;
		if ((this.idCurriculum == null && other.idCurriculum != null) || (this.idCurriculum != null && !this.idCurriculum.equals(other.idCurriculum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.Curriculums[ idCurriculum=" + idCurriculum + " ]";
	}
	
}
