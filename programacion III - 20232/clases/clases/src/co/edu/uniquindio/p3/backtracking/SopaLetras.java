package co.edu.uniquindio.p3.backtracking;

import java.util.Scanner;

public class SopaLetras {
	public static final int NORTE = 0;
	public static final int NORESTE = 1;
	public static final int ESTE = 2;
	public static final int SURESTE = 3;
	public static final int SUR = 4;
	public static final int SUROESTE = 5;
	public static final int OESTE = 6;
	public static final int NOROESTE = 7;
	private static int cant = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean cerrar = false;
		System.out.println("Bienvenido al Solucionador de sopas de letras.\n"
				+ "Este fue hecho por: Juan Manuel Amador y Santiago Quintero\nLa sopa de letras es:\n");
		System.out.println("La tematica de la sopa de letras es de Peliculas de Marvel.");

		final char[][] sopa = { "YWUEWUZAYSUJDUF".toCharArray(), "LOBLEXANAMNORIA".toCharArray(),
				"CRMNVJBBWLCDURY".toCharArray(), "SHULKYLIOTAKGAP".toCharArray(), "MODGRAESORWECCN".toCharArray(),
				"ARZHDVEREONHDKS".toCharArray(), "ULZERTSDLADYSBU".toCharArray(), "OTLCETEVRERANNN".toCharArray(),
				"TZNRRVEEAONAFGF".toCharArray(), "OXNAIRTDHEMHGBQ".toCharArray(), "EONLINPTMTZZFQH".toCharArray(),
				"SGINAOGXNRIBJDH".toCharArray(), "ELEPOPMANEOKTJJ".toCharArray(), "XRCLQZELEKTRARA".toCharArray(),
				"SWBXAVENGERSKZP".toCharArray() };
		do {
			imprimirSopa(sopa);
			System.out.println(
					"Las palabras a buscar de la sopa de letras son:\nAVENGERS, PANTERANEGRA, ANTMAN, THOR, DOCTORSTRANGE, IRONMAN, LOSETERNOS, HULK, DEADPOOL, XMEN, WOLVERINE, BLADE, ELEKTRA y DAREDEVIL.");
			System.out.print("Escribe la palabra a buscar: ");
			String cadena = sc.nextLine();
			System.out.println();
			resolverSopa(sopa, cadena);
			System.out.print("Deseas continuar con la ejecucion? (y/n) ");
			String next = sc.nextLine();
			if (next.equalsIgnoreCase("n"))
				cerrar = true;
			System.out.println();
		} while (cerrar == false);
		sc.close();
	}

	public static void resolverSopa(char[][] sopa, String cadena) {
		if (cadena.isEmpty()) {
			System.out.println("La cadena no puede estar vacia");
			return;
		}
		if (cadena.length() == 1) {
			System.out.println("La cadena no puede ser de una letra");
			return;
		}
		int[][] arrPosiciones = new int[cadena.length()][2];
		arrPosiciones[cadena.length() - 1][1] = -1;

		resolverSopaAux(sopa, cadena, 0, 0, arrPosiciones);
	}

	private static void resolverSopaAux(char[][] sopa, String cadena, int i, int j, int[][] arrPosiciones) {
		if (i == sopa.length) {
			if (arrPosiciones[cadena.length() - 1][1] == -1)
				System.out.println("No se ha encontrado la palabra: " + cadena);
			return;
		}
		if (j >= sopa[i].length) {
			resolverSopaAux(sopa, cadena, i + 1, 0, arrPosiciones);
			return;
		}
		if (sopa[i][j] == cadena.charAt(0)) {
			arrPosiciones[0][0] = i;
			arrPosiciones[0][1] = j;
			verificarSiguiente(sopa, cadena, i - 1, j, 1, NORTE, arrPosiciones);
			verificarSiguiente(sopa, cadena, i - 1, j + 1, 1, NORESTE, arrPosiciones);
			verificarSiguiente(sopa, cadena, i, j + 1, 1, ESTE, arrPosiciones);
			verificarSiguiente(sopa, cadena, i + 1, j + 1, 1, SURESTE, arrPosiciones);
			verificarSiguiente(sopa, cadena, i + 1, j, 1, SUR, arrPosiciones);
			verificarSiguiente(sopa, cadena, i + 1, j - 1, 1, SUROESTE, arrPosiciones);
			verificarSiguiente(sopa, cadena, i, j - 1, 1, OESTE, arrPosiciones);
			verificarSiguiente(sopa, cadena, i - 1, j - 1, 1, NOROESTE, arrPosiciones);
		}
		resolverSopaAux(sopa, cadena, i, j + 1, arrPosiciones);
	}

	public static void verificarSiguiente(char[][] sopa, String cadena, int i, int j, int posCadena, int opt,
			int[][] arrPosiciones) {
		if (cadena.length() == posCadena) {
			System.err.println("Se encontro la palabra: \"" + cadena + "\" cantidad: " + (++cant));
			imprimirResultados(sopa, arrPosiciones);
			return;
		}
		if (i >= 0 && j >= 0 && i < sopa.length && j < sopa[i].length && cadena.charAt(posCadena) == sopa[i][j]) {
			arrPosiciones[posCadena][0] = i;
			arrPosiciones[posCadena][1] = j;
			posCadena++;
			switch (opt) {
			case NORTE:
				verificarSiguiente(sopa, cadena, i - 1, j, posCadena, NORTE, arrPosiciones);
				break;
			case NORESTE:
				verificarSiguiente(sopa, cadena, i - 1, j + 1, posCadena, NORESTE, arrPosiciones);
				break;
			case ESTE:
				verificarSiguiente(sopa, cadena, i, j + 1, posCadena, ESTE, arrPosiciones);
				break;
			case SURESTE:
				verificarSiguiente(sopa, cadena, i + 1, j + 1, posCadena, SURESTE, arrPosiciones);
				break;
			case SUR:
				verificarSiguiente(sopa, cadena, i + 1, j, posCadena, SUR, arrPosiciones);
				break;
			case SUROESTE:
				verificarSiguiente(sopa, cadena, i + 1, j - 1, posCadena, SUROESTE, arrPosiciones);
				break;
			case OESTE:
				verificarSiguiente(sopa, cadena, i, j - 1, posCadena, OESTE, arrPosiciones);
				break;
			case NOROESTE:
				verificarSiguiente(sopa, cadena, i - 1, j - 1, posCadena, NOROESTE, arrPosiciones);
				break;
			}
		}
	}

	public static void imprimirSopa(char[][] mat) {
		System.out.println("- - - - - - - - - - - - - - - ");
		imprimirSopaAux(mat, 0, 0);
		System.out.println("- - - - - - - - - - - - - - - ");
	}

	public static void imprimirResultados(char[][] mat, int[][] arrPosiciones) {
		System.out.println("- - - - - - - - - - - - - - - ");
		imprimirResultadosAux(mat, 0, 0, arrPosiciones);
		System.out.println("- - - - - - - - - - - - - - - ");
	}

	public static void imprimirSopaAux(char[][] mat, int i, int j) {
		if (i == mat.length)
			return;
		if (j >= mat[i].length) {
			System.out.println();
			imprimirSopaAux(mat, i + 1, 0);
			return;
		}
		System.out.print(mat[i][j] + " ");
		imprimirSopaAux(mat, i, j + 1);
	}

	public static void imprimirResultadosAux(char[][] mat, int i, int j, int[][] arrPosiciones) {
		if (i == mat.length)
			return;
		if (j >= mat[i].length) {
			System.out.println();
			imprimirResultadosAux(mat, i + 1, 0, arrPosiciones);
			return;
		}
		System.out.print((posMarcada(i, j, 0, arrPosiciones) ? '*' : mat[i][j]) + " ");
		imprimirResultadosAux(mat, i, j + 1, arrPosiciones);
	}

	private static boolean posMarcada(int i, int j, int k, int[][] arrPosiciones) {
		if (k == arrPosiciones.length)
			return false;
		if (arrPosiciones[k][0] == i && arrPosiciones[k][1] == j)
			return true;
		return posMarcada(i, j, k + 1, arrPosiciones);
	}

}
