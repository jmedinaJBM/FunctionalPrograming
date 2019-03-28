# Progamación Funcional Java

## Tabla de Contenido
- [Introducción](#introducción)
- [Interfaces Funcionales Java](#interfaces-funcionales-java)
    - [1. Function<T,R>](#1-function)
    - [2. Consumer\<T>](#2-consumer)
    - [3. Predicate\<T>](#3-predicate)
    - [4. Supplier\<T>](#4-supplier)
    - [5. BiConsumer<T,U>](#5-biconsumer)
    - [6. BiFunction<T,U,R>](#6-bifunction)
    - [7. BinaryOperator\<T>](#7-binaryoperator)
    - [8. BiPredicate<T,U>](#8-bipredicate)
    - [9. UnaryOperator\<T>](#9-unaryoperator)
- [Requisitos del Proyecto Java](#requisitos-del-proyecto-java)
- [Ejemplos con Java](#ejemplos-con-java)

## Introducción
### Qué es Programación Funcional?
Es un paradigma de programación basado en el concepto de funciones matemáticas. En java básicamente se programa siguiendo el paradigma imperativo, donde se escriben sentencias de forma secuencial donde se ven claramente las instrucciones de forma ordenada. Con la programación funcional, la cosa cambia un poco y algunas veces no es tan fácil de entender, pero cuando conoces los conceptos, todo se vuelve comprensible.

Una función en matemáticas se representa así:   **``Y = f (x)``** ;  donde **x** es una variable que determina el valor de **Y**. En la programación funcional, al igual que en matemáticas, se pueden definir expresiones con más de una variable para obtener un resultado en **Y**.
En Java, a partir de la versión 8 (*Java Standard Edition 8*), hay disponible diferentes elementos que explotan al máximo la programación funcional, entre ellos están las *Interfaces Funcionales* y el Operador Lamda `->`. 

## Interfaces Funcionales Java
Es una interface como cualquiera, pero con la anotación **_@FunctionalInterface_** y que define un único método abstracto a ser implementado. Están definidas en el paquete _java.util.function_. Utilizadas exclusivamente en la programación funcional en Java. A continuación una explicación breve de cada una.

### 1. Function 
[Function<T,R>](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html) Similar a una función matemática de dos variables **`R = f(T)`**, donde **T** representa el valor de la variable *x* , **R** es el tipo de dato del valor resultante que debe devolver la función. En Java se expresa así: **`(T param) -> R `** Puede apreciarse el operador Lamda formado por el guión junto con el símbolo mayor que: `->`.  Los paréntesis son parte de la expresión. Sin el operador Lamda, en Java se ve así: **`R  apply(T param)`**. <br/>
Se utiliza para hacer un cálculo con el valor de `T` y obtener como resultado un valor de tipo _R_ que debe ser retornado; en el ejemplo calcularemos la edad de una persona dada su fecha de nacimiento. <br/><br/>
### 2. Consumer
[Consumer\<T>](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html) Similar a *Function<T,R>*, con la diferencia, como puede apreciarse, no tiene la *R*, esto significa que no devuelve un valor. En Java se expresa así: **`(T param) -> `**  Sin el operador Lamda, se vería así:  **`void accept(T param)`**.<br/>
Se utiliza para realizar alguna operación con el valor de *T*, pero sin devolver nada, puede ser una operación de guardado o de impresión.<br/><br/>
### 3. Predicate
[Predicate\<T>](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html) Similar a *Function<T,R>*, con la diferencia de que el valor a devolver siempre es un valor lógico (*Boolean:  true,  false*). En Java se expresa así: **`(T param) -> boolean`** Sin el operador Lamda, se vería así:  **`boolean test(T param)`**. <br/>Se utiliza para realizar operaciones lógicas, generalmente en operaciones de búsqueda o de filtrado.<br/><br/>
### 4. Supplier
[Supplier\<T>](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html) Su traducción al español es Proveedor. Significa que provee un objeto de tipo **T**, pero no recibe ningún parámetro. En Java se expresa así: **`() -> T `** Sin el operador Lamda, se vería así:  **`T get()`** .<br/>Se utiliza generalmente para proveer objetos contenedores como los *List*.<br/><br/>
### 5. BiConsumer 
[Biconsumer<T,U>](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html) Similar a *Consumer\<T>*, con la diferencia de que este recibe dos parámetros, uno de tipo **T** y otro de tipo **U** No devuelve valor alguno. En Java se expresa así:  **`(T paramT, U paramU) ->`**  Sin el operador Lamda se vería así:  **`void accept(T paramT, U paramU)`**.<br/>Se utiliza en casos similares en donde se utiliza el *Consumer\<T>*, donde se requiere hacer algún tipo de operación con los dos parámetros que entrega; en el ejemplo veremos como se implementa un *Separador*.<br/><br/>
### 6. BiFunction
[BiFunction<T,U,R>](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html) Es una función de 3 variables **``Y= f(x,z)``** donde **T** representa el valor de la variable *x*, **U** representa el valor de la variable *z* y **R** es el tipo de dato del valor resultante que debe devolver la función. En Java se expresa así:  **`(T,U) -> R`** Sin el operador Lamda se vería así: **` R apply(T paramT, U paramU)`**. <br/> Sus usos son poco comunes; en el ejemplo veremos como se implementa un *Comparador*.<br/><br/>
### 7. BinaryOperator 
[BinaryOperator\<T>](https://docs.oracle.com/javase/8/docs/api/java/util/function/BinaryOperator.html) Operador Binario; es un *BiFunction<T,T,T>* esto es que recibe en parámetro dos objetos de tipo **T** pero devuelve uno de los dos objetos. En Java se expresa así:  **`(T,T) -> T`** Sin el operador Lamda se vería así:<br/>  **`T apply(T paramT1, T paramT2)`**. No define su propio método abstracto porque ya tiene el que hereda de *BiFunction<T,T,T>*; pero cuenta con dos métodos estáticos (*minBy, maxBy*) los que son bastante utilizados más que apply.<br/> Sus usos son poco comunes, en el ejemplo veremos como se implementa un *Clasificador* y como se utilizan los métodos *minBy*, *maxBy*. <br/><br/>
### 8. BiPredicate
[BiPredicate<T,U>](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiPredicate.html) Similar a un *Predicate\<T>*, pero con la diferencia de que recibe 2 parámetros a evaluar y devuelve un valor lógico (*Boolean:  true,  false*).  En Java se expresa así:  **`(T,U) -> boolean`**  Sin el operador Lamda se vería así:  **`boolean test(T paramT, U paramU)`**.<br/> Al igual que *Predicate\<T>* se utiliza para realizar operaciones lógicas, generalmente en operaciones de búsqueda o de filtrado.<br/><br/>
### 9. UnaryOperator
[UnaryOperator\<T>](https://docs.oracle.com/javase/8/docs/api/java/util/function/UnaryOperator.html) Opereador Unario; es un *Function<T,T>*, esto es que recibe en parámetro un objeto de tipo **T** y devuelve el mismo u otro objeto del mismo tipo **T**.  En Java se expresa así:  **`(T) -> T`**  Sin el operador Lamda, se vería así: <br/> **`T apply(T param)`** .  No define su propio método abstracto porque ya tiene el que se hereda de *Function<T,T>*, pero cuenta con el método estático (*identity*) el cual es bastante utilizado más que apply , heredado de *Function<T,T>*.<br/>Su uso es bastante pobre, pero básicamente es utilizado donde se requiere un *Function<T,T>*, pero que no se pretende hacer ningún cálculo y simplemente se devuelve el objeto **T**. <br/><br/>

## Requisitos del Proyecto Java
1. [NetBeans 8.2](https://netbeans.org/downloads/)
2. [Java SE JDK 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html?fbclid=IwAR21GQMtgfZY7ZzLscX538bwGPkzqT8ap2jXCFUy0Ycnmxqy4hEDja7XPJo) update más reciente.
3. [Apache Maven 3.6](https://www-us.apache.org/dist/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.zip?fbclid=IwAR2pO8S7v5Frm0eKYDoTemFWSu7w0fIYOIXsDrmrthNlUKGHQbF6uN5TkoM)

## Ejemplos con Java
Los ejemplos que incluyo en esta nota, son ejemplos básico, con fines ilustrativos; para ello he creado dos clases, **Persona** y **Personas**. *Persona* es una clase para crear objetos que representen los datos de una Persona, valga la redundancia, esto es: id, nombre, apellido, fecha de nacimiento y genero. *Personas* es una lista definida como *ArrayList\<Persona>* para contener elementos de tipo *Persona*.  Crearemos una lista de personas en una variable que llamaremos **_personas_**, (en minúscula) y con esta lista vamos ejemplificar el uso de las *Interfaces Funcionales*. <br/><br/> Puede verse, la función que recibe en parámetro la fecha de nacimiento y devuelve la edad calculada. **Date** es el tipo de dato del parámetro *fechaNacimiento*, **Integer** es el tipo de dato de la edad calculada a devolver. <br/> A continuación se establece la función *calculadorEdad* a cada elemento de la lista personas; de manera que al llamar al método **getEdad()**, hará un llamado a esta función con la fecha de nacimiento y devolverá la edad calculada.

1. **Function<Date,Integer>**<br/> En la clase *Persona*, la edad es un valor calculado en función de la fecha de nacimiento. Para ello *Persona* tiene el método **setCalculadorEdad** que se utiliza para definir un *Function<Date,Integer>* que se ocupa de calcular la edad. <br/>
```java
Function<Date,Integer> calculadorEdad = (Date fechaNacimiento) -> {
    Calendar cal = Calendar.getInstance();
    cal.setTime(fechaNacimiento);
    Calendar calHoy = Calendar.getInstance();
    calHoy.setTimeInMillis(System.currentTimeMillis());
    int edad = calHoy.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
    return(edad);
};
``` 
```java
personas.forEach((Persona p) -> p.setCalculadorEdad(calculadorEdad));
```
```java
//---Método getEdad() en la clase Persona---
public Integer  getEdad() throws IllegalStateException {
    if(this.calculadorEdad==null){
        throw new IllegalStateException("Calculador de edad no definido");
    }
    return(this.calculadorEdad.apply(this.fechaNacimiento));
}
```
---
2. **Consumer\<Persona>**<br/>En este ejemplo veremos como se utiliza el consumer, de hecho en el ejemplo anterior, hay dos ejemplos de *Consumer*; uno de ellos lo detallamos aquí.<br/>
El consumer **imprimePersona** solamente recibe el parámetro **p** de tipo *Persona* y lo utiliza para imprimir por consola los datos correspondientes del objeto *p*, pero no retorna valor alguno.
```java
//---Definición del Consumer--- imprime por consola los datos de la persona.
Consumer<Persona> imprimePersona = (Persona p) -> {
    System.out.println(p.getId() +" -> "+p.getNombre()+" "+p.getApellido() + " "+p.getEdad()+ " "+p.getGenero());
};

personas.forEach(imprimePersona);       //<--- consumer en funcionamiento.
```
----
3. **Predicate\<Persona>** <br/> Para este caso, vamos a crear un *Predicate\<Persona>* que llamaremos **filtroEdad**, que nos permita obtener de la lista de personas, las Personas que sean menores de *18 años*; y en la clase *Personas*, creamos un método **subList** que recibirá en parámetros el *Predicate\<Persona> filtroEdad*, que utiliza para filtrar las personas contenidas en la lista según las condiciones definidas en el *Predicate\<Persona>* dado en el parámetro filtro. <br/> puede verse que el predicate *filtroEdad*, recibe el parámetro **per** de tipo *Persona* y determina si el objeto es menor de 18 años, de ser así devuelve *true*.
```java
//---Método subList en la clase Personas---
public Personas subList(Predicate<Persona> filtro){
    Personas subLista = new Personas();
    for(Persona persona : this){
        if(filtro.test(persona)){
            subLista.add(persona);
        }
    }
    return (subLista);
}
```
```java
//---Definición del Predicate--- Filtrar menores de 18 años.
Predicate<Persona> filtroEdad = (Persona per) -> {
    boolean menor = per.getEdad() < 18;
    return(menor);
};

Personas personasMenores = personas.subList(filtroEdad); //<--- predicado en funcionamiento.
System.out.println("\n---RESULTADO: MENORES DE EDAD---");
personasMenores.forEach(imprimePersona);        //<--- consumer en funcionamiento.
```
----
4.  **Supplier\<Persona>** <br/> Para ilustrar este ejemplo, crearemos un segundo método **subList** en la clase *Personas* con la variante que le agregamos un segundo parámetro, este es un *Supplier\<Persona>* que llamaremos **proveedorLista**, el cual proporciona una lista vacía donde se agregarán los objetos *Persona* que cumplan la condición dada en el parámetro **filtro**. Utilizaremos el mismo *Predicate* **filtroEdad** que hemos definido antes para obtener las personas menores de 18 años, pero en lugar de soloamente retornarlas, las agregaremos a la lista que proporciona **proveedorLista**. <br/><br/>
En la definición del Supplier que hemos nombrado **menores2**, primero hemos creado la lista *personasMenores2* y seguido el Supplier *menores2* que retorna la lista creada. Finalmente tenemos el llamado al método *subList* con el Supplier *menores2*  y con el mismo Predicate *filtroEdad* definido para el ejemplo anterior. El resultado que se obtiene es el mismo, una lista con las personas menores de 18 años.
```java
//---Método sublist de la clase Personas con Predicate<Persona> y Supplier<Persona>---
public Personas subList(Predicate<Persona> filtro, Supplier<Personas> proveedorList){
    for(Persona persona : this){
        if(filtro.test(persona)){
            proveedorList.get().add(persona);
        }
    }
    return(proveedorList.get());
}
```
```java
//---Definición de un Supplier---
Personas personasMenores2 = new Personas();
Supplier<Personas> menores2 = () -> personasMenores2;

//---Utilizando subList con el supplier menores2---
personas.subList(filtroEdad, menores2);    //<--- supplier en funcionamiento.
System.out.println("\n---RESULTADO: MENORES DE EDAD CON SUPPLIER---");
personasMenores2.forEach(imprimePersona);        //<--- consumer en funcionamiento.
        
```
----
5.  **BiConsumer<Persona, Boolean>** <br/> Para ilustrar este ejemplo, hemos construido un *Consumer* que llamaremos **separador**, (un concepto creado para este ejemplo), que utilizaremos en un nuevo método **subList** creado en la clase *Personas*; este en lugar de devolvernos en una lista las personas menores de 18, nos entregará cada persona indicándonos si ha sido aceptada o rechazada, de acuerdo al criterio del *Predicate filtroEdad* definido anteriormente. Esto nos da la oportunidad de decidir que hacer con cada objeto aceptado y/o rechazado. <br/><br/>
En la definición del *BiConsumer* **separador**, vemos que este recibe 2 parámetros: el parámetro *persona* de tipo *Persona* y resultado de tipo *Boolean*, donde se indica *true* si es aceptado (es menor de 18) o *false* y si es rechazado (no es menor de 18). De esta forma se tiene la oportunidad de procesar todos los elementos y decidir que hacer con estos, identificando los aceptados y rechazados; en este ejemplo solo se imprime por consola si es Aceptado o Rechazado cada objeto *Persona*. El llamado al método **subList** se realiza con *filtroEdad* y *separador*.
```java
//---Método subList en la clase Personas---
public void subList(Predicate<Persona> filtro, BiConsumer<Persona,Boolean> separador){
    for(Persona persona : this){
        if(filtro.test(persona)){
            separador.accept(persona, true);
        }else{
            separador.accept(persona, false);
        }
    }
}
```
```java
//---Definición de un BiConsumer--- para identificar si las personas cumplen o no una condición.
BiConsumer<Persona,Boolean> separador = (Persona persona, Boolean resultado) -> {
    System.out.print((resultado? "ACEPTADO" : "RECHAZADO")+ " \t");
    imprimePersona.accept(persona);
};
System.out.println("\n---RESULTADO: PERSONAS ACEPTADAS Y RECHAZADAS---");
personas.subList(filtroEdad, separador);        //<--- biconsumer en funcionamiento.
```
-----
6.  **BiFunction<Persona,Persona,Integer>** <br/>Para este ejemplo vamos a construir un **comparador** utilizando las interface *[Comparator\<T>](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)* y *[Comparable\<T>](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)*. Básicamente un comparador sirve para ordenar una lista de elementos determinando si un elemento es menor, igual o mayor que otro. Para ello la clase *Persona* debe implementar la interface **Comparable** y la clase *Personas* debe implementar la interface *Comparator* y también definir un método para establecer el comparador, un *BiFunction* que recibe 2 objetos *Persona* y que devuelve un valor entero.<br/><br/>
El *BiFunction* que hemos nombrado **comparadorNombre**, este recibe dos objetos de tipo *Persona* **per1** y **per2** y devuelve un valor entero como resultado de la comparación entre los nombres de ambos objetos.<br/><br/>
En la clase *Personas* se implementa el método **compare**, que recibe los dos objetos *Persona* a comparar, **persona1** y **persona2**, los que son pasados en parámetros al apply del comparador. Si el comparador (el BiFunction) no se ha establecido, entonces se utiliza la comparación definida por defecto en los objetos *Persona*, la comparación se realiza con la edad.  Finalmente establecemos **comparadorNombre** con **setComparador(comparadorNombre)** en la lista personas (objeto de la clase Personas) y llamamos al método **personas.sort(personas)**; al recorrer la lista personas e imprimir por consola cada objeto veremos la lista ordenada por nombre.
```java
//---Implementación del método compare en la clase Personas---
@Override
public int compare(Persona persona1, Persona persona2) {
    if(this.comparador!=null){
        return(this.comparador.apply(persona1, persona2)); 
    }else{
        return(persona1.compareTo(persona2));
    }
}
```
```java
//---Implementación del método compareTo en la clase Persona---
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
```
```java
//---Definición del BiFunction--- Comparador de Nombre.
BiFunction<Persona,Persona,Integer> comparadorNombre = (Persona per1, Persona per2) -> {
    int result = per2.getNombre().compareTo(per1.getNombre());
    return(result);
};

//---Estableciendo comparadorNombre utilizando setComparador de la clase Personas---
personas.setComparador(comparadorNombre);   //<--- estableciendo el comparador de Nombre.
personas.sort(personas);                //<--- comparador en funcionamiento.
```
-----
7.  **BinaryOperator\<Persona>** <br/> Recordemos que el [BinaryOperator\<T>](https://docs.oracle.com/javase/8/docs/api/java/util/function/BinaryOperator.html) es un [BiFunction<T,T,T>](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html) que recibe dos objetos del mismo tipo y devuelve uno de ellos; es por eso que su función básica es elegir a uno de los dos objetos presentados. Como ejemplo tenemos un *Clasificador* que recibe en parámetro dos objetos de tipo *Persona*, **per1** y **per2**,  evalúa una condición para decidir cual elegir y devolverlo. Además, en la clase *Personas*, hemos creado el método llamado **getMejor** que recibe en parámetro un *clasificador*, que es un *BinaryOperator\<Persona>*, y devuelve un objeto *Persona* como resultado de la clasificación. <br/><br/> 
Podemos ver la definición del **clasificadorMayor** que evalúa la edad de los dos objetos de tipo *Persona*, **per1** y **per2**, y devuelve el de mayor edad. Luego se hace el llamado al método *personas*.**getMejor**(*clasificadorMayor*) que devolverá la persona Mayor de todas en la lista.
```java
//---Método getMejor de la clase Persona---
public Persona getMejor(BinaryOperator<Persona> clasificador){
    Persona personaMayor = this.isEmpty()? null : this.get(0);
    for(int i=0; i< this.size(); i++){
        personaMayor = clasificador.apply(personaMayor, this.get(i));
    }
    return(personaMayor);
}
```
```java
//---Definición de un BinaryOperator--- Para buscar la persona de Mayor edad.
BinaryOperator<Persona> clasificadorMayor = (Persona per1, Persona per2) -> {
    return(per2.getEdad() > per1.getEdad()? per2 : per1);
};

//---Llamado al método getMejor con el BinaryOperator clasificadorMayor---
Persona personaMayor = personas.getMejor(clasificadorMayor);    //<--- operador binario en funcionamiento.
personas.setComparador(null);                                   //<--- para usar el comparador predefinido en la clase Persona.
Persona personaMayor2= personas.getMayor();
```
----
8.  **BiPredicate<Integer,String>**<br/> Crearemos un filtro con un [BiPredicate<T,U>](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiPredicate.html) que llamaremos **filtroHombresMenores** y crearemos un método **subList** en la clase *Personas* que reciba en parámetros este *BiPredicate*, que al ser llamado el método **test**, reciba en parámetros la edad y el género de la persona; **filtroHombreMenores** devolvelrá *true* si es menor de 18 años y masculino. <br/><br/>
En el ejemplo vemos la definición del *BiPredicate* **filtroHombresMenores**. Recibe en parámetros la edad de tipo *Integer* y el genero de tipo *String* (un valor *M* o *F*); evalúa si es menor de 18 años y si es Masculino (M) y devuelve *true* si es el caso.<br/>
EN la definición del método **subList** en la clase *Personas*, recibe el parámetro **filtro**, un *BiPredicate*, que utiliza para evaluar cada objeto Persona de la lista, llamando al método **test**; finalmente el método *subList*, devuelve el conjunto de objetos Persona que cumplen con la condición definida en el *BiPredicate* **filtro**, en un objeto de tipo *Personas*.
```java
//---Método subList con un BiPredicate en la clase Personas---
public Personas subList(BiPredicate<Integer,String> filtro){
    Personas subLista = new Personas();
    for(Persona persona : this){
        if(filtro.test(persona.getEdad(), persona.getGenero())){
            subLista.add(persona);
        }
    }
    return(subLista);
}
```
```java
//---Definiendo un BiPredicate--- para evaluar edad y genero.
BiPredicate<Integer,String> filtroHombresMenores = (Integer edad, String genero) -> {
    boolean seleccionado = false;
    if(edad < 18 && "M".equals(genero)){
        return(true);
    }
    return(false);
};

//---Llamado al método subList con el BiPredicate---
Personas hombresMenores = personas.subList(filtroHombresMenores);   //<--- bipredicado en funcionamiento.
System.out.println("\n---RESULTADO: HOMBRES MENORES DE EDAD---");
hombresMenores.forEach(imprimePersona);                         //<--- consumer en funcionamiento.      
```

