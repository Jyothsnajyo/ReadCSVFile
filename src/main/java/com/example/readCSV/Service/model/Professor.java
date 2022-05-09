package com.example.readCSV.Service.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Professor {
    private String firstName;
    private String lastname;
    private int age;
    private String Department;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
