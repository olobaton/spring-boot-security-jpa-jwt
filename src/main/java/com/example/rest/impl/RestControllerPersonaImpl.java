/**
 * 
 */
package com.example.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.logic.LogicPersona;
import com.example.model.logic.LogicPersonaDTO;
import com.example.model.res.ResPersona;
import com.example.rest.ResControllerPersona;

/**
 * @author loboo
 *
 */

@RestController
@RequestMapping("/persona")
public class RestControllerPersonaImpl implements ResControllerPersona {
	
	
	@Autowired
	LogicPersona logicpersona;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@GetMapping()
	public List<ResPersona> obtener () {		
		List<LogicPersonaDTO> logicpersonapo = null;
		List<ResPersona> restpersonapo = new ArrayList<ResPersona>();		
		logicpersonapo = logicpersona.findAll();
		if (logicpersonapo != null && logicpersonapo.size() != 0) {
			for(LogicPersonaDTO obj: logicpersonapo) {
				ResPersona rest = new ResPersona();
				rest.setId(obj.getId());
				rest.setNombre(obj.getNombre());
				rest.setUsuario(obj.getUsuario());
				rest.setPassword(obj.getPassword());
				restpersonapo.add(rest);		
			}			
		}		
		return restpersonapo;		
	}
	
	@PostMapping()
	public ResPersona crear (@RequestBody ResPersona p) {
		ResPersona restpersonapo = new ResPersona();
		LogicPersonaDTO logicpersonapo = new LogicPersonaDTO();
		
		logicpersonapo.setId(p.getId());
		logicpersonapo.setNombre(p.getNombre());	
		logicpersonapo.setUsuario(p.getUsuario());
		logicpersonapo.setPassword(bcrypt.encode(p.getPassword()));
		logicpersonapo = logicpersona.save(logicpersonapo);
		if (logicpersonapo != null) {
			restpersonapo.setId(logicpersonapo.getId());
			restpersonapo.setNombre(logicpersonapo.getNombre());
		}		
		return restpersonapo;		
	}
	
	@PutMapping()
	public ResPersona modificar (@RequestBody ResPersona p) {
		ResPersona restpersonapo = new ResPersona();
		LogicPersonaDTO logicpersonapo = new LogicPersonaDTO();
		
		logicpersonapo.setId(p.getId());
		logicpersonapo.setNombre(p.getNombre());		
		logicpersonapo = logicpersona.save(logicpersonapo);
		if (logicpersonapo != null) {
			restpersonapo.setId(logicpersonapo.getId());
			restpersonapo.setNombre(logicpersonapo.getNombre());
		}		
		return restpersonapo;		
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar (@PathVariable("id") Integer id) {
			
		logicpersona.eliminar(id);
	}
	

}
