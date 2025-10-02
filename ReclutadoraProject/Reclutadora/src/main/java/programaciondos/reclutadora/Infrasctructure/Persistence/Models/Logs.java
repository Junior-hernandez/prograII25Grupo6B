/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaciondos.reclutadora.Infrasctructure.Persistence.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Junior Hernandez
 */
@Entity
@Table(name = "Logs")
@NamedQueries({
	@NamedQuery(name = "Logs.findAll", query = "SELECT l FROM Logs l"),
	@NamedQuery(name = "Logs.findByIdLog", query = "SELECT l FROM Logs l WHERE l.idLog = :idLog"),
	@NamedQuery(name = "Logs.findByFechaRegistro", query = "SELECT l FROM Logs l WHERE l.fechaRegistro = :fechaRegistro"),
	@NamedQuery(name = "Logs.findByError", query = "SELECT l FROM Logs l WHERE l.error = :error"),
	@NamedQuery(name = "Logs.findByDescripcion", query = "SELECT l FROM Logs l WHERE l.descripcion = :descripcion")})
public class Logs implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdLog")
	private Integer idLog;
	@Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	@Basic(optional = false)
    @Column(name = "Error")
	private String error;
	@Basic(optional = false)
    @Column(name = "Descripcion")
	private String descripcion;

	public Logs() {
	}

	public Logs(Integer idLog) {
		this.idLog = idLog;
	}

	public Logs(Integer idLog, String error, String descripcion) {
		this.idLog = idLog;
		this.error = error;
		this.descripcion = descripcion;
	}

	public Integer getIdLog() {
		return idLog;
	}

	public void setIdLog(Integer idLog) {
		this.idLog = idLog;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idLog != null ? idLog.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Logs)) {
			return false;
		}
		Logs other = (Logs) object;
		if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.Logs[ idLog=" + idLog + " ]";
	}
	
}
