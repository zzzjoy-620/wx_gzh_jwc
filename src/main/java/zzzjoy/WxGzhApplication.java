package zzzjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WxGzhApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxGzhApplication.class, args);
    }

}
