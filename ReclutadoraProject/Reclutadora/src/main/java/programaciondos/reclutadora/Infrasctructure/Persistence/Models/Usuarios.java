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
@Table(name = "Usuarios")
@NamedQueries({
	@NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
	@NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
	@NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
	@NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
	@NamedQuery(name = "Usuarios.findByContrasenia", query = "SELECT u FROM Usuarios u WHERE u.contrasenia = :contrasenia"),
	@NamedQuery(name = "Usuarios.findByActivo", query = "SELECT u FROM Usuarios u WHERE u.activo = :activo")})
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdUsuario")
	private Integer idUsuario;
	@Basic(optional = false)
    @Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
    @Column(name = "Email")
	private String email;
	@Basic(optional = false)
    @Column(name = "Contrasenia")
	private String contrasenia;
	@Column(name = "Activo")
	private Boolean activo;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
	private List<RolUsuario> rolUsuarioList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
	private List<Bitacoras> bitacorasList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
	private List<UsuarioEmpresa> usuarioEmpresaList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
	private List<UsuarioPostulante> usuarioPostulanteList;

	public Usuarios() {
	}

	public Usuarios(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuarios(Integer idUsuario, String nombre, String email, String contrasenia) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
		this.contrasenia = contrasenia;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public List<RolUsuario> getRolUsuarioList() {
		return rolUsuarioList;
	}

	public void setRolUsuarioList(List<RolUsuario> rolUsuarioList) {
		this.rolUsuarioList = rolUsuarioList;
	}

	public List<Bitacoras> getBitacorasList() {
		return bitacorasList;
	}

	public void setBitacorasList(List<Bitacoras> bitacorasList) {
		this.bitacorasList = bitacorasList;
	}

	public List<UsuarioEmpresa> getUsuarioEmpresaList() {
		return usuarioEmpresaList;
	}

	public void setUsuarioEmpresaList(List<UsuarioEmpresa> usuarioEmpresaList) {
		this.usuarioEmpresaList = usuarioEmpresaList;
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
		hash += (idUsuario != null ? idUsuario.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Usuarios)) {
			return false;
		}
		Usuarios other = (Usuarios) object;
		if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "programaciondos.reclutadora.Infrasctructure.Persistence.Models.Usuarios[ idUsuario=" + idUsuario + " ]";
	}
	
}
