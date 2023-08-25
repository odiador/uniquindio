package clase2;

import javax.swing.JOptionPane;

public class pasarCentigrados {
	public static double pasaraKelvin(double n) {
		double result = n+273.15;
		return result;
	}
	public static double pasaraFahrenheit (double n) {
		double result = n*9/5+32;
		return result;
	}
	public static double leerDouble(String mensaje) {
		return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
	}
	public static void impr (String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
	}
	public static void main (String args[]) {
		double num = leerDouble("Escriba una temperatura en grados centigrados");
		double kelv = pasaraKelvin(num);
		double faren = pasaraFahrenheit(num);
		impr("La equivalencia de "+num+"°C en kelvin es "+kelv+" y en fahrenheit es "+faren);
	}
}
