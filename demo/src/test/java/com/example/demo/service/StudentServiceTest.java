package com.example.demo.service;

import com.example.demo.Repo.StudentRepo;
import com.example.demo.entity.student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class StudentServiceTest {
    @Mock
    private StudentRepo studentRepo;

    @Autowired
    private StudentService studentService;
    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {

        this.studentService=new StudentService(this.studentRepo);
    }

    @Test
    void addingDetails() {
        student s=new student(1,"vs","bgm");
        student s1=new student(2,"vvs","bgl");
        List<student> S= List.of(s,s1);
        studentService.addingDetails(S);
        verify(studentRepo).saveAll(S);

    }

    @Test
    void getAllData() {
//        studentService.getAllData();
//        verify(studentRepo).findAll();
        // Arrange
        student student1 = new student(1,"John", "Doe");
        student student2 = new student(2,"Jane", "Smith");
        List<student> mockedStudents = Arrays.asList(student1, student2);

        when(studentRepo.findAll()).thenReturn(mockedStudents);

        // Act
        List<student> result = studentService.getAllData();

        // Assert
        assertEquals(mockedStudents, result);
        verify(studentRepo).findAll();

    }



    @Test
    void getStudentById() {
        student student=new student(1,"vishal","bgm");
        studentRepo.save(student);
        studentService.getStudentById(student.getId());
        verify(studentRepo).findById(student.getId());
    }

    @Test
    void deleteById() {
        student student=new student(1,"vishal","bgm");
        studentRepo.save(student);
        studentService.deleteById(student.getId());
        verify(studentRepo).deleteById(student.getId());
    }
    @Test
    void editData()
    {
         int id = 1;
        student existingStudent = new student("John", "Doe");
        student newStudentData = new student("Jane", "Smith");

        when(studentRepo.findById(id)).thenReturn(Optional.of(existingStudent));
        when(studentRepo.save(existingStudent)).thenReturn(existingStudent);

        // Act
        student updatedStudent = studentService.editTheData(newStudentData,id);

        // Assert
        assertEquals("Jane", updatedStudent.getName());
        assertEquals("Smith", updatedStudent.getCity());

        verify(studentRepo).findById(id);
        verify(studentRepo).save(existingStudent);
    }
    @Test
    void editStudent_notFound() {
        // Arrange
        int id = 1;
        student newStudentData = new student("Jane", "Smith");

        when(studentRepo.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> studentService.editTheData( newStudentData,id));
        verify(studentRepo).findById(id);
    }



}