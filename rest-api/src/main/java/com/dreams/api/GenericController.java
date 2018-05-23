package com.dreams.api;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dreams.model.ApiConfig;
import com.dreams.model.Greeting;

@RestController
public class GenericController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	
	
	@Autowired
	private GlobalProperties globalProperties;

	@RequestMapping("/app1/*")
	public Greeting greeting(HttpServletRequest req, @RequestParam(value = "name", defaultValue = "World") String name) {
		
		System.out.println("  URI : " + req.getRequestURI());
		System.out.println("Method: " + req.getMethod());
		System.out.println("Props : " + globalProperties.getAppName());
		System.out.println("JSON Prop: " + globalProperties.getApiConfigJson());
		System.out.println("API Model : " + globalProperties.getApiModel());
		System.out.println("MAP : " + globalProperties.getUriPathMap());
		
		if(null == globalProperties.getUriPathMap().get(req.getRequestURI().toLowerCase())) {
			System.out.println("URI NOT FOUND");
			return null;
		}
		ApiConfig config = globalProperties.getUriPathMap().get(req.getRequestURI().toLowerCase());
		
		if(!config.getMethod().equalsIgnoreCase(req.getMethod())) {
			System.out.println("METHOD NOT MATCHED");
			return null;
		}
		
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}