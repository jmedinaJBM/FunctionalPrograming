

package com.jbm.example.functionalporgraming;

import java.util.Calendar;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Ejemplos de Programación Funcional en Java con {@link java.util.function} package.
 * @author Jairo Medina
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        
        //---Definición del Function.
        Function<Date,Integer> calculadorEdad = (Date fechaNacimiento) -> {
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaNacimiento);
            Calendar calHoy = Calendar.getInstance();
            calHoy.setTimeInMillis(System.currentTimeMillis());
            int edad = calHoy.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
            return(edad);
        };
        
        //---Definición del BiFunction--- Comparador de Nombre.
        BiFunction<Persona,Persona,Integer> comparadorNombre = (Persona per1, Persona per2) -> {
            int result = per2.getNombre().compareTo(per1.getNombre());
            return(result);
        };
        
        //---Definición del BiFunction--- Comparador de Género y Nombre, para ordenar por ellos.
        BiFunction<Persona,Persona,Integer> comparadorGeneroNombre = (Persona per1, Persona per2) -> {
            int resultG = per1.getGenero().compareTo(per2.getGenero()); //compara las letras F vs M.
            int result = resultG==0? per1.getNombre().compareTo(per2.getNombre()) : resultG;
            return(result);
        };
        
        //---Definición del Consumer--- imprime por consola los datos de la persona.
        Consumer<Persona> imprimePersona = (Persona p) -> {
            System.out.println(p.getId() +" -> "+p.getNombre()+" "+p.getApellido() + " "+p.getEdad()+ " "+p.getGenero());
        };
        
        //---Definición del Predicate--- Filtrar menores de 18 años.
        Predicate<Persona> filtroEdad = (Persona per) -> {
            boolean menor = per.getEdad() < 18;
            return(menor);
        };
        
        //---Creación de la lista de Personas---
        Personas personas = getListPersonas(10);
        
        personas.forEach((Persona p) -> p.setCalculadorEdad(calculadorEdad));
        
        System.out.println("\n---RESULTADO: ANTES de ORDENAR x NOMBRE---");
        personas.forEach(imprimePersona);       //<--- consumer en funcionamiento.
        
        personas.setComparador(comparadorNombre);   //<--- estableciendo el comparador de Nombre.
        personas.sort(personas);                //<--- comparador en funcionamiento.
        
        System.out.println("\n---RESULTADO: ORDENADO x NOMBRE---");
        personas.forEach(imprimePersona);       //<--- Consumer en funcionamiento.
        
        personas.setComparador(comparadorGeneroNombre); //<--- estableciendo el comparador de Género y Nombre.
        personas.sort(personas);
        System.out.println("\n---RESULTADO: ORDENADO x GENERO y NOMBRE---");
        personas.forEach(imprimePersona);       //<--- consumer en funcionamiento.
        
        Personas personasMenores = personas.subList(filtroEdad); //<--- predicado en funcionamiento.
        System.out.println("\n---RESULTADO: MENORES DE EDAD---");
        personasMenores.forEach(imprimePersona);        //<--- consumer en funcionamiento.
        
        
        //---Definición de un Supplier---
        Personas personasMenores2 = new Personas();
        Supplier<Personas> menores2 = () -> personasMenores2;
        
        personas.subList(filtroEdad, menores2);    //<--- supplier en funcionamiento.
        System.out.println("\n---RESULTADO: MENORES DE EDAD CON SUPPLIER---");
        personasMenores2.forEach(imprimePersona);        //<--- consumer en funcionamiento.
        
        //---Definición de un BiConsumer--- para identificar si las personas cumplen o no una condición.
        BiConsumer<Persona,Boolean> separador = (Persona persona, Boolean resultado) -> {
            System.out.print((resultado? "ACEPTADO" : "RECHAZADO")+ " \t");
            imprimePersona.accept(persona);
        };
        System.out.println("\n---RESULTADO: PERSONAS ACEPTADAS Y RECHAZADAS---");
        personas.subList(filtroEdad, separador);        //<--- biconsumer en funcionamiento.
        
        
        //---Definición de un BinaryOperator--- Para buscar la persona de Mayor edad.
        BinaryOperator<Persona> clasificadorMayor = (Persona per1, Persona per2) -> {
            return(per2.getEdad() > per1.getEdad()? per2 : per1);
        };
        
        BinaryOperator<Persona> clasificadorMenor = (Persona per1, Persona per2) -> {
            return(per2.getEdad() < per1.getEdad()? per2 : per1);
        };
        
        Persona personaMayor = personas.getMejor(clasificadorMayor);    //<--- operador binario en funcionamiento.
        personas.setComparador(null);                                   //<--- para usar el comparador predefinido en la clase Persona.
        Persona personaMayor2= personas.getMayor();
        System.out.println("\n---RESULTADO: PERSONA MAYOR---");
        imprimePersona.accept(personaMayor2);
        
        Persona personaMenor = personas.getMejor(clasificadorMenor);    //<--- operador binario en funcionamiento.
        Persona personaMenor2 = personas.getMenor();
        System.out.println("\n---RESULTADO: PERSONA MENOR---");
        imprimePersona.accept(personaMenor2);
        
        //---Definiendo un BiPredicate--- para evaluar edad y genero.
        BiPredicate<Integer,String> filtroHombresMenores = (Integer edad, String genero) -> {
            boolean seleccionado = false;
            if(edad < 18 && "M".equals(genero)){
                return(true);
            }
            return(false);
        };
        Personas hombresMenores = personas.subList(filtroHombresMenores);   //<--- bipredicado en funcionamiento.
        System.out.println("\n---RESULTADO: HOMBRES MENORES DE EDAD---");
        hombresMenores.forEach(imprimePersona);                         //<--- consumer en funcionamiento.
        
    }
    
    
    /**
     * Construye la lista de Personas.
     * @param size Tamaño de la lista.
     * @return Lista de Personas.
     */
    private static Personas getListPersonas(int size){
        Personas listaPersonas = new Personas(size);
        int ano = 1995, mes = 1, dia = 1;
        Calendar calendario = Calendar.getInstance();
        calendario.set(ano, mes, dia);
        for(int i=0; i<size; i++){
            Persona persona = new Persona(i,"Nombre-"+i,"Apellido-"+i);
            persona.setFechaNacimiento(calendario.getTime());
            persona.setGenero(i%2!=0? "F" : "M");
            listaPersonas.add(persona);
            calendario.add(Calendar.YEAR, 1);
        }
        return(listaPersonas);
    }
}
