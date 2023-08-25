package clase2;
import javax.swing.JOptionPane;

public class suma2nums {

	public static int leerEntero (String mensaje) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
	}
	public static String leerStr(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}
	public static double leerDouble(String mensaje) {
		return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
	}
	public static float leerFloat(String mensaje) {
		return Float.parseFloat(JOptionPane.showInputDialog(mensaje));
	}
	public static char leerChar(String mensaje) {
		return JOptionPane.showInputDialog(mensaje).charAt(0);
	}
	public static int sumar (int n1,int n2) {
		return n1+n2;
	}
	public static void impr (String mensaje, int resultado) {
		String todo = mensaje+resultado;
		JOptionPane.showMessageDialog(null,todo);
	}
	public static void main(String args[]) {
		int num1 = leerEntero("Ingrese numero 1: ");
		int num2 = leerEntero("Ingrese numero 2: ");
		int suma = sumar (num1,num2);
		impr("El resultado de la suma es: ",suma);
	}
}

