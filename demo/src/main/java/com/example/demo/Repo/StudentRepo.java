package com.example.demo.Repo;

import com.example.demo.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo  extends JpaRepository<student,Integer> {
}
