package SpringGradle.SpringGradleTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.gradle.spring"})
public class SpringGradleTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGradleTestApplication.class, args);
	}

}
