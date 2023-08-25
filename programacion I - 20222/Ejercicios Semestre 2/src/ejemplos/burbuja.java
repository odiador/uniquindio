package ejemplos;

import javax.swing.JOptionPane; 
public class  burbuja 
{ 
	public static void main( String[] args ) 
	{ 
		int    cantidad;
		double datos[]; 
		double ordenado[]; 

		cantidad = leerEntero ( "Ingrese la cantidad de elementos" );
		datos   = leerArregloDouble ( "Ingrese un número", cantidad ); 
		ordenado = ordenarBurbujaDobleDireccion ( datos ); 
		imprimir( "El arreglo ordenado es: " + devolverStringArreglo(ordenado)); 
	} 


	/**
	 * Permite leer un numero entero mediante una caja de dialogo 
	 * @param mensaje El mensaje que verá el usuario 
	 * @return el numero ingresado por el usuario 
	 */
	public static int leerEntero (String mensaje) 
	{
		int dato= Integer.parseInt(JOptionPane.showInputDialog(mensaje)); 
		return dato;
	}

	/**
	 * Método para leer varios numeros  y retornarlos en un arreglo 
	 * @param pregunta Texto que se muestra al usuario 
	 * @param num Cantidad de elementos a leer
	 * @return Arreglo con la informacion ingresada por el usuario 
	 */
	public static double[] leerArregloDouble ( String pregunta, int num ) 
	{ 
		double arreglo[]= new double [ num ]; 
		for ( int i = 0 ; i < num ; i++ ) 
		{
			arreglo [ i ] = leerDouble( pregunta + 	"( " + (i+1) + " de " + num + " )" ); 
		} 
		return arreglo; 
	}

	/**
	 * Permite leer un numero double mediante una caja de dialogo 
	 * @param mensaje El mensaje que verá el usuario 
	 * @return el numero ingresado por el usuario 
	 */
	public static double leerDouble (String mensaje) 
	{
		double dato= Double.parseDouble(JOptionPane.showInputDialog(mensaje)); 
		return dato;
	}

	/**
	 * Método que calcula el  promedio de un arreglo 
	 * @param arreglo   Arreglo de números 
	 * @return El promedio de los números contenidos en el arreglo 
	 */
	public static double[] ordenarBurbujaDobleDireccion( double arreglo[] ) 
	{ 
		int primero = 1, ultimo = arreglo.length - 1, dir = arreglo.length - 1;
		double aux;

		while ( ultimo >= primero )
		{
			for( int i = ultimo ; i >= primero ; i--) 
			{
				if ( arreglo [i - 1] > arreglo[ i ] ) 
				{
					aux = arreglo[i - 1]; 
					arreglo[i - 1] = arreglo[ i ]; 
					arreglo[ i ] = aux;
					dir = i; 
				}
			}
			primero = dir + 1;
			for( int i = primero ; i <= ultimo; i++ ) 
			{
				if ( arreglo [i - 1] > arreglo[ i ] ) 
				{
					aux = arreglo[i - 1]; 
					arreglo[i - 1] = arreglo[ i ]; 
					arreglo[ i ] = aux;
					dir = i;
				}
			}
			ultimo = dir - 1;
		}
		return arreglo;
	}

	/*
	 * Método que imprime el arreglo
	 */

	public static String devolverStringArreglo ( double [] arreglo ) 
	{ 
		String salida; 
		salida = "[";
		for ( int i = 0 ; i < arreglo.length ; i++ ) 
		{ 
			salida += arreglo[ i ] + " "; 
		} 
		salida +="]"; 
		return  salida; 
	} 

	/**
	 * Permite imprimir un mensaje
	 * @param mensaje El mensaje a imprimir 
	 */
	public static void imprimir (String mensaje) 
	{ 
		JOptionPane.showMessageDialog(null,mensaje); 

	}   
}