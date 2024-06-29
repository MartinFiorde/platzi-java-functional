package com.platzi.functional_student_practice._07_inference;

import com.platzi.functional_teacher_theory._06_reference_operator.NombresUtils;

import java.util.List;

public class Inference {
    public static void main(String[] args) {

        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 17\n");

        List<String> alumnos = NombresUtils.getList("Hugo", "Paco", "Luis");
        //alumnos.forEach((String name) -> System.out.println(name)) // 1. Version with explicit types
        //alumnos.forEach(name -> System.out.println(name)) // 2. Version with lambda with explicit param, implicit type
        alumnos.forEach(System.out::println); // 3. Version with reference operator, implicit params and types
    }
}
