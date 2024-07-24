package com.platzi.functional_student_practice._04_functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class C13CLIUtils {

    public static void main(String[] args) {

        System.out.println("////////////////////////////////////////////////////////////////////////////////////\n");
        System.out.println("CLASS 13\n");

        // 1. Created CLI class, consumer and supplier
        List<CLIArguments> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(generateCLI());
            list.get(i).setHelp(i % 2 == 0);
        }

        for (int i = 0; i < list.size(); i++) {
            showHelp(list.get(i), i);
        }

    }


    private static void showHelp(CLIArguments cliArguments, int i) {
        Consumer<CLIArguments> consumerHelper = cliArguments1 -> {
            if (cliArguments1.isHelp()) {
                System.out.println(i +": Manual required");
            }
        };
        consumerHelper.accept(cliArguments);
    }


    private static CLIArguments generateCLI() {
        Supplier<CLIArguments> generator = CLIArguments::new; //same as () -> new CLIArguments()
        return generator.get();
    }


    private static class CLIArguments {
        private boolean isHelp;

        public boolean isHelp() {
            return isHelp;
        }

        public void setHelp(boolean help) {
            isHelp = help;
        }
    }

}
