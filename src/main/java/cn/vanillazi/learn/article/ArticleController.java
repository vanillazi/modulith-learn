package cn.vanillazi.learn.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.vanillazi.learn.system.repository.UserRepository;

import java.time.LocalDateTime;

@RequestMapping("/article")
@RestController
public class ArticleController {

	private final UserRepository userRepository;

	@Autowired
	public ArticleController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping
	public String getArticles() {
	
		return "just for "+userRepository.users().get(0)+" at "+ LocalDateTime.now();
	}
}
