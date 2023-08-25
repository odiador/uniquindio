package primerosEjercicios;


import javax.swing.JOptionPane;

public class pregunta_1 {
	public static double ingresarSal (String mensaje) {
		double salario; 
		salario = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
		return salario;
	}
	public static void imprimir (String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
	public static double calcSal (double salario) {
		double salarioF;
		salarioF = salario * 1.16; 
		return salarioF;
	}  
	public static void main (String args[]) {
		double salario, salarioF;
		salario = ingresarSal("Ingrese el salario actual:");
		salarioF = calcSal(salario);
		imprimir("El Salario con incremento del 16% es de: "+ salarioF);
	}
}