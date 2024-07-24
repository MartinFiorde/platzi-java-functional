package com.platzi.functional_student_practice._06_reference_operator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class C16NombresUtils {

    public static void main(String[] args) {

        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 15\n");

        List<String> teachers = getList("Juan", "Pedro", "Sara", "Gloria");

        // 1. Clasic Lambda
        //Consumer<String> printer = text -> System.out.println(text)

        // 2. Method reference with operator "::"
        Consumer<String> printer = System.out::println;

        teachers.forEach(printer);
    }

    @SafeVarargs
    private static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }

}
