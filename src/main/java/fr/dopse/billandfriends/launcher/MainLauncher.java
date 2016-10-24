package fr.dopse.billandfriends.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main class of Springboot.
 * Created by dopse.
 */

@SpringBootApplication
@ComponentScan("fr.dopse.billandfriends")
public class MainLauncher {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainLauncher.class, args);
    }
}
