package SpringBootAOP.SpringBootAOPModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=false)
@ComponentScan(basePackages={"com.spring.controller","com.spring.aspect","com.spring.service"})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
