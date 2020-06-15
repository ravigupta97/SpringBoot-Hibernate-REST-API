package project;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CourseAPIApp  {

	@Autowired
	TopicDAO topicDAO;
	public static void main(String[] args) {
		
		SpringApplication.run(CourseAPIApp.class, args);
	}

	
	
}
