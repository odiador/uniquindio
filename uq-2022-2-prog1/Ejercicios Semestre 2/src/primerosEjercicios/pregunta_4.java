package primerosEjercicios;


import javax.swing.JOptionPane;

public class pregunta_4 {
//v = (a**3*sqrt(2))/12

	public static double ingresarVol (String mensaje) {
		double salario; 
		salario = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
		return salario;
	}
	public static double calcLado (double vol){
		double lado =  Math.cbrt((12*vol)/Math.sqrt(2));
		return lado;
	} 
	public static void imprimir (String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
	public static void main (String args[]) {
		double volumen = ingresarVol ("Escriba el volumen de la figura: ");
		double lado = calcLado (volumen);
		imprimir("El lado de la figura es: "+lado);		
	}
}