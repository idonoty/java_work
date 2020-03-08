package piaodingding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;


import javax.annotation.PreDestroy;

@SpringBootApplication
@EnableScheduling
public class PddApplication {
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        PddApplication.context = SpringApplication.run(PddApplication.class,args);
    }

    @PreDestroy
    public void close(){
        PddApplication.context.close();
    }
}
