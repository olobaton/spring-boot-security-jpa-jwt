/**
 * 
 */
package com.example.model.res;

import java.io.Serializable;

/**
 * @author loboo
 *
 */
public class JwtResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 678400515256919431L;
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}