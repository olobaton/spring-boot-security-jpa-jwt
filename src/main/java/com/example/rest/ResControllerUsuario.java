/**
 * 
 */
package com.example.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.res.ResUsuario;

/**
 * @author loboo
 *
 */
public interface ResControllerUsuario {
	
	public ResponseEntity<?> auth (@RequestBody ResUsuario p) throws Exception;

}
