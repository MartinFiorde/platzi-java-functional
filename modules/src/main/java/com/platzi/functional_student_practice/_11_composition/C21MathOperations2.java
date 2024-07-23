package com.platzi.functional_student_practice._11_composition;

import java.util.function.IntUnaryOperator;

public class C21MathOperations2 {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 21\n");

        // 1. We declare 3 functions as variables
        IntUnaryOperator multiplyBy3 = x -> { // idem: Function<Integer, Integer>
            System.out.println("Multiplicando x: " + x + " por 3");
            return x * 3;
        };

        IntUnaryOperator add1 = x -> {
            System.out.println("Le agregare 1 a: " + x);
            return x + 1;
        };

        IntUnaryOperator square = x -> {
            System.out.println("Estoy elevando " + x + " al cuadrado");
            return x * x;
        };

        // 2. We compose a new function that execute multiplyBy3() AFTER we add1()
        IntUnaryOperator add1MultiplyBy3 = multiplyBy3.compose(add1); // idem: y -> add1.apply(y) - idem: add1::applyAsInt

        // 3. We compose a new function that execute add1MultiplyBy3() BEFORE we square()
        IntUnaryOperator andSquare = add1MultiplyBy3.andThen(square); // idem: y -> square.apply(y)

        System.out.println(multiplyBy3.applyAsInt(5));
        System.out.println(add1MultiplyBy3.applyAsInt(5));
        System.out.println(andSquare.applyAsInt(3));
    }
}
