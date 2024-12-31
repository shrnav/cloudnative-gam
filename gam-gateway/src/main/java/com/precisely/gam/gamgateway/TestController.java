package com.precisely.gam.gamgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {
	@GetMapping("/sample")
	public String sayHello() {
		return "hello";
	}

}
