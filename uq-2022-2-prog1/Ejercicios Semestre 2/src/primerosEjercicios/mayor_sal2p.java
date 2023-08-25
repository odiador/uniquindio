package primerosEjercicios;


import javax.swing.JOptionPane;

//Determinar el que tiene mayor salario (2 personas)
public class mayor_sal2p {
	public static double ingresarSal (String mensaje) {
		return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
	}
	public static String ingresarName (String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}
	public static void imprimir (String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
	public static String calcMayor (double sal1,double sal2,String name1,String name2) {
		String final1 = "";
		if (sal1 > sal2) final1 = "El salario mayor es: "+sal1+" y su nombre es: "+ name1;
		else final1 = "El salario mayor es: "+sal2+" y su nombre es: "+ name2;
		return final1;
	}
	public static void main (String args[]) {
		double sal1,sal2;
		String name1,name2;
		sal1 = ingresarSal("Escriba el salario de la persona 1: ");
		name1 = ingresarName("Escriba el nombre de la persona 1: ");
		sal2 = ingresarSal("Escriba el salario de la persona 2: ");
		name2 = ingresarName("Escriba el nombre de la persona 2: ");
		String mayor = calcMayor(sal1,sal2,name1,name2);
		imprimir(mayor);
	}
}
