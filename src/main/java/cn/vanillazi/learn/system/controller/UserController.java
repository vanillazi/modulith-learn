package cn.vanillazi.learn.system.controller;

import java.util.List;
import java.util.Optional;

import cn.vanillazi.common.result.Result;
import cn.vanillazi.learn.system.entity.User;
import cn.vanillazi.learn.system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserRepository userRepository;

	@GetMapping("/{name}")
	public Result<User> getName(@PathVariable("name") String name) {
		return userRepository.getUser(name);
	}
	@GetMapping
	public Result<List<User>> list() {
		return userRepository.users();
	}
	@PostMapping
	public Result<Void> addUser(@Validated @RequestBody User user){
		return userRepository.add(user);
	}

	@PutMapping
	public Result<Void> updateUser(@Validated @RequestBody User user){
		return userRepository.update(user);
	}

	@DeleteMapping
	public Result<Void> deleteUser(@RequestParam("name") String name){
		return userRepository.delete(name);
	}
}
