package code.lumiseven.test.dynamic_schedule_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DynamicScheduleTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicScheduleTaskApplication.class, args);
	}

}
