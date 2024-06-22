package com.platzi.functional_student_practice._04_functional;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class MathFunctions {
    public static void main(String[] args) {

        // function as type
        Function<Integer, Integer> square1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println(square1.apply(5));


        // function as type writen in a more performant way
        IntUnaryOperator square2 = x -> x * x;
        System.out.println(square2.applyAsInt(6));


        // function 3 declared in the class, outside the main method
        System.out.println(square3(7));
    }

    private static int square3(int x) {
        return x*x;
    }

}
