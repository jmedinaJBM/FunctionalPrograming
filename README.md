# FunctionalPrograming

## Qué es Programación Funcional?

Es un paradigma de programación basado en el concepto de funciones matemáticas. En java básicamente se programa siguiendo el paradigma imperativo, donde se escriben sentencias de forma secuencial donde se ven claramente las instrucciones de forma ordenada. Con la programación funcional, la cosa cambia un poco y algunas veces no es tan fácil de entender, pero cuando conoces los conceptos, todo se vuelve comprensible.

Una función en matemáticas se representa así:   Y = f (x) ;  donde x es una variable que determina el valor de Y. En la programación funcional, al igual que en matemáticas, se pueden definir expresiones con más de una variable para obtener un resultado en Y.
En Java, a partir de la versión 8 (Java Standard Edition 8), hay disponible diferentes elementos que explotan al máximo la programación funcional, entre ellos están las Interfaces Funcionales y el Operador Lamda (->). 

## Interfaces Funcionales Java:
Es una interface como cualquiera, pero con la anotación **_@FunctionalInterface_** y que define un único método abstracto a ser implementado. Están definidas en el paquete _java.util.function_. Utilizadas exclusivamente en la programación funcional en Java. A continuación una explicación breve de cada una.

1 * **Function<T,R>:**
Similar a una función matemática de dos variables R = f(T), donde T representa el valor de la variable x , R es el tipo de dato del valor resultante que debe devolver la función. En Java se expresa así:  (T  param) -> R  ; puede apreciarse el operador Lamda formado por el guión junto con el símbolo mayor que: ->.  Los paréntesis son parte de la expresión. Sin el operador Lamda, en Java se ve así: R  apply(T param).  Se utiliza para hacer un cálculo con el valor de T y obtener como resultado un valor de tipo R que debe ser retornado; en el ejemplo calcularemos la edad de una persona dada su fecha de nacimiento.

