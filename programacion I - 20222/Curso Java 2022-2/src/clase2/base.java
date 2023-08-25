package clase2;
import javax.swing.JOptionPane;

public class base {

	public static int leerInt (String mensaje) {
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
	public static void imprimir (String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
	}
	public static void main(String args[]) {}
}

