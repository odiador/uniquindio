package ejerciciosdeArreglosPlaca;

import esen.cial;

/*
 * Mostrar la identificación de los empleados cuyo apellido tiene
 * más de 3 vocales y cuya identificación tiene más de 2 números
 * primos. Se debe retornar un arreglo unidimensional.
 */
public class punto8 {
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

			String pregunta = ""
					+   "Bienvenido a la aplicación de administración de información: "
					+ "\nPor favor selecciona la opción que deseas usar:"
					+ "\n"
					+ "\n"
					+ "\n1. Hallar el promedio de los salarios de los empleados que"
					+ "\n   vivan en estrato cuatro y cuya identificación tiene al"
					+ "\n   menos dos dígitos pares."
					+ "\n2. Hallar el empleado que tenga el menor salario."
					+ "\n3. Obtener las placas de los vehículos cuyopropietario "
					+ "\n   identificación que inicia y termina en 1."
					+ "\n4. Hallar la cantidad de vehículos cuyas placas tienen una "
					+ "\n   letra entre la A y la D."
					+ "\n5. Eliminar un empleado del arreglo, de acuerdo con el número"
					+ "\n   de identificación."
					+ "\n6. Mostrar en un arreglo unidimensional, las placas de los"
					+ "\n   vehículos cuyos dígitos están entre 000 y 400."
					+ "\n7. Mostrar la identificación de los empleados, cuyos vehículos"
					+ "\n   tengan en sus placas dígitos constituyan en su estructura al"
					+ "\n   menos dos números perfectos."
					+ "\n8. Mostrar la identificación de los empleados cuyo apellido"
					+ "\n   tiene más de 3 vocales y cuya identificación tiene más de 2"
					+ "\n   números primos. Se debe retornar un arreglo unidimensional."
					+ "\n0. Salir.";
			int opcion;
			do {
				opcion= cial.leerInt(pregunta);
				switch(opcion) {
				case 1:
				}
			}
			while (opcion!=3);

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
	public static int determinarCantDig (int num) {
		int i = num;
		int cant = 1;
		while (i>=10) {
			cant++;
			i=i/10;
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
	public static int determinarCantPrimos (int identif) {
		int cant = 0;
		for(int i = 1;i<identif;i=i*10) {
			int digito = (identif/i)%10;
			if(esPrimo(digito)) cant++;
		}
		return cant;
	}
	public static int determinarCantArrIdentif (String nombres[],int identifs[]) {
		int cant = 0;
		for (int i = 0;i<nombres.length;i++) {
			if(determinarCantPrimos(identifs[i])>2&&determinarCantVocales(nombres[i])>3) cant++;
		}
		return cant;

	}
	public static int[] generarNuevArrIdentif (String nombres[],int identifs[]) {
		int cant = determinarCantArrIdentif (nombres,identifs);
		int newArr[] = new int [cant];
		int pos = 0;
		for (int i = 0;i<nombres.length;i++) {
			if(determinarCantPrimos(identifs[i])>2&&determinarCantVocales(nombres[i])>3) {
				newArr[pos] = identifs[i];
				pos++;
			}
		}
		return newArr;
	}
}