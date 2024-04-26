package javastudies.sms;

import javastudies.sms.model.entities.Student;
import javastudies.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}


	@Autowired
	private StudentRepository studentRepository;

	// Executes when the application is runned
	@Override
	public void run(String... args) throws Exception {
		Student student = new Student(null, "Leonardo", "Rafaelli", "leonardorafaelli@gmail.com");
		studentRepository.save(student);

	}
}
