package primerosEjercicios;


import javax.swing.JOptionPane;

public class pregunta_2 {
	public static double ingresarSalF (String mensaje) {
		double salario; 
		salario = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
		return salario;
	}
	public static void imprimir (String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
	public static double calcSalOG (double salarioF) {
		double salario;
		salario = salarioF / 1.16;
		return salario;
	}  
	public static void main (String args[]) {
		double salario, salarioF;
		salarioF = ingresarSalF("Ingrese el salario final:");
		salario = calcSalOG(salarioF);
		imprimir("El Salario sin el incremento del 16% es de: "+ salario);
	}
}
