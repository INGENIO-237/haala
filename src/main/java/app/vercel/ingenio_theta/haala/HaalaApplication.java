package app.vercel.ingenio_theta.haala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HaalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaalaApplication.class, args);
	}

}
