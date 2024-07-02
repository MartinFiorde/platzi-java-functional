package com.platzi.functional_student_practice._10_chaining;


public class C20Chaining {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 20\n");

        // 1. Every .append() method returns "this" object with the changes updated in state.
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hola ")
                .append("alumno")
                .append("!")
                .reverse()
                .append(" :iztalP")
                .reverse();
        System.out.println(stringBuilder);

        // 2. Custom example. This is usefull with FUNCTION COMPOSITION
        Chainer chainer = new Chainer();
        Chainer chainer2 = chainer.sayHi();
        Chainer chainer3 = chainer2.sayBye();
        chainer3.sayHi().sayBye();
    }

    private static class Chainer {
        public Chainer sayHi() {
            System.out.println("Hola");
            return this;
        }

        public Chainer sayBye() {
            System.out.println("Bye");
            return this;
        }
    }
}
