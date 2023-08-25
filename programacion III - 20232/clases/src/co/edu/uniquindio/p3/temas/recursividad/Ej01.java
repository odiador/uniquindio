package co.edu.uniquindio.p3.temas.recursividad;

/**
 * Index:
 * <li>Encontrar el resultado de elevar un numero a otro de manera recursiva
 * 
 * @author juan
 *
 */
public class Ej01 {

	public static void main(String[] args) {
		System.out.println(elevarNumeroRecursivo(5, 6));
	}

	/**
	 * Encuentra el resultado de elevar un numero a un exponente
	 * 
	 * @param num  es la base del numero
	 * @param expo es el exponente
	 * @return
	 */
	public static int elevarNumeroRecursivo(int num, int expo) {
		if (expo == 0)
			return 1;
		return num * elevarNumeroRecursivo(num, expo - 1);
	}

	/**
	 * Encuentra el resultado de elevar un numero a un exponente
	 * 
	 * @param num  es la base del numero
	 * @param expo es el exponente
	 * @return
	 */
	public static int elevarNumero(int num, int expo) {
		int resultado = 1;
		while (expo > 0) {
			resultado *= num;
			expo--;
		}
		return resultado;
	}

}
