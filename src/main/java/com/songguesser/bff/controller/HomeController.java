package com.songguesser.bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.songguesser.bff.ApplicationContextProvider;
import com.songguesser.bff.service.ApiBackendService;
import com.songguesser.bff.service.ApiConectorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "")
public class HomeController {

	@Autowired
	private ApiConectorService apiConectorService;
	
	@Autowired
	private ApiBackendService apiBackendService;
	
	@GetMapping(value = "/")
    public Object root() {
		log.info("Ingrese a homecontroller");
		return "Hola desde MS bff de DACS";
	}


	@GetMapping(value = "/version")
    public Object version() {
        return ApplicationContextProvider.getApplicationContext().getBean("buildInfo");
    }
	

	@GetMapping(value = "/backendping")
    public Object backendPing() {
		log.info("Ingrese a homecontroller backend ping");
		return apiBackendService.ping();
	}
	

}
	
