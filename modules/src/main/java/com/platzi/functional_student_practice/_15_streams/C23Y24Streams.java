package com.platzi.functional_student_practice._15_streams;

import com.platzi.functional_teacher_theory._06_reference_operator.NombresUtils;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class C23Y24Streams {
    public static void main(String[] args) {
        System.out.println("\n////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 23\n");

        // 1. forma comun de trabajar sobre listas, strings y collections
        List<String> courseList = NombresUtils.getList("Java!", "JavaScript", "FrontEnd", "Backend", "FullStack");
        for (String course : Collections.unmodifiableList(courseList)) {
            String newCourseName = course.toLowerCase().replace("!", "!!!");
            System.out.println("1. Cursos bucle sobre lista: " + newCourseName);
        }
        System.out.println("1. Lista original: " + courseList);

        // 2. genero un supplier que inicia streams nuevos cada vez que es llamado con la misma informacíón de origen
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("Java!", "JavaScript", "FrontEnd", "Backend", "FullStack");

        // 2b. resultado de map generando una lista de integers con el length de cada String
        Stream<Integer> courseLengthStream = streamSupplier.get().map(String::length);
        System.out.println("2b. Lista lengths sobre stream: " + courseLengthStream.toList());

        // 2c. hago un map como en 2b, y imprimo el length mayor
        System.out.println("2c. Mayor length de stream: " + streamSupplier.get().map(String::length).max((x, y) -> y - x).orElse(-1));

        // 2d. genero un supplier que inicia streams nuevos cada vez que es llamado con la misma informacíón de origen, hago un map como en 2b, y imprimo el length mayor
        Stream<String> emphasisCourses = streamSupplier.get().map(course -> course + "!");
        Stream<String> justJavaCourses = emphasisCourses.filter(course -> course.contains("Java"));
        justJavaCourses.forEach(x -> System.out.println("2d. Rtdo final de streams sucesivos: " + x.replace("!", "!!!")));

        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 24\n");

        //2e. genero un stream directamente de la lista original y le aplico un metodo peak en el medio del proceso
        Stream<String> coursesStream2 = courseList.stream();

        peakItems(coursesStream2.filter(course -> course.contains("Java")))
                .map(course -> course + "???")
                .forEach(x -> System.out.println("2e. For each terminal: " + x));
    }

    static <T> Stream<T> peakItems(Stream<T> stream){
        return stream.peek(data -> System.out.println("2e. Peeked data: " + data));
    }
}
