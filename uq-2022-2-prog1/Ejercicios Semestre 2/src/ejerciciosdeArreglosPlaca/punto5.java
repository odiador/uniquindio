package ejerciciosdeArreglosPlaca;

import esen.cial;

/*
 * Eliminar un empleado del arreglo, de acuerdo con el número de identificación.
 * El número de debe ser ingresado por parámetro.
 */
public class punto5 {
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
		int identifAComparar = cial.leerInt("Escriba la identificación del empleado a eliminar");
	}
	public static String[] eliminarEmp (String nombres[],int identifs[],int comparacion) {
		String nuevArr[] = new String[nombres.length-1];
		int pos=0;
		for (int i = 0;i<identifs.length;i++) {
			if(identifs[i]!=comparacion) nuevArr[pos] =nombres[i];
		}
		return nuevArr;
	}

}
