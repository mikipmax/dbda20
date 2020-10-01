package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRest {
	@GetMapping("/hola")
	public String hola() {
		return "Hola Mundo";
	}
}
