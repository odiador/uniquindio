package pagina133;
import esen.cial;
//1
public class promedioPrimos {
	public static boolean esPrimo(double numero) {
		int contador = 0;
		for (int i = 2; i<numero;i++) {
			if (numero%i==0) contador++;
		}
		boolean resultado=false;
		if(contador==0) resultado=true;
		return resultado;
	}
	public static double calcularPromedioPrimos(double numeros[]) {
		int cant = numeros.length;
		int cantPrimos = 0;
		double suma = 0;
		for (int i = 0;i<=cant;i++) {
			if (esPrimo(numeros[i])) {
				suma+=numeros[i];
				cantPrimos++;
			}
		}
		double promedio = suma/cantPrimos;
		return promedio;
	}
	public static void main (String args[]) {
		int cantidad = cial.leerInt("Escriba la cantidad de notas a las que quiere sacar el promedio");
		double notas[]= new double[cantidad];
		for(int i = 0;i<notas.length;i++) {
			notas[i]=cial.leerDouble("Escriba la nota numero "+(i+1)+":");
		}
		double promedioPrimos = calcularPromedioPrimos(notas);
		cial.imprimir("El promedio de los numeros primos es: "+promedioPrimos);
	}
}


