package ejerciciosdeArreglosPlaca;

import esen.cial;

public class todos {
	public static void main (String [] args) {
		/*
		int cant = 6;
		String nombres[] = new String [cant];
		String apellidos[] = new String [cant];
		double salarios[] = new double [cant];
		int identifs[] = new int [cant];
		int estratos[] = new int[cant];
		String placas[] = new String [cant];
		for (int i = 0; i<cant;i++) {
			apellidos[i]  = essentials.leerString("Escriba el apellido del empleado ("+(i+1)+"/"+cant+")");
			nombres[i]  = essentials.leerString("Escriba el nombre del empleado ("+(i+1)+"/"+cant+")");
			salarios[i] = essentials.leerDouble("Escriba el salario del empleado ("+(i+1)+"/"+cant+")");
			identifs[i] = essentials.leerInt("Escriba la identificación del empleado ("+(i+1)+"/"+cant+")");
			estratos[i] = essentials.leerInt("Escriba el estrato del empleado ("+(i+1)+"/"+cant+")");
			placas[i]   = essentials.leerString("Escriba la placa de automóvil del empleado ("+(i+1)+"/"+cant+")");
		}
		*/
		String nombres[] = {"Juan","Andres","Luis","Pepito","Mauro","Ricardo"};
		String apellidos[] = {"Amador Roa","Londoño","Zuluaga","Corrales","Barrios","Perdomo"};
		String nombreC[] = generarArrNombreCompleto(nombres,apellidos);
		double salarios[] = {1000,750,300,1100,700,100};
		int identifs[] = {2116103487,1272233813,1126486123,1234567811,1347826387,1231231231};
		int estratos[] = {4,2,3,4,1,6};
		String placas[] = {"ABC628","FGW616","ATH425","HRY867","ADS801","NHY654"};
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
			int opcion=-1;
			do {
				try{
					opcion= cial.leerInt(pregunta);
				}
				catch (Exception e) {
					cial.imprimir("Error, intentalo de nuevo");
					opcion=0;
				}
				switch(opcion) {
				case 1: imprimirResP1(salarios,estratos,identifs);
				break;
				case 2: imprimirResP2(nombreC,salarios);
				break;
				case 3: imprimirResP3(placas,identifs);
				break;
				case 4: imprimirResP4(placas);
				break;
				case 5: imprimirResP5(nombreC,identifs);
				break;
				case 6: imprimirResP6(placas);
				break;
				case 7: imprimirResP7(placas,identifs);
				break;
				case 8: imprimirResP8(apellidos,identifs);
				break;
				case 0:  System.exit(0);
				}
			}
			while (opcion!=0);
	}
	public static String[] generarArrNombreCompleto (String nombres[],String apellidos[]) {
		int cant = nombres.length;
		String arr[] = new String[cant];
		for (int i = 0;i<cant;i++) {
			arr[i] = nombres[i]+" "+apellidos[i];
		}
		return arr;
	}
	/*
	 ***********************PUNTO 1***********************
	 *Hallar el promedio de los salarios de los empleados*
	 *que vivan en estrato cuatro y cuya identificación***
	 *tiene al menos dos dígitos pares.*******************
	 *****************************************************
	 */

	public static boolean cumpleRequisitos1(int identificacion,int estrato) {
		int cant = 0;
		while (identificacion>=10) {
			if (identificacion%2==0) cant++;
			identificacion = identificacion/10;
		}
		if (identificacion%2==0) cant++;
		boolean res = false;
		if (cant>=2&&estrato==4) res = true;
		return res;
	}
	public static double hallarPromSiCumplen1(double salarios[],int estratos[],int identifs[]) {
		int cant = 0;
		double suma = 0;
		for(int i =0;i<salarios.length;i++) {
			if(cumpleRequisitos1(identifs[i],estratos[i])) {
				suma+=salarios[i];
				cant++;
			}
		}
		double res = suma/cant;
		return res;
	}
	public static void imprimirResP1 (double salarios[],int estratos[],int identifs[]) {
		double res = hallarPromSiCumplen1(salarios,estratos,identifs);
		cial.imprimir("El promedio es: "+ res);
	}
	/*
	 **********************PUNTO 2*******************
	 *Hallar el empleado que tenga el menor salario.*
	 ************************************************
	 */
	public static String sacarMenorSal(String nombres[],double salarios[]) {
		String nombreMen = nombres[0];
		double salarioMen = salarios[0];
		for(int i = 1;i<nombres.length;i++) {
			if(salarios[i]<salarioMen) {
				salarioMen = salarios[i];
				nombreMen = nombres[i];
			}
		}
		return nombreMen;
	}
	public static void imprimirResP2 (String nombres[],double salarios[]) {
		String res = sacarMenorSal(nombres,salarios);
		cial.imprimir("El de menor salario es: "+ res);
	}
	/*
	 ***************************PUNTO 3**************************
	 *Retornar en un arreglo unidimensional las placas de los****
	 *vehículos cuyo propietario tiene identificación que inicia*
	 *y termina en 1. Se puede utilizar la clase Arrays.*********
	 ************************************************************
	 */

