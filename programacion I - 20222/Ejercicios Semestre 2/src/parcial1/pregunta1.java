package parcial1;
import esen.cial;
public class pregunta1 {
	public static int calcMitad(String cadena,int cualMitad) {
		int resultado = 0;
		int cantLetras = cadena.length();
		int desde = 0,hasta = (cantLetras/2-1);
		if (cualMitad==2) {
			desde+=5;
			hasta+=5;
		}
		for (int i = desde;i<=hasta;i++) {
			int digito = cadena.charAt(i)-48;
			if (digito%2==0) {
				resultado+=digito;
			} else {
				resultado+=digito*3;
			}
		}
		return resultado;
	}
	public static boolean esPerfecto(int n) {
		int suma = 0,divisor=1;
		while (n>divisor) {
			if (n%divisor==0) suma+=divisor; 
			/*n%2==0 
			//Si pregunta si es par, siempre va a sumar
			y no va a ser correcto*/
			divisor++;
		}
		boolean resultado = false;
		if (suma == n) resultado = true;
		return resultado;
	}
	public static boolean esPerfectoComprobacion (String cadena) {
		int cantLetras,factor,primerDigito,ultimoDigito;
		primerDigito = cadena.charAt(0)-48;
		cantLetras = cadena.length();
		ultimoDigito = cadena.charAt(cantLetras-1)-48;
		factor = primerDigito+ultimoDigito;
		boolean resultado = false;
		if (esPerfecto(factor)) resultado = true;
		return resultado;
	}
	public static boolean esValido (String cadena) {
		boolean resultado = false;
		if (esPerfectoComprobacion(cadena)&&calcMitad(cadena,1)>calcMitad(cadena,2)) {
			resultado = true;
		}
		return resultado;
	}
	public static int cantValidos (String cadena1,String cadena2) {
		int numero1 = Integer.parseInt(cadena1);
		int numero2 = Integer.parseInt(cadena2);
		int mayor = numero1,menor = numero2;
		if (numero1<numero1) {
			mayor = numero2;
			menor = numero1;
		}
		int contador = 0;
		for (int i = menor; i<=mayor;i++) {
			String cadena = i+"";
			if (esValido(cadena)) contador++;
		}
		return contador;
	}
	public static void main(String[] args) {
		String n1 = cial.leerString("Escribe el numero a evaluar");
		cial.imprimir(esValido(n1)+"");
		
	}
}
