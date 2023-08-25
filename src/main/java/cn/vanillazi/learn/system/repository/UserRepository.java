package cn.vanillazi.learn.system.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

	public List<String> users(){
		return Arrays.asList("admin","guest");
	}
	
}
