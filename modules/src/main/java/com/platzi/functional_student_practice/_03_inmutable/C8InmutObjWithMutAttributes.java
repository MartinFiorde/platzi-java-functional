package com.platzi.functional_student_practice._03_inmutable;

import java.util.List;

public class C8InmutObjWithMutAttributes {

    public static void main(String[] args) {

        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\nCLASS 8\n");

        // 1. We make an inmutable object (without setters)
        Direccion dir = new Direccion("New York");

        // 2. We make a mutable object (with setters)
        Persona p1 = new Persona(dir);

        // 3. We make an inmutable list
        List<Persona> lista1 = List.of(p1);

        // 4. Try to change mutable element from inmutable list is allowed
        System.out.println("Antes de modificar: " + lista1);
        p1.getDireccion().setCiudad("Los Angeles");
        System.out.println("Después de modificar: " + lista1);

    }

    private static class Direccion {
        String ciudad;

        Direccion(String ciudad) {
            this.ciudad = ciudad;
        }

        String getCiudad() {
            return ciudad;
        }

        void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }

        @Override
        public String toString() {
            return ciudad;
        }
    }

    private static class Persona {
        private final Direccion direccion;

        Persona(Direccion direccion) {
            this.direccion = direccion;
        }

        public Direccion getDireccion() {
            return direccion;
        }

        @Override
        public String toString() {
            return "Persona{direccion=" + direccion + "}";
        }
    }

}
