package tallercolas;

import java.util.function.Predicate;

import org.junit.Test;

public class Imprimir {

	@Test
	public void imprimirCola() {
		Cola<Integer> cola = new Cola<Integer>();
		cola.encolar(1);
		cola.encolar(2);
		cola.encolar(3);
		cola.encolar(4);
		cola.encolar(5);
		cola.encolar(6);
		try {
			imprimirCola(cola);
			imprimirCola(cola);
			imprimirCola(cola);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEliminarPersonasP() {
		Cola<Persona> cola = new Cola<Persona>();
		cola.encolar(new Persona("Pepe", "12345"));
		cola.encolar(new Persona("Juan", "12345"));
		cola.encolar(new Persona("Luis", "12345"));
		cola.encolar(new Persona("Perdomo", "12345"));
		cola.encolar(new Persona("Amador", "12345"));
		cola.encolar(new Persona("Londoño", "12345"));
		cola.encolar(new Persona("Pedro", "12345"));
		cola.encolar(new Persona("Robinson", "12345"));
		imprimirCola(cola);
		eliminarPersonasNombreEmpiezaP(cola);
		imprimirCola(cola);

	}

	private <T> void imprimirCola(Cola<T> cola) {
		System.out.println(cola.toString());
	}

	public void eliminarPersonasNombreEmpiezaP(Cola<Persona> cola) {
		eliminarPersonas(cola, persona -> {
			return persona.getNombre().startsWith("P") || persona.getNombre().startsWith("p");
		});
	}

	public void eliminarPersonasNombreEmpiezaJ(Cola<Persona> cola) {
		eliminarPersonas(cola, persona -> {
			return persona.getNombre().startsWith("J") || persona.getNombre().startsWith("j");
		});
	}

	public void eliminarPersonas(Cola<Persona> cola, Predicate<Persona> condicionEliminar) {
		int tam = cola.size();
		for (int i = 0; i < tam; i++) {
			Persona dato = cola.desencolar();
			if (!condicionEliminar.test(dato))
				cola.encolar(dato);
		}
	}
}
