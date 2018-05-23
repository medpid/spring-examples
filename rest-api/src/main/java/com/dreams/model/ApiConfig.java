/**
 * 
 */
package com.dreams.model;

import java.io.Serializable;

/**
 * @author vasuk
 *
 */
public class ApiConfig implements Serializable{
	private static final long serialVersionUID = 698765822744252558L;
	private String uriPath;
	private String method;
	
	public String getUriPath() {
		return uriPath;
	}
	public void setUriPath(String uriPath) {
		this.uriPath = uriPath;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
}
