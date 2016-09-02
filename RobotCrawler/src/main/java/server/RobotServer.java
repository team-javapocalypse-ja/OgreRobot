package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("server.service")
@ComponentScan({"server.service", "robot.ebooks"})
public class RobotServer {

    public static void main(String ... args){
        System.setProperty("spring.config.name", "robot-server");
        SpringApplication.run(RobotServer.class, args);
    }
}
