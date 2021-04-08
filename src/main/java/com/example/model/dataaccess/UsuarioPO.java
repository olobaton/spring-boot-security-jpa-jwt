/**
 * 
 */
package com.example.model.dataaccess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * @author loboo
 *
 */
@Entity
@Table(name= "usuario")
public class UsuarioPO {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="id")
	Integer id;
	
	@Column(name="usuario", nullable = false, length = 50)
	String usuario;
	
	@Column(name="password", nullable = false, columnDefinition="TEXT")
	String password;
	
	@OneToOne(mappedBy="usuario")
	private DataPersonaPO persona;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DataPersonaPO getPersona() {
		return persona;
	}
	public void setPersona(DataPersonaPO persona) {
		this.persona = persona;
	}
}
