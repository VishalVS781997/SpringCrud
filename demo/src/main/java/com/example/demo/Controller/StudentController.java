package com.example.demo.Controller;

import com.example.demo.entity.student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {
     @Autowired
    private StudentService studentService;

     @GetMapping("/fetch")
     public List<student> getAll()
     {
         return studentService.getAllData();
     }
     @PostMapping("/add")
    public void addData(@RequestBody List<student> s)
    {
        studentService.addingDetails(s);
    }
    @DeleteMapping("/remove/{id}")
    public void deleteData(@PathVariable Integer id)
    {
        studentService.deleteById(id);
    }
    @GetMapping("/getData/{id}")
    public student getByID(@PathVariable  Integer id)
    {
        return studentService.getStudentById(id);
    }
    @PutMapping("/edit/{id}")
    public student editData(@RequestBody student s,@PathVariable Integer  id)
    {
        return studentService.editTheData(s,id);
    }






}
