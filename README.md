# Progamación Funcional Java

## Qué es Programación Funcional?

Es un paradigma de programación basado en el concepto de funciones matemáticas. En java básicamente se programa siguiendo el paradigma imperativo, donde se escriben sentencias de forma secuencial donde se ven claramente las instrucciones de forma ordenada. Con la programación funcional, la cosa cambia un poco y algunas veces no es tan fácil de entender, pero cuando conoces los conceptos, todo se vuelve comprensible.

Una función en matemáticas se representa así:   **``Y = f (x)``** ;  donde `x` es una variable que determina el valor de `Y`. En la programación funcional, al igual que en matemáticas, se pueden definir expresiones con más de una variable para obtener un resultado en `Y`.
En Java, a partir de la versión 8 (*Java Standard Edition 8*), hay disponible diferentes elementos que explotan al máximo la programación funcional, entre ellos están las *Interfaces Funcionales* y el Operador Lamda `->`. 

## Interfaces Funcionales Java:
Es una interface como cualquiera, pero con la anotación **_@FunctionalInterface_** y que define un único método abstracto a ser implementado. Están definidas en el paquete _java.util.function_. Utilizadas exclusivamente en la programación funcional en Java. A continuación una explicación breve de cada una.

1.  **Function<T,R>:** Similar a una función matemática de dos variables **`R = f(T)`**, donde `T` representa el valor de la variable `x` , `R` es el tipo de dato del valor resultante que debe devolver la función. En Java se expresa así: **`(T param) -> R `** Puede apreciarse el operador Lamda formado por el guión junto con el símbolo mayor que: `->`.  Los paréntesis son parte de la expresión. Sin el operador Lamda, en Java se ve así: **`R  apply(T param)`**. <br/>
Se utiliza para hacer un cálculo con el valor de `T` y obtener como resultado un valor de tipo _R_ que debe ser retornado; en el ejemplo calcularemos la edad de una persona dada su fecha de nacimiento.<br/><br/>
2.  **Consumer\<T>:** Similar a *Function<T,R>*, con la diferencia, como puede apreciarse, no tiene la `R`, esto significa que no devuelve un valor. En Java se expresa así: **`(T param) -> `**  Sin el operador Lamda, se vería así:  **`void accept(T param)`**.<br/>
Se utiliza para realizar alguna operación con el valor de _T_, pero sin devolver nada, puede ser una operación de guardado o de impresión.<br/><br/>
3.  **Predicate\<T>:** Similar a *Function<T,R>*, con la diferencia de que el valor a devolver siempre es un valor lógico (Boolean:  true,  false). En Java se expresa así: **`(T param) -> boolean`** Sin el operador Lamda, se vería así:  **`boolean test(T param)`**. <br/>Se utiliza para realizar operaciones lógicas, generalmente en operaciones de búsqueda o de filtrado.<br/><br/>
4.  **Supplier\<T>:** Su traducción al español es Proveedor. Significa que provee un objeto de tipo _T_, pero no recibe ningún parámetro. En Java se expresa así: **`() -> T `** Sin el operador Lamda, se vería así:  **`T get()`** .<br/>Se utiliza generalmente para proveer objetos contenedores como los *List*.<br/><br/>
5.  **BiConsumer<T,U>:** Similar a *Consumer\<T>*, con la diferencia de que este recibe dos parámetros, uno de tipo `T` y otro de tipo `U` No devuelve valor alguno. En Java se expresa así:  **`(T paramT, U paramU) ->`**  Sin el operador Lamda se vería así:  **`void accept(T paramT, U paramU)`**  <br/><br/>  Se utiliza en casos similares en donde se utiliza el *Consumer<T>*, donde se requiere hacer algún tipo de operación con los dos parámetros que entrega; en el ejemplo veremos como se implementa un *Separador*.<br/><br/>

