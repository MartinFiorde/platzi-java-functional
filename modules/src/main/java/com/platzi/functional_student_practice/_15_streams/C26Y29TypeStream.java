package com.platzi.functional_student_practice._15_streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C26Y29TypeStream {
    public static void main(String[] args) {
        System.out.println("\n////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 26\n");

        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1); //se genera un stream infinito
        IntStream limitedStream = infiniteStream.limit(1000); // se limita el stream para poder trabajarlo
        boolean isAllEven = limitedStream
                .filter(x -> x % 2 == 0)
                .allMatch(x -> x % 2 == 0); // valida que todos los elementos cumplan con una condición. util para validar existencia de datos, limites, etc
        System.out.println("all even? " + isAllEven);

        IntStream infiniteStream2 = IntStream.iterate(0, x -> x + 1);
        System.out.println("paralel sum: "+infiniteStream2
                .limit(1000000)
                .parallel() // sirve para distribuir todos los calculos del stream distribuidos automaticamente en todos los procesadores del equipo
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum));

        System.out.println("\n////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 29\n");

        String pairNumbersAsIndividualString = IntStream.iterate(0, x -> x + 1)
                .limit(1000)
                .filter(x -> x % 2 == 0)
                .boxed() // transforma el IntStream a un Stream<Integer>
                .map(Object::toString) // transformamos a un Stream<String> para poder aplicar el map siguiente
                .collect(Collectors.joining(",","[","]")); // transformamos el stream para que entregue un String con todos los datos separados con "," entre corchetes
        System.out.println("List as collected individual String: " + pairNumbersAsIndividualString);
        String[] listAsStrings = pairNumbersAsIndividualString.substring(1, pairNumbersAsIndividualString.length() - 2).split(",");
        System.out.println("count: " + Stream.of(listAsStrings).count());
        System.out.println("sum: " + Stream.of(listAsStrings).map(Integer::valueOf).reduce(0, Integer::sum));

    }
}
