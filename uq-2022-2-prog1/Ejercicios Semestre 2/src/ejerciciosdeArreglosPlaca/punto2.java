package ejerciciosdeArreglosPlaca;

import esen.cial;

// Hallar el empleado que tenga el menor salario.
public class punto2 {
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

}
