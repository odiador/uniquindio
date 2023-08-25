package primerosEjercicios;


import javax.swing.JOptionPane;

//Determinar cuantos son mayores de edad de 3 personas
public class mayorde18p3 {
	public static int ingresarNum (String mensaje) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
	}
	public static void imprimir (String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
	public static int mayoresdeedad (int edad1, int edad2, int edad3) {
		int cant = 0;
		if (edad1 >= 18) cant++;
		if (edad2 >= 18) cant++;
		if (edad3 >= 18) cant++;
		return cant;
	}
	public static void main (String args[]) {
		int edad1,edad2,edad3;
		edad1 = ingresarNum("Escriba la edad de la persona 1: ");
		edad2 = ingresarNum("Escriba la edad de la persona 2: ");
		edad3 = ingresarNum("Escriba la edad de la persona 3: ");
		int mayores18 = mayoresdeedad(edad1,edad2,edad3);
		imprimir("La cantidad de personas mayores de edad es de: "+mayores18);
		
	}
}
