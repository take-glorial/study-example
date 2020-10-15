package kr.co.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "kr.co.study.repository")
public class StudyExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyExampleApplication.class, args);
	}

}
