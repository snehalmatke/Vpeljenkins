package springbootawsexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootAwsExampleApplication {
	
//	@GetMapping("/")
//	public String home() {
//		return "welcome to aws deployed";
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAwsExampleApplication.class, args);
	}

}
