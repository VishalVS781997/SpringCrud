package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="std_id")
    private int id;
    @Column(name="std_name")
    private String name;
    @Column(name="std_city")
    private String city;

    public student(String john, String doe) {
    }
}
