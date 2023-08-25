package taller40preguntas;

import esen.cial;

/*
 * Escribir un programa que lea una lista de números reales, los cuente y a
continuación calcule e imprima su media, varianza y desviación estándar. Utilizar un
método para calcular la media, otro para la varianza y otro para la desviación estándar.
 */
public class p38 {
	public static void main(String args[]) {
		int cant = cial.leerInt("Escribe la cantidad de numeros a generar");
		double data[] = new double[cant];
		for(int i = 0;i<cant;i++) {
			data[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		//double data[] = {1,2,2,2,2,4,4,4,4,1,5,6,3,7};
		double media = hallarMedia(data);
		double varianza = hallarVarianza(data, media);
		double desviacion = hallarDesviacion(varianza);
		cial.imprimir("La media es: "+media+", la varianza es: "+varianza+", y la desviación:"+desviacion);
	}
	public static double hallarMedia (double datos[]) {
		double suma = 0;
		int cant =datos.length;
		for (int i = 0;i<cant;i++) {
			suma+=datos[i];
		}
		double res = suma/cant;
		return res;
	}
	public static double hallarVarianza (double datos[],double media) {
		double suma = 0;
		int cant =datos.length;
		for (int i = 0;i<cant;i++) {
			suma+=Math.pow((datos[i]-media), 2);
		}
		double var = suma/cant;
		return var;
	}
	public static double hallarDesviacion(double varianza) {
		double desviacion = Math.sqrt(varianza);
		return desviacion;
	}
}