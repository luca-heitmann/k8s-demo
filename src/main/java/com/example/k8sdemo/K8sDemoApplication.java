package com.example.k8sdemo;

import io.micrometer.core.annotation.Timed;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class K8sDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(K8sDemoApplication.class, args);
    }

    @RestController
    public static class MyController {

        @Timed
        @GetMapping("/hello")
        public String hello() throws InterruptedException {
            //TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 5));
            return String.format("Hello Kubernetes, from %s!", System.getenv("HOSTNAME"));
        }

    }

}
