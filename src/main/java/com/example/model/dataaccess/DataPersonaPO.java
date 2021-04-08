/**
 * 
 */
package com.example.model.dataaccess;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * @author loboo
 *
 */

@Entity
@Table(name = "persona")
public class DataPersonaPO {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="id")
	Integer id;	
	
	@Column(name="nombre", nullable = false, length = 50)
	String nombre;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id")
	UsuarioPO usuario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public UsuarioPO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioPO usuario) {
		this.usuario = usuario;
	}
}
