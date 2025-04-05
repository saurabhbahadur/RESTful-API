package mighty.backend_springBoot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BackendSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendSpringBootApplication.class, args);
		log.info("The server is running on 6969 port number");
	}

}
