package ejerciciosdeArreglosPlaca;

import esen.cial;

/*
 * Mostrar en un arreglo unidimensional, las placas de los vehículos
 * cuyos dígitos están entre 000 y 400.
 */
public class punto6 {
	public static void main (String [] args) {
		int cant = 6;
		String nombres[] = new String [cant];
		double salarios[] = new double [cant];
		int identifs[] = new int [cant];
		int estratos[] = new int[cant];
		String placas[] = new String [cant];
		for (int i = 0; i<cant;i++) {
			nombres[i]  = cial.leerString("Escriba el nombre del empleado ("+(i+1)+"/"+cant+")");
			salarios[i] = cial.leerDouble("Escriba el salario del empleado ("+(i+1)+"/"+cant+")");
			identifs[i] = cial.leerInt("Escriba la identificación del empleado ("+(i+1)+"/"+cant+")");
			estratos[i] = cial.leerInt("Escriba el estrato del empleado ("+(i+1)+"/"+cant+")");
			placas[i]   = cial.leerString("Escriba la placa de automóvil del empleado ("+(i+1)+"/"+cant+")");
		}
	}
	public static boolean estaEnRango (String placa) {
		int nplaca = cial.sacarNumsDeString(placa);
		boolean res = false;
		if(nplaca>=400) res = true;
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
}
