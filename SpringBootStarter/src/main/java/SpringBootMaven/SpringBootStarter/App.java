package SpringBootMaven.SpringBootStarter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@ComponentScan(basePackages= {"com.spring.controller", "com.spring.pojo"})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
