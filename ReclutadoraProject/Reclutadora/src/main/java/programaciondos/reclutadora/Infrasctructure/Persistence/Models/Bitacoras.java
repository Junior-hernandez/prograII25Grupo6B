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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Bitacoras")
@NamedQueries({
	@NamedQuery(name = "Bitacoras.findAll", query = "SELECT b FROM Bitacoras b"),
	@NamedQuery(name = "Bitacoras.findByIdBitacora", query = "SELECT b FROM Bitacoras b WHERE b.idBitacora = :idBitacora"),
	@NamedQuery(name = "Bitacoras.findByFechaRegistro", query = "SELECT b FROM Bitacoras b WHERE b.fechaRegistro = :fechaRegistro"),
	@NamedQuery(name = "Bitacoras.findByAccion", query = "SELECT b FROM Bitacoras b WHERE b.accion = :accion"),
	@NamedQuery(name = "Bitacoras.findByDescripcion", query = "SELECT b FROM Bitacoras b WHERE b.descripcion = :descripcion")})
public class Bitacoras implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdBitacora")
	private Integer idBitacora;
	@Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	@Basic(optional = false)
    @Column(name = "Accion")
	private String accion;
	@Basic(optional = false)
    @Column(name = "Descripcion")
	private String descripcion;
	@JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
    @ManyToOne(optional = false)
	private Usuarios idUsuario;

	public Bitacoras() {
	}

	public Bitacoras(Integer idBitacora) {
		this.idBitacora = idBitacora;
	}

	public Bitacoras(Integer idBitacora, String accion, String descripcion) {
		this.idBitacora = idBitacora;
		this.accion = accion;
		this.descripcion = descripcion;
	}

	public Integer getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(Integer idBitacora) {
		this.idBitacora = idBitacora;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		hash += (idBitacora != null ? idBitacora.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Bitacoras)) {
			return false;
		}
		Bitacoras other = (Bitacoras) object;
		if ((this.idBitacora == null && other.idBitacora != null) || (this.idBitacora != null && !this.idBitacora.equals(other.idBitacora))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.Bitacoras[ idBitacora=" + idBitacora + " ]";
	}
	
}
