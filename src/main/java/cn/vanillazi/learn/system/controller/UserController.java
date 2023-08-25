package cn.vanillazi.learn.system.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class UserController {

	@GetMapping
	public String greet(String name) {
		return "hello "+name+" at "+LocalDateTime.now();
	}
}
