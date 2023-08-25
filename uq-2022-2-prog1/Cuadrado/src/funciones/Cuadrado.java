package funciones;

import javax.swing.JOptionPane;

public class Cuadrado {
	public static double calcArea (double lado) {
		return (Math.pow(lado, 2));
	}
	public static double calcPerimetro (double lado) {
		return (4*lado);
	}
	public static double calcHipotenusa (double lado) {
		return ((int) Math.sqrt(2*Math.pow(lado, 2)));
	}
	public static void imprimir (String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	public static double leerDouble(String msg) {
		return Double.parseDouble(JOptionPane.showInputDialog(msg));
	}
}
