package com.example.demo.service;

import com.example.demo.Repo.StudentRepo;
import com.example.demo.entity.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public String addingDetails(List<student> s)
    {
        studentRepo.saveAll(s);
        return "data is added";
    }
    public List<student> getAllData()
    {
        List<student> s=studentRepo.findAll();
         return s;
    }
    public student getStudentById(int id)
    {
        student s=studentRepo.findById(id).orElse(null);
        return s;
    }
    public String deleteById(int id)
    {
        studentRepo.deleteById(id);
        return "data is removed";
    }
    public student editTheData(student s,int id)
    {
       student  stud=studentRepo.findById(id).orElse(null);

          stud.setName(s.getName());
          stud.setCity(s.getCity());
          return studentRepo.save(stud);
    }

}
