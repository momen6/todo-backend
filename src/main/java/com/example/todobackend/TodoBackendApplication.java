package com.example.todobackend;

import com.example.todobackend.util.TodoLogger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TodoBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TodoLogger.LOGGER().info("Todo Service Started!");
    }
}
