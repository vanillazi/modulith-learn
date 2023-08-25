package cn.vanillazi.learn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class ModulithLearnApplicationTests {

	@Test
	void contextLoads() {
		var modules= ApplicationModules.of(ModulithLearnApplication.class);
		modules.forEach(m->{
			System.out.println(m.getName());
		});
		modules.verify();
	}

}
