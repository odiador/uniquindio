package actividadArrayList;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Dado un ArrayList de códigos de 10 dígitos (códigos especiales), cumplir con los
requerimientos que se plantean.
Cada código especial contiene 10 dígitos y se gestiona como un String. En los códigos pueden
existir dígitos repetidos. Todo código tiene un código de comprobación (el último digito).
Por ejemplo para el código: “MWZKF72651”, el dígito de comprobación es: 1 (último dígito).
Cada código en su interior se divide en dos mitades. La primera mitad con los primeros cinco
letras y la segunda mitad con los siguientes cinco dígitos.
Por ejemplo para el para el código: “MWZKF72651”, la primera mitad es “MWZKF” y la
segunda mitad es” 72651”

Se deben cumplir los siguientes requerimientos:
1. Mostrar el código o los códigos que tengan más de tres letras en el rango de B – F.
2. Eliminar los códigos que contengan más de tres números impares.
3. Insertar un elemento en la posición siguiente al primer número que se identifique con
el digito de comprobación 1.
4. Mostrar los códigos que tengan la secuencia DBA.
5. Ordenar los dígitos con base en la primera mitad del código.
Se debe presentar el menú de opciones utilizando do-while y switch.
 */
public class taller {
	public static void main (String []args) {
		String codigos[] = {"BDBAF62661","DBDAE17317","FDBAF77201","SDABQ21782","GDBAQ10582"};
		ArrayList<String> arr = generarArrayList(codigos);
		int opcion = -1;
		do {
			opcion = leerInt("Taller manejo de ArrayList | Juan Manuel Amador y Fabián Esteban Valencia"
					+ "\n Codigos: "+arr
					+ "\n1. Mostrar el código o los códigos que tengan más de tres letras en el rango de B – F."
					+ "\n2. Eliminar los códigos que contengan más de tres números impares."
					+ "\n3. Insertar un elemento en la posición siguiente al primer número que se identifique con"
					+ "\nel digito de comprobación 1."
					+ "\n4. Mostrar los códigos que tengan la secuencia DBA."
					+ "\n5. Ordenar los dígitos con base en la primera mitad del código.");
			switch (opcion) {
			case 1: imprimirPunto1(arr);
			break;
			case 2: imprimirPunto2(arr);
			break;
			case 3: imprimirPunto3(arr);
			break;
			case 4: imprimirPunto4(arr);
			break;
			case 5: imprimirPunto5(arr);
			break;
			case 0: System.exit(0);
			break;
			}
		} while (opcion!=0);
	}
	/******************Utilidades**************
	 *Metodos que sirven para todos los puntos*
	 ******************************************
	 */
	public static ArrayList<String> generarArrayList (String codigos[]){
		ArrayList<String> arr = new ArrayList<String>();
		for(int i = 0;i<codigos.length;i++) {
			arr.add(codigos[i]);
		}
		return arr;
	}
	public static ArrayList<String> generarMitad1 (ArrayList<String> arr){
		ArrayList<String> arrM1 = new ArrayList<String>();
		for (int i = 0;i<arr.size();i++) {
			String cadena = arr.get(i);
			arrM1.add(cadena.substring(0,5));
		}
		return arrM1;
	}
	public static ArrayList<Integer> generarMitad2 (ArrayList<String> arr){
		ArrayList<Integer> arrM1 = new ArrayList<Integer>();
		for (int i = 0;i<arr.size();i++) {
			String cadena = arr.get(i);
			arrM1.add(Integer.parseInt(cadena.substring(5,10)));
		}
		return arrM1;
	}
	public static int leerInt(String msg) {
		int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
		return num;
	}
	public static String leerString(String msg) {
		String cadena = JOptionPane.showInputDialog(msg);
		return cadena;
	}
	public static void imprimir(String msg) {
		JOptionPane.showMessageDialog(null, msg);;
	}
	public static String pasarAMayus(String cadena) {
		String res = "";
		for(int i = 0;i<cadena.length();i++) {
			char letra = cadena.charAt(i);
			if(letra>='a'&&letra<='z') {
				letra-=32;
			}
			res+=letra+"";
		}
		return res;
	}

	/*
	 ***********************************Punto 1*******************************************
	 *Mostrar el código o los códigos que tengan más de tres letras en el rango de B – F.*
	 *************************************************************************************
	 */
	public static int detCantEntreB_F (String cadena){
		int cant = cadena.length();
		int contador = 0;
		for(int i = 0;i<cant;i++) {
			char letra = cadena.charAt(i);
			if(letra>='B'&&letra<='F') {
				contador++;
			}
		}
		return contador;
	}
	public static String generarCadenaEntreB_F (ArrayList<String> arr) {
		String cadena = "";
		ArrayList<String> primeraMitad = generarMitad1(arr);
		for(int i = 0;i<primeraMitad.size();i++) {
			int cant = detCantEntreB_F(primeraMitad.get(i));
			if(cant>3) {
				cadena+=arr.get(i)+" ";
			}
		}
		return cadena;
	}
	public static void imprimirPunto1(ArrayList<String> arr) {
		String res = generarCadenaEntreB_F(arr);
		imprimir("El/los codigos que tienen mas de 3 letras entre B y F son: "+res);
	}
	//PUNTO 2

