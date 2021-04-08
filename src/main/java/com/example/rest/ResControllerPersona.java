/**
 * 
 */
package com.example.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.res.ResPersona;

/**
 * @author loboo
 *
 */
public interface ResControllerPersona {
	
	public List<ResPersona> obtener ();
	
	public ResPersona crear (@RequestBody ResPersona p);
	
	public ResPersona modificar (@RequestBody ResPersona p);
	
	public void eliminar (@PathVariable("id") Integer id);

}
