package miu.edu.lab1;

import miu.edu.lab1.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab1Application {
	@Autowired
	Post post;
	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}

}
