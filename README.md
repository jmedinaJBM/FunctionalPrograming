# Progamación Funcional Java

## Qué es Programación Funcional?

Es un paradigma de programación basado en el concepto de funciones matemáticas. En java básicamente se programa siguiendo el paradigma imperativo, donde se escriben sentencias de forma secuencial donde se ven claramente las instrucciones de forma ordenada. Con la programación funcional, la cosa cambia un poco y algunas veces no es tan fácil de entender, pero cuando conoces los conceptos, todo se vuelve comprensible.

Una función en matemáticas se representa así:   **``Y = f (x)``** ;  donde **x** es una variable que determina el valor de **Y**. En la programación funcional, al igual que en matemáticas, se pueden definir expresiones con más de una variable para obtener un resultado en **Y**.
En Java, a partir de la versión 8 (*Java Standard Edition 8*), hay disponible diferentes elementos que explotan al máximo la programación funcional, entre ellos están las *Interfaces Funcionales* y el Operador Lamda `->`. 

## Interfaces Funcionales Java
Es una interface como cualquiera, pero con la anotación **_@FunctionalInterface_** y que define un único método abstracto a ser implementado. Están definidas en el paquete _java.util.function_. Utilizadas exclusivamente en la programación funcional en Java. A continuación una explicación breve de cada una.

1.  **Function<T,R>:** Similar a una función matemática de dos variables **`R = f(T)`**, donde **T** representa el valor de la variable *x* , **R** es el tipo de dato del valor resultante que debe devolver la función. En Java se expresa así: **`(T param) -> R `** Puede apreciarse el operador Lamda formado por el guión junto con el símbolo mayor que: `->`.  Los paréntesis son parte de la expresión. Sin el operador Lamda, en Java se ve así: **`R  apply(T param)`**. <br/>
Se utiliza para hacer un cálculo con el valor de `T` y obtener como resultado un valor de tipo _R_ que debe ser retornado; en el ejemplo calcularemos la edad de una persona dada su fecha de nacimiento.<br/><br/>
2.  **Consumer\<T>:** Similar a *Function<T,R>*, con la diferencia, como puede apreciarse, no tiene la *R*, esto significa que no devuelve un valor. En Java se expresa así: **`(T param) -> `**  Sin el operador Lamda, se vería así:  **`void accept(T param)`**.<br/>
Se utiliza para realizar alguna operación con el valor de *T*, pero sin devolver nada, puede ser una operación de guardado o de impresión.<br/><br/>
3.  **Predicate\<T>:** Similar a *Function<T,R>*, con la diferencia de que el valor a devolver siempre es un valor lógico (*Boolean:  true,  false*). En Java se expresa así: **`(T param) -> boolean`** Sin el operador Lamda, se vería así:  **`boolean test(T param)`**. <br/>Se utiliza para realizar operaciones lógicas, generalmente en operaciones de búsqueda o de filtrado.<br/><br/>
4.  **Supplier\<T>:** Su traducción al español es Proveedor. Significa que provee un objeto de tipo **T**, pero no recibe ningún parámetro. En Java se expresa así: **`() -> T `** Sin el operador Lamda, se vería así:  **`T get()`** .<br/>Se utiliza generalmente para proveer objetos contenedores como los *List*.<br/><br/>
5.  **BiConsumer<T,U>:** Similar a *Consumer\<T>*, con la diferencia de que este recibe dos parámetros, uno de tipo **T** y otro de tipo **U** No devuelve valor alguno. En Java se expresa así:  **`(T paramT, U paramU) ->`**  Sin el operador Lamda se vería así:  **`void accept(T paramT, U paramU)`**.<br/>Se utiliza en casos similares en donde se utiliza el *Consumer\<T>*, donde se requiere hacer algún tipo de operación con los dos parámetros que entrega; en el ejemplo veremos como se implementa un *Separador*.<br/><br/>
6.  **BiFunction\<T,U,R>:** Es una función de 3 variables **``Y= f(x,z)``** donde **T** representa el valor de la variable *x*, **U** representa el valor de la variable *z* y **R** es el tipo de dato del valor resultante que debe devolver la función. En Java se expresa así:  **`(T,U) -> R`** Sin el operador Lamda se vería así: **` R apply(T paramT, U paramU)`**. <br/> Sus usos son poco comunes; en el ejemplo veremos como se implementa un *Comparador*.<br/><br/>
7.  **BinaryOperator\<T>:** Operador Binario; es un *BiFunction<T,T,T>* esto es que recibe en parámetro dos objetos de tipo **T** pero devuelve uno de los dos objetos. En Java se expresa así:  **`(T,T) -> T`** Sin el operador Lamda se vería así:<br/>  **`T apply(T paramT1, T paramT2)`**. No define su propio método abstracto porque ya tiene el que hereda de *BiFunction<T,T,T>*; pero cuenta con dos métodos estáticos (*minBy, maxBy*) los que son bastante utilizados más que apply.<br/> Sus usos son poco comunes, en el ejemplo veremos como se implementa un *Clasificador* y como se utilizan los métodos *minBy*, *maxBy*. <br/><br/>
8.  **BiPredicate<T,U>:**  Similar a un *Predicate\<T>*, pero con la diferencia de que recibe 2 parámetros a evaluar y devuelve un valor lógico (*Boolean:  true,  false*).  En Java se expresa así:  **`(T,U) -> boolean`**  Sin el operador Lamda se vería así:                 **`boolean test(T paramT, U paramU)`**.<br/> Al igual que *Predicate\<T>* se utiliza para realizar operaciones lógicas, generalmente en operaciones de búsqueda o de filtrado.<br/><br/>
9.  **UnaryOperator\<T>:**  Opereador Unario; es un *Function<T,T>*, esto es que recibe en parámetro un objeto de tipo **T** y devuelve el mismo u otro objeto del mismo tipo **T**.  En Java se expresa así:  **`(T) -> T`**  Sin el operador Lamda, se vería así: <br/> **`T apply(T param)`** .  No define su propio método abstracto porque ya tiene el que se hereda de *Function<T,T>*, pero cuenta con el método estático (*identity*) el cual es bastante utilizado más que apply , heredado de *Function<T,T>*.<br/>Su uso es bastante pobre, pero básicamente es utilizado donde se requiere un *Function<T,T>*, pero que no se pretende hacer ningún cálculo y simplemente se devuelve el objeto **T**. <br/><br/>

