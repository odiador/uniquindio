package ejerciciosdeArreglosPlaca;

import esen.cial;

/*
 * Hallar la cantidad de vehículos cuyas placas tienen una letra entre la A y la D.
 */
public class punto4 {
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
	public static boolean estaEntreAyD (String placa) {
		boolean res = false;
		for(int i = 0; i<placa.length();i++) {
			char caracter = placa.charAt(i);
			if(caracter>='A'&&caracter<='D') res = true;
		}
		return res;
	}
	public static int cantPlacaseAyD (String placas[]) {
		int cont = 0;
		for (int i = 0;i<placas.length;i++) {
			if(estaEntreAyD(placas[i])) cont++;
		}
		return cont;
	}
}
