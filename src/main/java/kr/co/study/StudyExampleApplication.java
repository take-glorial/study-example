package kr.co.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyExampleApplication {

	public static void main(String[] args) {

		System.out.println("헬로우");

		SpringApplication.run(StudyExampleApplication.class, args);
	}

}
