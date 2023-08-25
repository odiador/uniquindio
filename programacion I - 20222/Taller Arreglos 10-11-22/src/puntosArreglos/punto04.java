package puntosArreglos;

import javax.swing.JOptionPane;
/*
 * Dado un arreglo bidimensional, escriba un método que retorne un arreglo unidimensional
 * con placas de identificación. Solamente se agregarán al arreglo, las placas cuyos dígitos
 * constituyan en su estructura al menos dos números perfectos y que estén por encima de la
 * diagonal principal. Un número perfecto es igual a la suma de sus divisores propios
 * positivos.
 */

public class punto04 {
	//Nota: En la clase AbrirTodos están todos los puntos
	public static void main(String[] args) {
		//Una matriz de placas
		String placas[][] =  {
				{"GUJ628","ASD601","URK496"},
				{"AHI123","YWK666","SIE730"},
				{"CUA740","TYS066","SIU766"}
				};
		String vectPlacas[] = obtenerVectPlacasPerfts(placas);
		imprimirMatrizString("La matriz inicial es: ",placas);
		imprimirVectorString("El vector resultante es:",vectPlacas);
	}
	//Determina si es perfecto
	public static boolean esPerfecto(int num) {
		int suma = 0;
		for(int i = 1;i<num;i++) {
			if(num%i==0) suma+=i;
		}
		boolean res = false;
		if (num==suma) res = true;
		return res;
	}
	//determina si la cantidad de perfectos completa es mayor o igual a 2
	public static boolean detEsPerfectoComp (String placa) {
		int nPlaca = Integer.parseInt(placa.substring(3));
		String cadena = nPlaca+"";
		int cant = 0;
		for(int i = 0;i<cadena.length();i++) {
			for(int j = 1;j<=cadena.length();j++) {
				/*
				 * 01* 02* 03*
				 * 11* 12* 13*
				 * 21  22  23*
				 * Me sirven los substrings que tienen * (cuando i<j)
				 */
				if(i<j) {
					String parte = cadena.substring(i,j);
					int num = Integer.parseInt(parte);
					if(esPerfecto(num)) cant++;
				}
			}
		}
		boolean res = false;
		if(cant>=2) res = true;
		return res;
	}
	public static String[] obtenerVectPlacasPerfts (String placas[][]) {
		String resString = "";
		for(int i = 0;i<placas.length;i++) {
			for(int j= 0;j<placas[0].length;j++) {
				if(detEsPerfectoComp(placas[i][j])&&i<j) {
					/*
					 * Si las placa tiene 2 perfectos y si esta encima de la diagonal
					 * principal, se guarda en una cadena para luego hacer .split y
					 * generar un vector
					 */
					resString+=placas[i][j]+"-";
				}
			}
		}
		String arrRes[] = resString.split("-");
		return arrRes;
	}
	//imprime lo que da
	public static void imprimirVectorString (String mensaje,String matriz[]) {
		mensaje += "\n";
		for(int i = 0; i<matriz.length;i++) {
			mensaje+="["+matriz[i]+"] ";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	public static void imprimirMatrizString (String mensaje,String matriz[][]) {
		mensaje +="\n";
		for(int i = 0; i<matriz.length;i++) {
			for(int j = 0; j<matriz[0].length;j++) {
				mensaje+="["+matriz[i][j]+"] ";
			}
			mensaje +="\n";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
