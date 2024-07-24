package com.platzi.functional_student_practice._05_sam;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.IntFunction;

public class C15AgeUtils {

    public static void main(String[] args) {

        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 15\n");

        // 1. We declare a function to format integers for parser
        IntFunction<String> addCero = num -> num < 10 ? "0" + num : "" + num;

        // 2. We parse integers into a LocalDate object
        TriFunction<Integer, Integer, Integer, LocalDate> formatDate =
                (dd, mm, yyyy) -> LocalDate.parse(yyyy + "-" + addCero.apply(mm) + "-" + addCero.apply(dd));

        // 3. we calculate
        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (d, m, y) -> Period.between(formatDate.apply(d, m, y), LocalDate.now()).getYears();

        System.out.println(calculateAge.apply(24,6,2014));

    }

    // 0. We declare a FunctionalInterface to implement in our cude
    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

}
