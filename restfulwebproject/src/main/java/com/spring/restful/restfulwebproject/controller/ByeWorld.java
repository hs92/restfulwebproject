package com.spring.restful.restfulwebproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restful.restfulwebproject.domain.Bye;

@RestController
@RequestMapping("/bpi")
public class ByeWorld {

	@GetMapping("/bye")
	public Bye byeworld() {
		return new Bye("Bye World!");
	}
}
