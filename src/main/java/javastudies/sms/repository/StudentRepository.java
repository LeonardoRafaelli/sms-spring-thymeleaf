package javastudies.sms.repository;

import javastudies.sms.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Short> {

}
