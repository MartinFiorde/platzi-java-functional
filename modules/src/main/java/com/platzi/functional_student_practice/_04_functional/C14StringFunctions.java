package com.platzi.functional_student_practice._04_functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

public class C14StringFunctions {

    public static void main(String[] args) {

        System.out.println("////////////////////////////////////////////////////////////////////////////////////\n");
        System.out.println("CLASS 14\n");

        // 1. Unary operators are a Function class where input and return types match
        final String SALUTE = "Hi programing student";
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        System.out.println(quote.apply(SALUTE));

        UnaryOperator<String> addMark = text -> text + "!";
        System.out.println(quote.apply(addMark.apply(SALUTE)) + "\n");

        // 2. BiFunction class is a Function class that accept 2 parameters and return another
        BiFunction<Integer, Integer, Integer> multiply1 = (x, y) -> x * y;
        System.out.println(multiply1.apply(5, 4));

        // 3. function 2 improved
        BinaryOperator<Integer> multiply2 = (x, y) -> x * y;
        System.out.println(multiply2.apply(5, 4));

        // 4. function 3 improved
        IntBinaryOperator multiply3 = (x, y) -> x * y;
        System.out.println(multiply3.applyAsInt(5, 4) + "\n");

        // 5. BiFunction with mixed types
        BiFunction<String, Integer, String> leftPad = (text, number) -> {
            String formatSpecifier = "%" + number + "s"; //add spaces up to making a string of n characters
            return String.format(formatSpecifier, text);
        };
        System.out.println(leftPad.apply("Java", 10) + "\n");


    }


}
