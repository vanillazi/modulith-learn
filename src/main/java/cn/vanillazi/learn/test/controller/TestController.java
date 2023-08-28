package cn.vanillazi.learn.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("/test")
@RestController
public class TestController {

	@GetMapping("/hello")
	public String greet(String name) {
		return "hello "+name+" at "+LocalDateTime.now();
	}
}