	public static boolean es1X1 (int identif) {
		String cadena = identif+"";
		int nFinal = cadena.charAt(cadena.length()-1)-48;
		int nInicial = cadena.charAt(0)-48;
		boolean res = false;
		if (nInicial==1&& nFinal==1) res = true;
		return res;
	}
	public static int determinarCant1X1(int identifs[]) {
		int cant = 0;
		for (int i = 0; i<identifs.length;i++) {
			if(es1X1(identifs[i])) cant++;
		}
		return cant;
	}
	public static String[] generarMatriz1X1(String placas[],int identifs[]) {
		int cant = determinarCant1X1(identifs);
		String nuevArr[] = new String[cant];
		int pos = 0;
		for (int i = 0; i<placas.length;i++) {
			if(es1X1(identifs[i])) {
				nuevArr[pos]=placas[i];
				pos++;
			}
		}
		return nuevArr;
	}
	public static void imprimirResP3 (String placas[],int identifs[]) {
		String nuevaMatriz[] = generarMatriz1X1(placas,identifs);
		String mensaje = cial.arregloSaString(nuevaMatriz);
		cial.imprimir("El nuevo arreglo es: "+ mensaje);
	}
	/*
	 *************************************PUNTO 4**************************************
	 *Hallar la cantidad de vehículos cuyas placas tienen una letra entre la A y la D.*
	 **********************************************************************************
	 */
	public static boolean estaEntreAyD (String placa) {
		boolean res = false;
		for(int i = 0; i<placa.length();i++) {
			char caracter = placa.charAt(i);
			if(caracter>='A'&&caracter<='D') res = true;
		}
		return res;
	}
	public static int determinarNPlacasentreAyD (String placas[]) {
		int cant = 0;
		for (int i = 0;i<placas.length;i++) {
			if(estaEntreAyD(placas[i])) cant++;
		}
		return cant;
	}
	public static void imprimirResP4 (String placas[]) {
		int cant = determinarNPlacasentreAyD(placas);
		cial.imprimir("La cantidad de placas es "+cant);
	}
	/*
	 ***********************************PUNTO 5*************************************
	 *Eliminar un empleado del arreglo, de acuerdo con el número de identificación.*
	 *******************************************************************************
	 */
	public static int detCantNulls (String arr[]) {
		int cant = 0;
		for (int i = 0;i<arr.length;i++) {
			if(arr[i]==null) cant++;
		}
		return cant;
	}
	public static String[] eliminarEmp (String nombres[],int identifs[],int comparacion) {
		String nuevArr[] = new String[nombres.length];
		int pos=0;
		for (int i = 0;i<identifs.length;i++) {
			if(identifs[i]!=comparacion) {
				nuevArr[pos] =nombres[i];
				pos++;
			}
		}
		int cantNulls = detCantNulls(nuevArr);
		String arrF[] = new String[nombres.length-cantNulls];
		pos = 0;
		for (int i = 0;i<arrF.length;i++) {
			if(nuevArr[i]!=null) {
				arrF[pos] =nuevArr[i];

			}
		}
		return arrF;
	}
	public static void imprimirResP5 (String nombres[],int identifs[]) {
		int comparacion = cial.leerInt("Escriba la identificación del empleado a eliminar");
		String arr[] = eliminarEmp(nombres,identifs,comparacion);
		String mensaje = cial.arregloSaString(arr);
		cial.imprimir("La lista de empleados nueva es: "+mensaje);
	}
	/*
	 ***********************************PUNTO 6**************************************
	 *Eliminar un empleado del arreglo, de acuerdo con el número de identificación.**
	 *El número de debe ser ingresado por parámetro.*********************************
	 ********************************************************************************
	 */
	public static boolean estaEnRango (String placa) {
		int nplaca = cial.sacarNumsDeString(placa);
		System.out.println(nplaca);
		boolean res = false;
		if(nplaca<=400) res = true;
		return res;
	}
	public static int obtenerCantArr (String placas[]) {
		int cant = 0;
		for (int i = 0;i<placas.length;i++) {
			if(estaEnRango(placas[i])) cant++;
		}
		return cant;
	}
	public static String[] generarNuevArr (String placas[]) {
		int cant = obtenerCantArr(placas);
		String nuevArr[] = new String[cant];
		int pos = 0;
		for (int i = 0;i<placas.length;i++) {
			if(estaEnRango(placas[i])) {
				nuevArr[pos] = placas[i];
				pos++;
			}
		}
		return nuevArr;
	}
	public static void imprimirResP6 (String placas[]) {
		String arr[] = generarNuevArr (placas);
		String mensaje = cial.arregloSaString(arr);
		cial.imprimir("La lista de placas que cumplen lo requerido es: \n"+mensaje);
	}
	/*
	 *************************PUNTO 7*******************************
	 *Mostrar la identificación de los empleados, cuyos vehículos***
	 *tengan en sus placas dígitos constituyan en su estructura al**
	 *menos dos números perfectos. Un número perfecto es igual a la*
	 *suma de sus divisores propios positivos.**********************
	 */
	public static boolean esPerfecto(int num) {
		int suma = 0;
		for(int i = 1;i<num;i++) {
			if(num%i==0) suma+=i;
		}
		boolean res = false;
		if (num==suma) res = true;
		return res;
	}
	public static boolean detEsPerfectoComp (String placa) {
		int nPlaca = cial.sacarNumsDeString(placa);
		String cadena = nPlaca+"";
		int cant = 0;
		for(int i = 0;i<cadena.length();i++) {
			for(int j = 1;j<=cadena.length();j++) {
				if(j>i) {
					String parte = cadena.substring(i,j);
					int num = Integer.parseInt(parte);
					if(esPerfecto(num)) cant++;
				}
			}
		}
		boolean res = false;
		if(cant>=2) res = true;
		return res;
	}
	public static int detCantIdentifPlacasPerfts (String placas[]) {
		int cant = 0;
		for(int i=0;i<placas.length;i++) {
			if(detEsPerfectoComp(placas[i])) cant++;
		}
		return cant;
	}
	public static int[] generarIdentifPlacasPerfts (String placas[],int identifs[]) {
		int cant = detCantIdentifPlacasPerfts(placas);
		int nuevArr[] = new int[cant];
		int pos = 0;
		for (int i = 0;i<placas.length;i++) {
			if(detEsPerfectoComp(placas[i])) {
				nuevArr[pos] = identifs[i];
				pos++;
			}
		}
		return nuevArr;
	}
	public static void imprimirResP7 (String placas[],int identifs[]) {
		int arr[] = generarIdentifPlacasPerfts (placas,identifs);
		String mensaje = cial.arregloIaString(arr);
		cial.imprimir("La lista de identificaciones que cumplen lo requerido es: \n"+mensaje);
	}
	/*
	 *************************PUNTO 8********************************
	 *Mostrar la identificación de los empleados cuyo apellido tiene*
	 *más de 3 vocales y cuya identificación tiene más de 2 números**
	 *primos. Se debe retornar un arreglo unidimensional.************
	 ****************************************************************
	 */
	public static int determinarCantVocales (String cadena) {
		int cant = 0;
		for(int i = 0; i<cadena.length();i++) {
			char caracter = cadena.charAt(i);
			if (caracter>='a'&&caracter<='z') caracter-=32;
			if (caracter =='A'||caracter =='E'||caracter =='I'||caracter =='O'||caracter =='U') {
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
		int cantDig = determinarCantDig(identif);
		int aux = 1;
		for(int i = 1;i<=cantDig;i++) {
			int digito = (identif/i)%10;
			if(esPrimo(digito)) cant++;
			aux=aux*10;
		}
		return cant;
	}
	public static int determinarCantArrIdentif (String apellidos[],int identifs[]) {
		int cant = 0;
		for (int i = 0;i<apellidos.length;i++) {
			if(determinarCantPrimos(identifs[i])>2&&determinarCantVocales(apellidos[i])>3) cant++;
		}
		return cant;
	}
	public static int[] generarNuevArrIdentif (String apellidos[],int identifs[]) {
		int cant = determinarCantArrIdentif (apellidos,identifs);
		int newArr[] = new int [cant];
		int pos = 0;
		for (int i = 0;i<apellidos.length;i++) {
			if(determinarCantPrimos(identifs[i])>2&&determinarCantVocales(apellidos[i])>3) {
				newArr[pos] = identifs[i];
				pos++;
			}
		}
		return newArr;
	}
	public static void imprimirResP8 (String apellidos[],int identifs[]) {
		int arr[] = generarNuevArrIdentif (apellidos,identifs);
		String mensaje = cial.arregloIaString(arr);
		cial.imprimir("La lista de identificaciones que cumplen lo requerido es: \n"+mensaje);
	}
}