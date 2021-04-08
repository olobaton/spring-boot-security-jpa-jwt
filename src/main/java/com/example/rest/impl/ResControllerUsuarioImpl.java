/**
 * 
 */
package com.example.rest.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.jwt.JwtTokenUtil;
import com.example.model.res.JwtResponse;
import com.example.model.res.ResUsuario;
import com.example.rest.ResControllerUsuario;
import com.example.service.UserService;


/**
 * @author loboo
 *
 */

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class ResControllerUsuarioImpl implements ResControllerUsuario {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping()
	public ResponseEntity<?> auth (@RequestBody ResUsuario p) throws Exception {
		ResUsuario response = new ResUsuario();
		authenticate(p.getUsuario(), p.getPassword());
		final UserDetails user = userDetailsService.loadUserByUsername(p.getUsuario());
		final String token = jwtTokenUtil.generateToken(user);
		response.setUsuario(user.getUsername());
		response.setToken(new JwtResponse(token).getToken());
		return ResponseEntity.ok(response);		
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
