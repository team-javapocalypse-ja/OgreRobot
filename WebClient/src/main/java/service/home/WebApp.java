package service.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApp {
    public static void main(String ... args){

        System.setProperty("spring.config.name", "registration-server");
        SpringApplication.run(WebApp.class, args);

    }

}
