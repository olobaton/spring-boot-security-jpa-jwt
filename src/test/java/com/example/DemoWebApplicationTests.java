package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dataaccess.DataAccessUser;
import com.example.logic.LogicPersona;
import com.example.model.dataaccess.UsuarioPO;
import com.example.model.logic.LogicPersonaDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoWebApplicationTests {

	@Autowired
	LogicPersona logicpersona;
	
	@Autowired
	private DataAccessUser user;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
//	@Test
//	void crearPersona() {
//		LogicPersonaDTO persona = new LogicPersonaDTO();
//		persona.setNombre("prueba test");
//		LogicPersonaDTO retorno = logicpersona.save(persona);
//		assertTrue(retorno.getNombre().equalsIgnoreCase(persona.getNombre()));
//	}
	
	@Test
	void crearUsuario() {
		UsuarioPO usuario = new UsuarioPO();
		usuario.setUsuario("prueba");
		usuario.setPassword(bcrypt.encode("1234"));
		UsuarioPO retorno = user.save(usuario);
		assertTrue(retorno.getUsuario().equalsIgnoreCase(usuario.getUsuario()));
	}

}
