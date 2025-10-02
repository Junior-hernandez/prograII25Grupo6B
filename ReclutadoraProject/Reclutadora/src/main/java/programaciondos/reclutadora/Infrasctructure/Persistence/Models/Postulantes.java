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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Junior Hernandez
 */
@Entity
@Table(name = "Postulantes")
@NamedQueries({
	@NamedQuery(name = "Postulantes.findAll", query = "SELECT p FROM Postulantes p"),
	@NamedQuery(name = "Postulantes.findByIdPostulante", query = "SELECT p FROM Postulantes p WHERE p.idPostulante = :idPostulante"),
	@NamedQuery(name = "Postulantes.findByNombre", query = "SELECT p FROM Postulantes p WHERE p.nombre = :nombre"),
	@NamedQuery(name = "Postulantes.findByBiografia", query = "SELECT p FROM Postulantes p WHERE p.biografia = :biografia")})
public class Postulantes implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPostulante")
	private Integer idPostulante;
	@Basic(optional = false)
    @Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
    @Column(name = "Biografia")
	private String biografia;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "idPostulante")
	private Curriculums curriculums;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPostulante")
	private List<Postulaciones> postulacionesList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPostulante")
	private List<HabilidadPostulante> habilidadPostulanteList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPostulante")
	private List<UsuarioPostulante> usuarioPostulanteList;

	public Postulantes() {
	}

	public Postulantes(Integer idPostulante) {
		this.idPostulante = idPostulante;
	}

	public Postulantes(Integer idPostulante, String nombre, String biografia) {
		this.idPostulante = idPostulante;
		this.nombre = nombre;
		this.biografia = biografia;
	}

	public Integer getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(Integer idPostulante) {
		this.idPostulante = idPostulante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Curriculums getCurriculums() {
		return curriculums;
	}

	public void setCurriculums(Curriculums curriculums) {
		this.curriculums = curriculums;
	}

	public List<Postulaciones> getPostulacionesList() {
		return postulacionesList;
	}

	public void setPostulacionesList(List<Postulaciones> postulacionesList) {
		this.postulacionesList = postulacionesList;
	}

	public List<HabilidadPostulante> getHabilidadPostulanteList() {
		return habilidadPostulanteList;
	}

	public void setHabilidadPostulanteList(List<HabilidadPostulante> habilidadPostulanteList) {
		this.habilidadPostulanteList = habilidadPostulanteList;
	}

	public List<UsuarioPostulante> getUsuarioPostulanteList() {
		return usuarioPostulanteList;
	}

	public void setUsuarioPostulanteList(List<UsuarioPostulante> usuarioPostulanteList) {
		this.usuarioPostulanteList = usuarioPostulanteList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPostulante != null ? idPostulante.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Postulantes)) {
			return false;
		}
		Postulantes other = (Postulantes) object;
		if ((this.idPostulante == null && other.idPostulante != null) || (this.idPostulante != null && !this.idPostulante.equals(other.idPostulante))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.Postulantes[ idPostulante=" + idPostulante + " ]";
	}
	
}
