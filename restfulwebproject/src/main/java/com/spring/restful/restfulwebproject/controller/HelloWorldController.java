package com.spring.restful.restfulwebproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello world!";
	}
	
	@GetMapping("/hello-world-international")
	public String helloWorldInternational() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
