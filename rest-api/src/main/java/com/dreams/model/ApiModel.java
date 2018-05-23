/**
 * 
 */
package com.dreams.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vasuk
 *
 */
public class ApiModel implements Serializable{
	private static final long serialVersionUID = 8604101245092544497L;
	
	private List<ApiConfig> apiModel = new ArrayList<ApiConfig>();

	public List<ApiConfig> getApiModel() {
		return apiModel;
	}

	public void setApiModel(List<ApiConfig> apiModel) {
		this.apiModel = apiModel;
	} 
	
}
