package primerosEjercicios;


import javax.swing.JOptionPane;
//Sacar el promedio entre 3 personas (validando sin ciclos)
public class sacarPromedio3pers {
	public static double preguntarNota (String mensaje) {
		return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
	}
	public static String preguntarName (String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}
	public static boolean validarNota (double nota) {
		boolean centi = false;
		if (nota >= 0 && nota <=5) {
			centi = true;
		}
		return centi;
	}
	public static int cantGanados (double nota1,double nota2,double nota3) {
		int cant = 0;
		if (nota1>=3) cant++;
		if (nota2>=3) cant++;
		if (nota3>=3) cant++;
		return cant;
	}
	public static double calcProm (double nota1,double nota2,double nota3) {
		double promedio = 0;
		if (validarNota(nota1) == true && validarNota(nota2) == true && validarNota(nota1) == true) {
			promedio = (nota1+nota2+nota3)/3;
		} else {
			promedio = -7;
		}
		return promedio;
	}
	public static boolean empiezaenA (String name) {
		boolean centi =false;
		char letra = name.charAt(0);
		if (letra == 'A' || letra == 'a') centi = true;
		return centi;
	}


	public static String valoracion (double nota) {
		String valF = "";
		if (nota<3) valF = "deficiente";
		else if (nota>=3 &&  nota<4) valF = "aceptable";
		else if (nota>=4 &&  nota<4.5) valF = "bueno";
		else if (nota>=4.5 &&  nota<=5) valF = "excelente";
		return valF;
	}
	public static void imprimir (String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}
	public static void main (String args[]) {
		double nota1,nota2,nota3,promedio;
		int cant;
		String valorant = "";

		nota1 = preguntarNota("Ingrese la nota numero 1: ");
		nota2 = preguntarNota("Ingrese la nota numero 2: ");
		nota3 = preguntarNota("Ingrese la nota numero 3: ");
		cant = cantGanados(nota1,nota2,nota3);
		promedio = calcProm(nota1,nota2,nota3);
		valorant = valoracion(promedio);
		if (promedio == -7) imprimir("Escribiste mal una o más\nnotas, inténtalo de nuevo");
		else {
			imprimir("El promedio de los 3\nparciales es: " + promedio+",\nel estudiante ganó "	+ cant + " parcial (es) y " + "\nsu valoracion es "+valorant);
		}
	}
}