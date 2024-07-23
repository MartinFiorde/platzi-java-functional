package com.platzi.functional_student_practice._09_defaults;

public class C19StringFunctions {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 19\n");

        StringOperation six = () -> 6;
        // 1b. Execution of default method
        six.operate("Alumno");
        // 2b. Execution of concatenated default methods
        six.reduceAmount(2).operate("Profesor");

        // 3. Execution of .functionSaved() method
        DoOperation operateFive = text -> System.out.println(text);
        // 4. Execution of saved function 5 times with "Platzi" String
        operateFive.execute(5, "Platzi");
    }

    @FunctionalInterface
    interface StringOperation {
        int getAmount();

        // 1. Default method. Functional Interfaces require 1 and only 1 abstract method, but you can add any amount of default methods
        default void operate(String text) {
            int x = getAmount();
            while (x-- > 0) {
                System.out.println(text);
            }
        }

        // 2. Extra default method, wich return another StringOperation Object that can be called operate with a modificed Amount
        default StringOperation reduceAmount(int x) {
            int old = getAmount();
            return () -> old - x;
        }
    }

    @FunctionalInterface
    interface DoOperation {
        void functionSaved(String text);

        default void execute(int x, String text) {
            while (x-- > 0) {
                functionSaved(text);
            }
        }
    }
}
