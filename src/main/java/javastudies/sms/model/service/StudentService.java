package javastudies.sms.model.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import javastudies.sms.model.entities.Student;
import javastudies.sms.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    };

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void updateStudent(Short studentId, Student newStudent){
        Optional<Student> dbStudentOptional = studentRepository.findById(studentId);
        if(dbStudentOptional.isPresent()){
            Student dbStudent = dbStudentOptional.get();
            BeanUtils.copyProperties(newStudent, dbStudent);
            studentRepository.save(dbStudent);
        }
    }

    public void deleteStudent(Short id) {
        studentRepository.deleteById(id);
    }

    public Optional<Student> getStudentById(Short id) { return studentRepository.findById(id); }
}
