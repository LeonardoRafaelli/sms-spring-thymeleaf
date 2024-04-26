package javastudies.sms.controller;

import javastudies.sms.model.entities.Student;
import javastudies.sms.model.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        System.out.println("Student LIST: " + studentList);
        model.addAttribute("students", studentList);
        return "students";
    };


}
