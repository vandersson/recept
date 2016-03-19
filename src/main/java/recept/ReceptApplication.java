package recept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: vda
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class ReceptApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ReceptApplication.class, args);
    }
}
