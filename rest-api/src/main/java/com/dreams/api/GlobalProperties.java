package com.dreams.api;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.dreams.model.ApiConfig;
import com.dreams.model.ApiModel;
import com.google.gson.Gson;

@Component
@ConfigurationProperties
public class GlobalProperties {
	private Gson gson = new Gson();
	private String appName;
	private String appDescription;
	private ApiModel apiModel;
	private Map<String, ApiConfig> uriPathMap ;

	private String apiConfigJson;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDescription() {
		return appDescription;
	}

	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}

	public String getApiConfigJson() {
		return apiConfigJson;
	}

	public void setApiConfigJson(String apiConfigJson) {
		this.apiConfigJson = apiConfigJson;
	}

	public ApiModel getApiModel() {
		if(null == this.apiModel) {
			this.apiModel = gson.fromJson(this.apiConfigJson, ApiModel.class);
		}
		return apiModel;
	}

	public void setApiModel(ApiModel apiModel) {
		this.apiModel = apiModel;
	}

	public Map<String, ApiConfig> getUriPathMap() {
		if(null == this.uriPathMap) {
			this.uriPathMap = new HashMap<String, ApiConfig>();
			this.apiModel.getApiModel().forEach(new Consumer<ApiConfig>(){
				@Override
				public void accept(ApiConfig t) {
					uriPathMap.put(t.getUriPath(), t);
				}
			});
		}
		return this.uriPathMap;
	}

	public void setUriPathMap(Map<String, ApiConfig> uriPathMap) {
		this.uriPathMap = uriPathMap;
	}
	
	
}