package aplicacion;

import view.VentanaPrincipal;
/**
 * Clase Aplicacion
 * @author sonia
 *
 */
public class Aplicacion {

/**
 * Metodo principal
 * @param args Los argumentos de la linea de comandos
 */
public static void main(String[] args)
{
		VentanaPrincipal ventana1=new VentanaPrincipal();

		ventana1.setBounds(0, 0, 500, 150);
		ventana1.setLocationRelativeTo(null);
		ventana1.setVisible(true);
}
}
