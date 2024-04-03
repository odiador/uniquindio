# Laboratorio Pilas

<div align="center">

Made with 

<img src="https://skillicons.dev/icons?i=java" />

</div>

Este taller está realizado en java, más información se puede encontrar en el siguiente [PDF](info/Taller%20pilas.pdf "PDF").

## Preguntas

Dada la siguiente pila de ejemplo y teniedolos métodos: new Pila(),
esVacia(), cima(), apilar(), desapilar():

> 10<br>
> 20<br>
> 12<br>
> 78<br>
> 40

Escribir un algoritmo que, dado una pila, un nivel inferior y un nivel
superior, elimine todos los elementos que se encuentran entre los
niveles indicados (inclusive). 
> [!NOTE]
> Se considera que el nivel 1 es donde se
encuentra el elemento tope de la pila.

### Firma metodo:
```
void eliminarElementos(Pila p, int nivelInf, int nivelSup)
```
> [!IMPORTANT]
> Ejemplo: para la pila dispuesta inicialmente, con nivel inferior: 2 y nivel
superior: 4, la pila resultante debería ser

> 10<br>
> 40

Se podrán crear Pilas, Listas y Colas alternativas para su
implementación, suponiendo disponible los métodos vistos en clase

## Solución

#### Clase Pila

La clase [Stack](src/tallerpilas/estructuras/Stack.java "Clase Stack") es la pila, allí se encuentran los métodos de:

- ```esVacia()``` ->  ```isEmpty()```
- ```cima()``` ->  ```isEmpty()```
- ```apilar()``` ->  ```push()```
- ```desapilar()``` ->  ```pop()```

##### Metodos extra:

- Se implementó un método ```toString()``` que imprime la Pila (Stack).
- Se implementó un método ```pushAll()``` que es como un ```push()``` pero este permite agregar mas de un elemento.


#### Clase Prueba

La clase [Prueba1](src/tallerpilas/tests/Prueba1.java "Clase Prueba") es la clase prueba, allí se encuentra el método de la solución del ejercicio. 

> [!NOTE]
> En esta clase se crea una prueba funcional para el metodo de ```eliminarElementos() ``` usando JUnit 4.
