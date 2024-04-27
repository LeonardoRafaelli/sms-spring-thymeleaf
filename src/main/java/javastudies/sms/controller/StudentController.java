package javastudies.sms.controller;

import javastudies.sms.model.entities.Student;
import javastudies.sms.model.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("students", studentList);
        return "students";
    };

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    };

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/student/del/{id}")
    public String deleteStudent(@PathVariable Short id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @PostMapping("/student/update/{id}")
    public String updateStudent(Model model, @PathVariable Short id){
        Optional<Student> student = studentService.getStudentById(id);
        if(student.isEmpty()){
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        return "update_student";
    }

    @PostMapping("/student/edit")
    public String saveEditStudent(@ModelAttribute("student") Student student){
      studentService.saveStudent(student);

      return "students";
    };
}