## Requisitos del Proyecto Java
1. [NetBeans 8.2](https://netbeans.org/downloads/)
2. [Java SE JDK 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html?fbclid=IwAR21GQMtgfZY7ZzLscX538bwGPkzqT8ap2jXCFUy0Ycnmxqy4hEDja7XPJo) update más reciente.
3. [Apache Maven 3.6](https://www-us.apache.org/dist/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.zip?fbclid=IwAR2pO8S7v5Frm0eKYDoTemFWSu7w0fIYOIXsDrmrthNlUKGHQbF6uN5TkoM)

## Ejemplos con Java
Los ejemplos que incluyo en esta nota, son ejemplos básico, con fines ilustrativos; para ello he creado dos clases, **Persona** y **Personas**. *Persona* es una clase para crear objetos que representen los datos de una Persona, valga la redundancia, esto es: id, nombre, apellido, fecha de nacimiento y genero. *Personas* es una lista definida como *ArrayList\<Persona>* para contener elementos de tipo *Persona*.  Crearemos una lista de personas en una variable que llamaremos **_personas_**, (en minúscula) y con esta lista vamos ejemplificar el uso de las *Interfaces Funcionales*. <br/><br/>
Ejemplo 1. **Function<Date,Integer>**<br/> En la clase *Persona*, la edad es un valor calculado en función de la fecha de nacimiento. Para ello *Persona* tiene el método **setCalculadorEdad** que se utiliza para definir un *Function<Date,Integer>* que se ocupa de calcular la edad. <br/>
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
Puede verse, la función que recibe en parámetro la fecha de nacimiento y devuelve la edad calculada. **Date** es el tipo de dato del parámetro *fechaNacimiento*, **Integer** es el tipo de dato de la edad calculada a devolver. <br/> A continuación se establece la función *calculadorEdad* a cada elemento de la lista personas; de manera que al llamar al método **getEdad()**, hará un llamado a esta función con la fecha de nacimiento y devolverá la edad calculada
```java
personas.forEach((Persona p) -> p.setCalculadorEdad(calculadorEdad));
```
Ejemplo 2. <br/>
Ejemplo 3. <br/>
