package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(CompositeKey.class)
public class User {

    @Id
    private Long key1;

    @Id
    private Long key2;

    public Long getKey1() {
        return key1;
    }

    public void setKey1(Long key1) {
        this.key1 = key1;
    }

    public Long getKey2() {
        return key2;
    }

    public void setKey2(Long key2) {
        this.key2 = key2;
    }
}
