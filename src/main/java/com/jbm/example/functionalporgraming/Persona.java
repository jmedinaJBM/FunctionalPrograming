
package com.jbm.example.functionalporgraming;

import java.util.Date;
import java.util.function.Function;

/**
 * Representa un ser humano.
 * @author Jairo Medina
 * @since 1.0
 */
public class Persona implements Comparable<Persona>{
    private Integer id;
    private String  nombre,apellido,genero;
    private Date    fechaNacimiento;
    
    private Function<Date,Integer> calculadorEdad;

    //---Constructores---
    //******************************************************************************************************************
    public Persona() {}

    public Persona(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    //---Propiedades---
    //******************************************************************************************************************
    public Integer  getId() {
        return id;
    }
    public void     setId(int id) {
        this.id = id;
    }

    public Integer  getEdad() throws IllegalStateException {
        if(this.calculadorEdad==null){
            throw new IllegalStateException("Calculador de edad no definido");
        }
        return(this.calculadorEdad.apply(this.fechaNacimiento));
    }

    public String   getNombre() {
        return nombre;
    }
    public void     setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String   getApellido() {
        return apellido;
    }
    public void     setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String   getGenero() {
        return genero;
    }
    public void     setGenero(String genero) {
        this.genero = genero;
    }

    public Date     getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void     setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //---Comparador por Defecto---
    //******************************************************************************************************************
    /**
     * Compara la edad de este objeto con el objeto dado en {@code persona } 
     * @param persona Persona a comparar.
     * @return 0: son iguales. -1 es menor. 1 es mayor.
     * @throws IllegalStateException
     * @throws NullPointerException 
     */
    @Override
    public int compareTo(Persona persona) throws IllegalStateException, NullPointerException {
        if(this.fechaNacimiento==null){
            throw new IllegalStateException("La fecha de nacimiento es null");
        }
        if(persona==null){
            throw new NullPointerException ("El objeto a comprar es null");
        }
        if(persona.getFechaNacimiento()==null){
            throw new NullPointerException ("La fecha de nacimiento del objeto a comprar es null");
        }
        int edad = this.getEdad();
        int result = this.getEdad().intValue()==persona.getEdad().intValue() ? 0 : edad < persona.getEdad() ? -1 : 1;
        return(result);
    }
    
    //---Métodos Especiales---
    //******************************************************************************************************************
    public void setCalculadorEdad(Function<Date,Integer> calculador){
        this.calculadorEdad = calculador;
    }
    public Function<Date,Integer> getCalculadorEdad(){
        return(this.calculadorEdad);
    }

}
