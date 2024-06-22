package com.platzi.functional_student_practice._04_functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class C13CLIUtils {

    public static void main(String[] args) {

        System.out.println("////////////////////////////////////////////////////////////////////////////////////\n");
        System.out.println("CLASS 13\n");

        // 1. Created CLI class, consumer and supplier

        System.out.println("////////////////////////////////////////////////////////////////////////////////////\n");
        System.out.println("CLASS 14\n");

    }


    private static void showHelp(CLIArguments cliArguments) {
        Consumer<CLIArguments> consumerHelper = cliArguments1 -> {
            if (cliArguments1.isHelp()) {
                System.out.println("Manual required");
            }
        };
        consumerHelper.accept(cliArguments);
    }


    private static CLIArguments generateCLI() {
        Supplier<CLIArguments> generator = () -> new CLIArguments();
        return generator.get();
    }


    private static class CLIArguments {
        private boolean isHelp;

        public CLIArguments() {
        }

        public CLIArguments(boolean isHelp) {
            this.isHelp = isHelp;
        }

        public boolean isHelp() {
            return isHelp;
        }
    }

}
