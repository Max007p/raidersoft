package svetonosets.raidersoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value = {
        "service",
        "controller",
})
@EntityScan("entity")
@EnableJpaRepositories("repository")
public class TestWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestWorkApplication.class, args);
    }

}
