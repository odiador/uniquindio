package ejerciciosdeArreglosPlaca;

import esen.cial;

public class punto1 {
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
}