package pagina133;

import esen.cial;

/*
 * 2. Obtener el promedio de todos los números perfectos que hay en un arreglo.
 * Un número es perfecto cuando la suma de sus divisores propios es igual
 * al mismo número. Ejemplo 6 es número perfecto, * porque sus divisores
 * propios son 1, 2 y 3; y 6 = 1 + 2 + 3.
 */
public class promPerfects {
	public static boolean esPerfecto(double numero) {
		int suma = 0;
		for (int i = 1; i<numero;i++) {
			if (numero%1==0) suma++;
		}
		boolean resultado = false;
		if (suma==numero) resultado = true;
		return resultado;
	}
	public static double calcularPromedioPerfectos(double numeros[]) {
		int cantPerfectos = 0;
		int cantidad = numeros.length;
		double suma = 0;
		for (int i=0;i<cantidad;i++) {
			if (esPerfecto(numeros[i])) {
				cantPerfectos++;
				suma+=numeros[i];
			}
		}
		double promedio = suma/cantPerfectos;
		return promedio;
	}
	public static void main(String[] args) {
		int cantidad = cial.leerInt("Escriba la cantidad de numeros a las que quiere sacar el promedio");
		double numeros[]= new double[cantidad];
		for(int i = 0;i<numeros.length;i++) {
			numeros[i]=cial.leerDouble("Escriba la nota numero "+(i+1)+":");
		}
		double promedioPrimos = calcularPromedioPerfectos(numeros);
		cial.imprimir("El promedio de los numeros primos es: "+promedioPrimos);

	}

}
