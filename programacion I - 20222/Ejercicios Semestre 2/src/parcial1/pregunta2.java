package parcial1;
import esen.cial;
public class pregunta2 {
	public static boolean esNarcicista(int n) {
		int i = n;
		String texto = ""+n;
		int suma = 0;
		int cantDigitos = texto.length();
		while (i>=10) {
			suma += (int)(Math.pow(i%10, cantDigitos));
			i=i/10;
		}
		suma += (int)(Math.pow(i, cantDigitos));
		boolean resultado = false;
		if (n==suma) resultado = true;
		/*Al final n iba a ser el ultimo digito, 
		por eso se separaba*/
		return resultado;
	}
	public static boolean tiene2menores5(int n) {
		int contador = 0;
		while (n>=10) {
			if (n%10<5) contador++;
			n = n/10;
		}
		if (n<5) contador++;
		boolean resultado = false;
		if (contador>=2) resultado = true;
		return resultado;
	}
	public static int determinarCantAmbos (int n,int m) {
		int menor = n,mayor=m,contador = 0;
		if (n>m) {
			menor = m;
			mayor = n;
		}
		for (int i = menor; i<=mayor;i++) {
			if (esNarcicista(i) && tiene2menores5(i)) contador++;
		}
		return contador;
	}
	public static int determinarCantNarcicistas (int n,int m) {
		int menor = n,mayor=m,contador = 0;
		if (n>m) {
			menor = m;
			mayor = n;
		}
		for (int i = menor; i<=mayor;i++) {
			if (esNarcicista(i)) contador++;
		}
		return contador;
	}
	public static void main(String[] args) {
		int n1 = cial.leerInt("Escribe el primer valor del rango de valores a evaluar");
		int n2 = cial.leerInt("Escribe el segundo valor del rango de valores a evaluar");
		int cantidadAmbos = determinarCantAmbos (n1,n2);
		int cantidadNarc = determinarCantNarcicistas (n1,n2);
		cial.imprimir("La cantidad de Narcisistas es de: "+cantidadNarc
				+ "\nLa cantidad de Narcisistas y de numeros que "
				+ "\ntienen al menos 2 digitos menores que 5 es de: "+cantidadAmbos);
	}
}
