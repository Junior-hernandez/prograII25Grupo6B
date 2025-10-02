/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaciondos.reclutadora.Infrasctructure.Persistence.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Junior Hernandez
 */
@Entity
@Table(name = "Ofertas")
@NamedQueries({
	@NamedQuery(name = "Ofertas.findAll", query = "SELECT o FROM Ofertas o"),
	@NamedQuery(name = "Ofertas.findByIdOferta", query = "SELECT o FROM Ofertas o WHERE o.idOferta = :idOferta"),
	@NamedQuery(name = "Ofertas.findByTitulo", query = "SELECT o FROM Ofertas o WHERE o.titulo = :titulo"),
	@NamedQuery(name = "Ofertas.findByDescripcion", query = "SELECT o FROM Ofertas o WHERE o.descripcion = :descripcion"),
	@NamedQuery(name = "Ofertas.findBySalario", query = "SELECT o FROM Ofertas o WHERE o.salario = :salario")})
public class Ofertas implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdOferta")
	private Integer idOferta;
	@Basic(optional = false)
    @Column(name = "Titulo")
	private String titulo;
	@Basic(optional = false)
    @Column(name = "Descripcion")
	private String descripcion;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Basic(optional = false)
    @Column(name = "Salario")
	private BigDecimal salario;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOferta")
	private List<Postulaciones> postulacionesList;
	@JoinColumn(name = "IdEmpresa", referencedColumnName = "IdEmpresa")
    @ManyToOne(optional = false)
	private Empresas idEmpresa;

	public Ofertas() {
	}

	public Ofertas(Integer idOferta) {
		this.idOferta = idOferta;
	}

	public Ofertas(Integer idOferta, String titulo, String descripcion, BigDecimal salario) {
		this.idOferta = idOferta;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.salario = salario;
	}

	public Integer getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Integer idOferta) {
		this.idOferta = idOferta;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public List<Postulaciones> getPostulacionesList() {
		return postulacionesList;
	}

	public void setPostulacionesList(List<Postulaciones> postulacionesList) {
		this.postulacionesList = postulacionesList;
	}

	public Empresas getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresas idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idOferta != null ? idOferta.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Ofertas)) {
			return false;
		}
		Ofertas other = (Ofertas) object;
		if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.Ofertas[ idOferta=" + idOferta + " ]";
	}
	
}
