/**
 * 
 */
package com.example.logic;

import java.util.List;

import com.example.model.logic.LogicPersonaDTO;



/**
 * @author loboo
 *
 */
public interface LogicPersona {
	
	public List<LogicPersonaDTO> findAll();
	
	public LogicPersonaDTO save(LogicPersonaDTO p);
	
	public void eliminar(Integer id);
	
	public LogicPersonaDTO modificar(LogicPersonaDTO p);

}
