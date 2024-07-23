package com.platzi.functional_student_practice._14_optionals;

import java.util.*;

public class C22Optionals {

    static Random randomGenerator = new Random();

    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 22\n");

        // 1. ejemplo iterando con una lista posiblemente vacia
        List<String> names = getNames();
        System.out.println(names.isEmpty()? "1. Lista vacia" : "1. "+names.getFirst());

        // 2. Por cada retorno de un posible null, tenemos que validar que el dato este efecticamente presente
        String name = mostValuablePlayer();
        System.out.println("2. "+((name != null)? name : "Valor 'null' invalido"));

        // 3a. ejemplo con Optional java 8
        Optional<List<String>> optionalNames = getOptionalNames();
        if (optionalNames.isPresent()) optionalNames.get().forEach(x -> System.out.println("3: " + x));
        else System.out.println("3: Optional vacio");

        // 3b. ejemplo con Optional java 9+
        Optional<List<String>> optionalNames2 = getOptionalNames();
        optionalNames2.ifPresentOrElse(
                namesValue -> namesValue.forEach(x -> System.out.println("3b: " + x)),
                () -> System.out.println("3b: Optional vacio"));

        // 4. segundo ejemplo Optional
        System.out.println("4. "+optionalValuablePlayer().orElse("No player"));
    }

    // 1. Al retornar collecctions (lists, hashs, maps, etc), es viable devolver un collection vacio (un wrap a datos inexistentes)
    static List<String> getNames() {
        List<String> list = new LinkedList<>();
        String word = randomStringGenerator();
        if (word != null) list.add(word);
        if (list.isEmpty()) return Collections.emptyList();
        return list;
    }

    // 2. Es mas problematico si tenemos que retornar String null, o un primitivo que represente un "no valor".
    static String mostValuablePlayer() {
        return randomStringGenerator();
    }

    // 2b. ejemplo con primitivo int
    static int mostExpensiveItem() {
        return -1;
        //no se puede devolver un primitivo "sin valor"
    }

    // 3. Optional de lista. en caso de estar vacia se devuelve un Observable vacio (en reemplazo de la lista vacia)
    static Optional<List<String>> getOptionalNames() {
        List<String> namesList = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            String word = randomStringGenerator();
            if (word != null) namesList.add(word);
        }
        if (namesList.isEmpty()) return Optional.empty();
        return Optional.of(namesList);
    }

    // 4. Optional de valor potencialmente null
    static Optional<String> optionalValuablePlayer() {
        //en caso de contener un valor nulo, evita generar un NullPointerException como haría el metodo Optional.of(...)
        return Optional.ofNullable(randomStringGenerator());
    }

    static String randomStringGenerator() {
        double random = randomGenerator.nextDouble();
        if (random < 0.25d) return "Señor Pepe";
        if (random < 0.50d) return "Señor Anderson";
        return null;
    }
}
