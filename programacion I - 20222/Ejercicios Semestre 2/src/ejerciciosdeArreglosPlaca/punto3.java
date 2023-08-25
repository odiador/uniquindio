package ejerciciosdeArreglosPlaca;

import esen.cial;

/*
 * Retornar en un arreglo unidimensional las placas de los
 * vehículos cuyo propietario tiene identificación que inicia
 * y termina en 1. Se puede utilizar la clase Arrays.
 */
public class punto3 {
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
	public static boolean es1X1 (String placa) {
		int num = cial.sacarNumsDeString(placa);
		int nFinal = num%10;
		int nInicial = num;
		while (nInicial>=10) {
			nInicial = nInicial/10;
		}
		boolean res = false;
		if (nInicial==1&& nFinal==2) res = true;
		return res;
	}
	public static int determinarCant1X1(String placas[]) {
		int cant = 0;
		for (int i = 0; i<placas.length;i++) {
			if(es1X1(placas[i])) cant++;
		}
		return cant;
	}
	public static String[] generarMatriz1X1(String placas[]) {
		int cant = determinarCant1X1(placas);
		String nuevArr[] = new String[cant];
		int pos = 0;
		for (int i = 0; i<placas.length;i++) {
			if(es1X1(placas[i])) {
				nuevArr[pos]=placas[i];
				pos++;
			}
		}
		return nuevArr;
	}
}
