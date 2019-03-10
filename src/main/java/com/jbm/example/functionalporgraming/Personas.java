

package com.jbm.example.functionalporgraming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Colección de {@link Persona}.
 * @author Jairo Medina
 * @since 1.0
 */
public class Personas extends ArrayList<Persona> implements Comparator<Persona> {
    private static final long serialVersionUID = 3586474098190598116L;

    private BiFunction<Persona,Persona,Integer> comparador;
    
    //---Constructores---
    //******************************************************************************************************************
    public Personas() {}
    
    public Personas(int initialCapacity) {
        super(initialCapacity);
    }
    
    
    //******************************************************************************************************************
    /**
     * Compara los dos objetos Persona y devuelve 0: si persona1 es igual a pesona2, -1 si persona1 es menor que persona2,
     * 1 si persona1 es mayor que persona2.
     * @param persona1 Persona a comparar.
     * @param persona2 Pesona a comparar.
     * @return 0: si persona1 es igual a pesona2, -1 si persona1 es menor que persona2, 1 si persona1 es mayor que persona2.
     */
    @Override
    public int compare(Persona persona1, Persona persona2) {
        if(this.comparador!=null){
            return(this.comparador.apply(persona1, persona2)); 
        }else{
            return(persona1.compareTo(persona2));
        }
    }
    
    /**
     * Devuelve un subconjunto de objetos {@link Persona} que cumplen con la condición dada por el {@link Predicate} {@code filtro}.
     * @param filtro Condición de filtrado.
     * @return Subconjunto de personas.
     */
    public Personas subList(Predicate<Persona> filtro){
        Personas subLista = new Personas();
        for(Persona persona : this){
            if(filtro.test(persona)){
                subLista.add(persona);
            }
        }
        return (subLista);
    }
    
    /**
     * Evalua las personas contenidas en esta lista con la condición dada por el {@link Predicate} {@code filtro}
     * y los agrega a la lista {@code lista}.
     * @param filtro Condición de evaluación.
     * @param proveedorList Un supplier que entrega la lista donde se agregarán las Personas que cumplen la condición.
     * @return Lista de personas filtradas.
     */
    public Personas subList(Predicate<Persona> filtro, Supplier<Personas> proveedorList){
        for(Persona persona : this){
            if(filtro.test(persona)){
                proveedorList.get().add(persona);
            }
        }
        return(proveedorList.get());
    }
    
    /**
     * Evalua las personas contenidas en esta lista con la condición dada en {@code filtro}
     * y entrega en el {@code separador} los objetos indicando si fue aceptado o rechazado. Esto permite
     * que se puedan construir dos listas o procesarlos pero desde afuera.
     * @param filtro Condición de evaluación.
     * @param separador Un {@link BiConsumer} el cual recibe los objetos aceptados y rechazados.
     */
    public void subList(Predicate<Persona> filtro, BiConsumer<Persona,Boolean> separador){
        for(Persona persona : this){
            if(filtro.test(persona)){
                separador.accept(persona, true);
            }else{
                separador.accept(persona, false);
            }
        }
    }
    
    /**
     * Devuelve un subconjunto de objetos {@link Persona} evaluando la edad y el género de las personas contenidas en 
     * esta lista con la condición dada en {@code filtro}.
     * @param filtro Condición de filtrado.
     * @return Subconjunto de personas.
     */
    public Personas subList(BiPredicate<Integer,String> filtro){
        Personas subLista = new Personas();
        for(Persona persona : this){
            if(filtro.test(persona.getEdad(), persona.getGenero())){
                subLista.add(persona);
            }
        }
        return(subLista);
    }
    
    /**
     * 
     * @param clasificador
     * @return 
     */
    public Persona getMejor(BinaryOperator<Persona> clasificador){
        Persona personaMayor = this.isEmpty()? null : this.get(0);
        for(int i=0; i< this.size(); i++){
            personaMayor = clasificador.apply(personaMayor, this.get(i));
        }
        return(personaMayor);
    }
    
    /**
     * Devuelve la persona Mayor, según la condición definida en el Comparador.
     * Si el comparador no se ha establecido, se utiliza el comparador por defecto definid en esta clase.
     * @return Persona mayor.
     */
    public Persona  getMayor(){
        return(this.getMejor(BinaryOperator.maxBy(this)));
    }
    
    /**
     * Devuelve la persona Menor, según la condición definida en el Comparador.
     * Si el comparador no se ha establecido, se utiliza el comparador por defecto definid en esta clase.
     * @return Persona menor.
     */
    public Persona  getMenor(){
        return(this.getMejor(BinaryOperator.minBy(this)));
    }
    
    
    //---Métodos Especiales---
    //******************************************************************************************************************
    public void setComparador(BiFunction<Persona,Persona,Integer> comparador){
        this.comparador = comparador;
    }
    public BiFunction<Persona,Persona,Integer> getComparador(){
        return(this.comparador);
    }
}
