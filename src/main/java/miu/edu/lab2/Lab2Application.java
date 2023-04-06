package miu.edu.lab2;

import miu.edu.lab2.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab2Application {
	@Autowired
	Post post;
	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

}
