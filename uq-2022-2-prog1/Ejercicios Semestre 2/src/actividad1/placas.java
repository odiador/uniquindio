package actividad1;
import esen.cial;
public class placas {
	public static boolean esPerfecto (int n) {
		int suma = 0;
		for (int i = 1; i<n; i++) {
			if (n%i==0) {
				suma+=i;
			}
		}
		boolean resultado = false;
		if (suma==n) resultado = true;
		return resultado;
	}
	public static boolean tieneM (char letra) {
		boolean result = false;
		if (letra =='M') result = true;
		return result;
	}
	public static boolean esValida (String placa) {
		int cantM = 0;
		boolean tienePerfect = false;
		for (int i = 0; i<=5;i++) {
			if (i<=2) {
				if (tieneM(placa.charAt(i))) cantM++;
			} else {
				int numero = Integer.parseInt(""+placa.charAt(i));
				if (esPerfecto(numero)) tienePerfect = true;
			}
		}
		boolean resultado = false;
		if (cantM>=2 && tienePerfect) resultado = true;
		System.out.println(cantM);
		System.out.println(tienePerfect);
		return resultado;
	}
	public static void main(String args[]) {
		String placa =  cial.leerString("Escribe la placa");
		if (esValida(placa)) {
			cial.imprimir("La placa "+ placa + " tiene al menos 2 M's \ny tiene minimo un digito perfecto");
		} else {
			cial.imprimir("La placa "+ placa + " no es valida");
		}
	}
}