	public static ArrayList<String> arregloNuevo ( ArrayList<String> arreglo)
    {
        ArrayList<String>arregloNuevo= (ArrayList<String>) arreglo.clone();

        ArrayList<Integer> mitad2 = generarMitad2(arreglo);
        for(int i=0;i<mitad2.size();i++)
        {
            int condicion= numerosImpares(mitad2.get(i));

            if(condicion>=3)
            {
                arregloNuevo.remove(i);
            }
        }

        return arregloNuevo;
    }
	public static void imprimirPunto2(ArrayList<String> arr) {
		ArrayList<String> res = arregloNuevo(arr);
		imprimir("El resultado es: "+res);
	}


    public static int numerosImpares(int num)
    {

        int cont=0;
        String num1=num+"";

        for(int i =0; i<num1.length();i++)
        {

            char n=num1.charAt(i);
            int n1=Integer.parseInt(num1);

            if(n1%2!=0)
            {
                cont++;
            }

        }
        return cont;
    }
    public static boolean comprobarCodigoVerficacion(int num)
    {
        boolean esUno=false;
        String numS=num+"";

        char letra= numS.charAt(numS.length()-1);
        String n=letra+"";

        int n1=Integer.parseInt(n);

        if(n1==1)
        {
            esUno=true;
        }

        return esUno;
    }


    public static ArrayList<String> newArr(ArrayList<String> arr)
    {
        ArrayList<String>arregloNuevo=new ArrayList<String>();

        ArrayList<Integer> mitad2= generarMitad2 (arr);
        String dato = leerString("Ingrese dato: ");
        boolean marcador = true;
        for(int i=0;i<arr.size();i++)
        {

            arregloNuevo.add(arr.get(i));

            int num=mitad2.get(i);
            boolean condicion=comprobarCodigoVerficacion(num);

            if(condicion==true&&marcador)
            {
                arregloNuevo.add(dato);
                marcador = false;
            }
        }

        return arregloNuevo;
    }

	public static void imprimirPunto3(ArrayList<String> arr) {
		ArrayList<String> res = newArr(arr);
		imprimir("El nuevo arreglo es: "+res);
	}
	/*****************************************************
	 *4. Mostrar los códigos que tengan la secuencia DBA.*
	 *****************************************************
	 */
	public static boolean tieneSecuenciaDBA (String cadena) {
		boolean res = false;
		String secuencia = "DBA";
		int cantSecuencia = secuencia.length();
		int cant = cadena.length();
		for(int i = cantSecuencia;i<=cant;i++) {
			String pedazo = cadena.substring(i-cantSecuencia,i);
			if(pedazo.equals(secuencia)) {
				res = true;
				break;
			}
		}
		return res;
	}
	public static String determinarCodSecuencia (ArrayList<String> arr) {
		String cadena = "";
		ArrayList<String> primeraMitad = generarMitad1(arr);
		for(int i = 0;i<primeraMitad.size();i++) {
			if(tieneSecuenciaDBA(primeraMitad.get(i))) {
				cadena+=primeraMitad.get(i)+" ";
			}
		}
		return cadena;
	}
	public static void imprimirPunto4(ArrayList<String> arr) {
		String res = determinarCodSecuencia(arr);
		imprimir("El/los codigos que tienen secuencia 'DBA' son: "+res);
	}
/*****************************************************************
 *5. Ordenar los dígitos con base en la primera mitad del código.*
 *****************************************************************
 */
	public static String ordenarCadena(String cadena,String cadenaCompleta) {
		ArrayList<Character> cadenaChar = new ArrayList<Character>();
		int cant = cadena.length();
		for(int i = 0;i<cant;i++) {
			cadenaChar.add(cadena.charAt(i));
		}
		for (int i = 0;i<cant-1;i++) {
			for (int x = i+1;x<cant;x++) {
				if(cadenaChar.get(x)<cadenaChar.get(i)) {
						char aux =cadenaChar.get(i);
						cadenaChar.set(i,cadenaChar.get(x));
						cadenaChar.set(x,aux);
				}
			}
		}
		String cadenaNums = cadenaCompleta.substring(5,10);
		String cadenaRes = "";
		for (int i = 0;i<cant;i++) {
			cadenaRes+=cadenaChar.get(i);
		}
		String res = cadenaRes+cadenaNums;
		return res;
	}
	public static ArrayList<String> ordenarArr(ArrayList<String> arr) {
		ArrayList<String> mitad1 = generarMitad1(arr);
		ArrayList<String> nuevoArr = new ArrayList<String>();
		for(int i = 0;i<arr.size();i++) {
			nuevoArr.add(ordenarCadena(mitad1.get(i),arr.get(i)));
		}
		return nuevoArr;
	}
	public static void imprimirPunto5(ArrayList<String> arr) {
		ArrayList<String> res = ordenarArr(arr);
		imprimir("El arreglo orenado es: "+res);
	}
}