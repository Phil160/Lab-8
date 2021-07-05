package edu.miu.cs.cs425.webapps.eregistrar.controller;

import edu.miu.cs.cs425.webapps.eregistrar.model.Student;
import edu.miu.cs.cs425.webapps.eregistrar.service.StudentService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/student/list")
    public ModelAndView listStudents(){
        var modelAndView = new ModelAndView();
        List<Student> students = studentService.getStudents();
        modelAndView.addObject("students",students);
        modelAndView.setViewName("student/list");
        return modelAndView;
    }
    @GetMapping(value = {"/student/newstudentform"})
    public String displayNewStudentForm(Model model){
        model.addAttribute("student",new Student());
        return "student/newstudentform";
    }
    @PostMapping(value = {"/student/newstudentform"})
    public String addNewStudent(@Valid
                                @ModelAttribute("student")Student student,
                                BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "student/newstudentform";
        }
        student=studentService.saveStudent(student);
        return "redirect:/student/list";
    }
}
