package com.platzi.functional_student_practice._08_lambda;

import com.platzi.functional_teacher_theory._06_reference_operator.NombresUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

public class Syntax {
    public static void main(String[] args) {

        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 17\n");

        // 1 input, no return
        List<String> cursos = NombresUtils.getList("Java", "Functional");
        cursos.forEach(curso -> System.out.println(curso));
//      SAME AS USING THIS:
//        cursos.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });


        // no input, 1 return
        useZeroParameters(() -> 2);
//      SAME AS USING THIS:
//        useZeroParameters(new ZeroArguments() {
//            @Override
//            public int get() {
//                return 2;
//            }
//        });


        // 1 input, 1 return
        usePredicate(text -> text.isEmpty());
//      SAME AS USING THIS:
//        usePredicate(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return false;
//            }
//        });


        // 2 inputs, 1 return
        useBiFunction((Integer x, Integer y) -> x * y);
        useBiFunction((x, y) -> x * y);
//      SAME AS USING THIS:
//        useBiFunction(new BiFunction<>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                return integer * integer2;
//            }
//
//            @Override
//            public <V> BiFunction<Integer, Integer, V> andThen(Function<? super Integer, ? extends V> after) {
//                return BiFunction.super.andThen(after);
//            }
//        });


        // 2 inputs, 1 return
        useBiFunction((x, y) -> {
            System.out.println("X: " + x + ", Y:" + y);
            return x - y;
        });


        // no input, no return
        useNothing(() -> System.out.println("Hola Alumno"));
//      SAME AS USING THIS:
//        useNothing(new DoNothing() {
//            @Override
//            public void nothing() {
//                System.out.println("Hola Alumno");
//            }
//        });

    }

    static void useZeroParameters(ZeroArguments zeroArguments) {
        // static class to implement  FunctionalInterface
    }

    static void usePredicate(Predicate<String> predicado) {
        // static class to implement  FunctionalInterface
    }

    static void useBiFunction(BiFunction<Integer, Integer, Integer> operacion) {
        // static class to implement  FunctionalInterface
    }

    static void useNothing(DoNothing doNothing) {
        // static class to implement  FunctionalInterface
    }

    @FunctionalInterface
    interface ZeroArguments {
        int get();
    }

    @FunctionalInterface
    interface DoNothing {
        void nothing();
    }

    /*
    XXXXXXXXXXXX   Estructura Funciones Lambda   XXXXXXXXXXXX

    XXXXXX   Lambda que recibe un parámetro y realiza una operación simple:   XXXXXX
    text -> System.out.println(text)

    XXXXXX   Lambda que no recibe parámetros y realiza una operación de retorno simple:   XXXXXX
    () -> "Hello world"

    XXXXXX   Lambda que recibe un solo parámetro y realiza una operación de retorno simple:   XXXXXX
    x -> x % 2 == 0

    XXXXXX   Lambda que recibe varios parámetros:   XXXXXX
    (x, y) -> x * y

    XXXXXX   Lambda que realiza varias operaciones:   XXXXXX
    (x, y) -> {
      System.out.println("Suma de x: " + x + ", y: " + y);
      System.out.println(x + y);
    }

    XXXXXX   Lambda que realiza varias operaciones y retorno:   XXXXXX
    (x, y) -> {
      System.out.println("Suma de x: " + x + ", y: " + y);
      return x + y;
    }

    XXXXXX   Lambda con tipado de parámetros: // NOT USED   XXXXXX
    (String text) -> System.out.println(text);

    XXXXXX   Lambda que retorna un dato que ocupa varias lineas: XXXXXX
    () -> (
      "<button class='movie-close-button'>" +
      "  <figure><img src='src/images/close.png'></figure>" +
      "</button>" +
    )

    XXXXXX   Lambdas que no recibe por parámetros nada y tampoco retorna nada:   XXXXXX
    () -> {}
    () -> System.out.println("No recibo nada")
    () -> {
      System.out.println("No recibo nada");
      SpecificObject.setLocalVariable("variable cambiada") // llamado a un metodo que cambia el estado de un objeto externo
      System.out.println("No retorno nada");
    }
    */

}
