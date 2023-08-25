package puntosArreglos;

import javax.swing.JOptionPane;

public class AbrirTodos {
	public static void main (String args[]) {
		int num = -7;
		while (num!=0) {
			num = leerInt("Escribe el numero de la pregunta a buscar (0 para cerrar)");
			switch(num) {
			case 1:
				punto01.main(null);
				break;
			case 2:
				punto02.main(null);
				break;
			case 3:
				punto03.main(null);
				break;
			case 4:
				punto04.main(null);
				break;
			case 5:
				punto05.main(null);
				break;
			case 6:
				punto06.main(null);
				break;
			case 7:
				punto07.main(null);
				break;
			case 8:
				punto08.main(null);
				break;
			case 9:
				punto09.main(null);
				break;
			case 10:
				punto10.main(null);
				break;
			}
		}

	}
	public static int leerInt(String mensaje) {
		int x;
		try {
			x = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Escribe un dato válido");
			x = leerInt(mensaje);
		}
		return x;
	}
}
