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
import javax.persistence.Table;

/**
 *
 * @author Junior Hernandez
 */
@Entity
@Table(name = "Empresas")
@NamedQueries({
	@NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e"),
	@NamedQuery(name = "Empresas.findByIdEmpresa", query = "SELECT e FROM Empresas e WHERE e.idEmpresa = :idEmpresa"),
	@NamedQuery(name = "Empresas.findByNombre", query = "SELECT e FROM Empresas e WHERE e.nombre = :nombre"),
	@NamedQuery(name = "Empresas.findByBiografia", query = "SELECT e FROM Empresas e WHERE e.biografia = :biografia"),
	@NamedQuery(name = "Empresas.findByDireccion", query = "SELECT e FROM Empresas e WHERE e.direccion = :direccion")})
public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEmpresa")
	private Integer idEmpresa;
	@Basic(optional = false)
    @Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
    @Column(name = "Biografia")
	private String biografia;
	@Basic(optional = false)
    @Column(name = "Direccion")
	private String direccion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
	private List<UsuarioEmpresa> usuarioEmpresaList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
	private List<Ofertas> ofertasList;

	public Empresas() {
	}

	public Empresas(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Empresas(Integer idEmpresa, String nombre, String biografia, String direccion) {
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
		this.biografia = biografia;
		this.direccion = direccion;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<UsuarioEmpresa> getUsuarioEmpresaList() {
		return usuarioEmpresaList;
	}

	public void setUsuarioEmpresaList(List<UsuarioEmpresa> usuarioEmpresaList) {
		this.usuarioEmpresaList = usuarioEmpresaList;
	}

	public List<Ofertas> getOfertasList() {
		return ofertasList;
	}

	public void setOfertasList(List<Ofertas> ofertasList) {
		this.ofertasList = ofertasList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Empresas)) {
			return false;
		}
		Empresas other = (Empresas) object;
		if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.Empresas[ idEmpresa=" + idEmpresa + " ]";
	}
	
}
