package ejerciciosdeArreglosPlaca;

import esen.cial;

/*
 * Mostrar la identificación de los empleados cuyo apellido tiene
 * más de 3 vocales y cuya identificación tiene más de 2 números
 * primos. Se debe retornar un arreglo unidimensional.
 */
public class punto8_combinaciones {
	public static void main (String [] args) {
		int cant = 6;
		String nombres[] = new String [cant];
		String apellidos[] = new String [cant];
		double salarios[] = new double [cant];
		int identifs[] = new int [cant];
		int estratos[] = new int[cant];
		String placas[] = new String [cant];
		for (int i = 0; i<cant;i++) {
			apellidos[i]  = cial.leerString("Escriba el apellido del empleado ("+(i+1)+"/"+cant+")");
			nombres[i]  = cial.leerString("Escriba el nombre del empleado ("+(i+1)+"/"+cant+")");
			salarios[i] = cial.leerDouble("Escriba el salario del empleado ("+(i+1)+"/"+cant+")");
			identifs[i] = cial.leerInt("Escriba la identificación del empleado ("+(i+1)+"/"+cant+")");
			estratos[i] = cial.leerInt("Escriba el estrato del empleado ("+(i+1)+"/"+cant+")");
			placas[i]   = cial.leerString("Escriba la placa de automóvil del empleado ("+(i+1)+"/"+cant+")");
		}
	}
	public static int determinarCantVocales (String apellido) {
		int cant = 0;
		for(int i = 0; i<apellido.length();i++) {
			char caracter = apellido.charAt(i);
			if (caracter>='a'&&caracter<='z') caracter-=32;
			if (caracter =='A'&&caracter =='E'&&caracter =='I'&&caracter =='O'&&caracter =='U') {
				cant++;
			}
		}
		return cant;
	}
	public static boolean esPrimo (int num) {
		boolean res = true;
		for (int i =2; i<num;i++) {
			if(num%i==0) res = false;
		}
		return res;
	}
	public static int determinarCantDig (int num) {
		int i = num;
		int cant = 1;
		while (i>=10) {
			cant++;
			i=i/10;
		}
		return cant;
	}
	public static int determinarFactorial (int num) {
		int n = determinarCantDig(num);
		int fact = 1;
		for (int i = n;i>=1;i--) {
			fact=fact*i;
		}
		return fact;
	}
	public static int determinarCantCCombina (int identif) {
		int cantDig = determinarCantDig(identif);
		int suma = 0;
		for (int i= cantDig;i>=1;i--) {
			int combi = determinarFactorial(cantDig)/(determinarFactorial(i)*determinarFactorial(cantDig-i));
			suma+=combi;
		}
		return suma;
	}
}