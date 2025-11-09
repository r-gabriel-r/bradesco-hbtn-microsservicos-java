package com.example.demo2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
	
	@RequestMapping(value="/messages")
	public String home() {
		return "PROJETO MAVEN (SPRING INITIALIZR) CRIADO COM SUCESSO !!!";
	}

}
