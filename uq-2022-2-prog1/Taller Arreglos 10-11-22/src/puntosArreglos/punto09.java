package puntosArreglos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 * Llenar una matriz cuadrada de tamaño n*2n, con n impar. La matriz debe tener la
 * estructura presentada. Para este caso el valor de n es 5. Pero debe funcionar para
 * diferentes tamaños de entrada.
 */
public class punto09 {
	//Nota: En la clase AbrirTodos están todos los puntos
	public static void main(String[] args) {
		int n = leerInt("Escribe un numero para generar la matriz");
		if(n%2==1) {
			int matriz[][] = generarMatriz(n);
			imprimirMatrizInt("La matriz es:",matriz);
		} else {
			int matriz[][] = generarMatriz(n);
			imprimirMatrizInt("n es par pero la matriz es:",matriz);
		}

	}
	public static ArrayList<Integer> generarArrayLdeMatriz(int n) {
		int cant1 = 2;
		int vacios = n-(cant1/2);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//Llena el triangulo inicial
		while(vacios>=0) {
			agregar_a_arr(arr,vacios,0);
			agregar_a_arr(arr,cant1,1);
			agregar_a_arr(arr,vacios,0);
			cant1+=4;
			vacios-=2;
		}
		//Se calibra para hacer el triangulo inverso
		cant1-=8;
		vacios+=4;
		//Hace el triangulo inverso
		while(vacios<=2*n) {
			agregar_a_arr(arr,vacios,0);
			agregar_a_arr(arr,cant1,1);
			agregar_a_arr(arr,vacios,0);
			cant1-=4;
			vacios+=2;
		}
		return arr;
	}
	public static int[][] generarMatriz (int n){
		ArrayList<Integer> arr =  generarArrayLdeMatriz(n);
		int matriz[][] = new int[n][2*n];
		int x = 0;
		for(int i = 0;i<matriz.length;i++) {
			for(int j = 0;j<matriz[0].length;j++) {
				matriz[i][j] = arr.get(x);
				x++;
			}
		}
		return matriz;
	}

	public static void agregar_a_arr (ArrayList<Integer> arr,int cantidad,int texto) {
		for (int i = 0; i<cantidad;i++) {
			arr.add(texto);
		}
	}
	public static void imprimirMatrizInt (String mensaje,int matriz[][]) {
		mensaje+= "\n";
		for(int i = 0; i<matriz.length;i++) {
			for(int j = 0; j<matriz[0].length;j++) {
				mensaje+=matriz[i][j]+" ";
			}
			mensaje+="\n";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	public static int leerInt (String mensaje) {
		int x;
		//Intente leer el numero, pero si da un error decirlo y volver a pedir el dato
		try {
			x = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Escribe un numero válido","Error",JOptionPane.ERROR_MESSAGE);
			x = leerInt(mensaje);
		}
		return x;
	}
}