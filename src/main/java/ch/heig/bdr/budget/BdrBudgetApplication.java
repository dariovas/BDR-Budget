package ch.heig.bdr.budget;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("ch.heig.bdr.budget.home.mapper")
@SpringBootApplication
public class BdrBudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(BdrBudgetApplication.class, args);
	}

}
