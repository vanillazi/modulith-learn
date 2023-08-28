package cn.vanillazi.learn.article;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.vanillazi.learn.system.repository.UserRepository;

import java.time.LocalDateTime;

@RequestMapping("/article")
@RestController
@RequiredArgsConstructor
public class ArticleController {

	private final UserRepository userRepository;

	@GetMapping
	public String getArticles() {
	
		return "just for "+userRepository.users().get(0)+" at "+ LocalDateTime.now();
	}
}
