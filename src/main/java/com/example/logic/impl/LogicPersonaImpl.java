/**
 * 
 */
package com.example.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dataaccess.DataAccessPersona;
import com.example.logic.LogicPersona;
import com.example.model.dataaccess.DataPersonaPO;
import com.example.model.dataaccess.UsuarioPO;
import com.example.model.logic.LogicPersonaDTO;

/**
 * @author loboo
 *
 */
@Component
public class LogicPersonaImpl implements LogicPersona {
	
	@Autowired
	private DataAccessPersona dataaccesspersona;
	
	ArrayList<LogicPersonaDTO> list = null;
	
	@Override
	public List<LogicPersonaDTO> findAll() {
		LogicPersonaDTO logicpersonapo = null;
		list = new ArrayList<LogicPersonaDTO>();
		List<DataPersonaPO> listadata= dataaccesspersona.findAll();
		if(listadata.size() != 0) {
			for (DataPersonaPO obj: listadata) {
				logicpersonapo = new LogicPersonaDTO();
				logicpersonapo.setId(obj.getId());
				logicpersonapo.setNombre(obj.getNombre());
				logicpersonapo.setUsuario(obj.getUsuario().getUsuario());
				logicpersonapo.setPassword("Confidencial");
				list.add(logicpersonapo);				
			}			
		}
		return list;
	}
	
	public LogicPersonaDTO save(LogicPersonaDTO p) {
		DataPersonaPO datapersonapo = new DataPersonaPO();
		UsuarioPO usuaripo = new UsuarioPO();
		LogicPersonaDTO logicpersonapo = new LogicPersonaDTO();
		usuaripo.setPassword(p.getPassword());
		usuaripo.setUsuario(p.getUsuario());
		datapersonapo.setUsuario(usuaripo);
		datapersonapo.setId(p.getId());
		datapersonapo.setNombre(p.getNombre());
		datapersonapo = dataaccesspersona.save(datapersonapo);
		if(datapersonapo != null) {			
			logicpersonapo.setId(datapersonapo.getId());
			logicpersonapo.setNombre(datapersonapo.getNombre());
		}
		return logicpersonapo;
	}
	
	public LogicPersonaDTO modificar(LogicPersonaDTO p) {
		DataPersonaPO datapersonapo = new DataPersonaPO();
		LogicPersonaDTO logicpersonapo = new LogicPersonaDTO();
		datapersonapo.setId(p.getId());
		datapersonapo.setNombre(p.getNombre());
		datapersonapo = dataaccesspersona.save(datapersonapo);
		if(datapersonapo != null) {			
			logicpersonapo.setId(datapersonapo.getId());
			logicpersonapo.setNombre(datapersonapo.getNombre());
		}
		return logicpersonapo;
	}
	
	public void eliminar(Integer id) {
		dataaccesspersona.deleteById(id);
	}

}
