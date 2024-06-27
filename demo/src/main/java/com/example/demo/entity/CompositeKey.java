package com.example.demo.entity;

import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class CompositeKey implements Serializable {


    private Long keyId1;
    private Long keyId2;


    public CompositeKey(Long keyId1, Long keyId2) {
        this.keyId1 = keyId1;
        this.keyId2 = keyId2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeKey user = (CompositeKey) o;
        return Objects.equals(keyId1, user.keyId1) && Objects.equals(keyId2, user.keyId2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyId1, keyId2);
    }

    public Long getKeyId1() {
        return keyId1;
    }

    public void setKeyId1(Long keyId1) {
        this.keyId1 = keyId1;
    }

    public Long getKeyId2() {
        return keyId2;
    }

    public void setKeyId2(Long keyId2) {
        this.keyId2 = keyId2;
    }
}
