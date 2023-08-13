package com.example.exam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotEmpty(message = "enter your id")
    private String id;
    @NotEmpty(message = "enter your name")
    private String name;
    @NotNull(message = "enter your salary")
    private  Double salary;

}
