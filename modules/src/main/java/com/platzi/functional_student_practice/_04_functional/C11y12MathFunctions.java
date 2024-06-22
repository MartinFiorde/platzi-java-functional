package com.platzi.functional_student_practice._04_functional;

import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class C11y12MathFunctions {
    public static void main(String[] args) {

        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 11\n");

        // 1. function as type
//        Function<Integer, Integer> square1 = new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer x) {
//                return x * x;
//            }
//        };
//        System.out.println(square1.apply(5)+"\n");

        // 2. function 1 writen in a more performant way
        IntUnaryOperator square2 = x -> x * x;
        System.out.println(square2.applyAsInt(6)+"\n");

        // 3. function 3 declared in the class, outside the main method
        System.out.println(square3(7));
        System.out.println(square3(8)+"\n");


        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 12\n");

        // 1. Function as type using lambda to declare operation in one line
//        Function<Integer, Boolean> isOdd1 = x -> x % 2 == 1;
//        System.out.println(isOdd1.apply(7));
//        System.out.println(isOdd1.apply(8)+"\n");

        // 2. function 1 writen in a more performant way
        IntPredicate isOdd2 = x -> x % 2 == 1;
        System.out.println(isOdd2.test(7));
        System.out.println(isOdd2.test(8)+"\n");

        // 3. function Predicate by teacher
//        Predicate<Integer> isEven1 = x -> x % 2 == 0;
//        System.out.println(isEven1.test(7));
//        System.out.println(isEven1.test(8)+"\n");

        // 4. function 3 performant
        IntPredicate isEven2 = x -> x % 2 == 0;
        System.out.println(isEven2.test(7));
        System.out.println(isEven2.test(8)+"\n");

        // 5. Student example
        Predicate<Student> isApproved = student -> student.getQualification()>= 7;
        System.out.println(isApproved.test(new Student(6)));
        System.out.println(isApproved.test(new Student(7)));
    }

    private static int square3(int x) {
        return x * x;
    }

    private static class Student {
        private final double qualification;
        public Student(double qualification) {
            this.qualification = qualification;
        }
        public double getQualification() {
            return qualification;
        }
    }

}
