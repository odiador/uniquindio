package taller40preguntas;
import esen.cial;
/*
 * Se tiene un vector de tamaño 30, con el listado de estudiantes de un curso, y cuatro vectores
 * más de estudiantes llamados: calculo, algebraLineal, programación, electrónica, donde se
 * tienen los estudiantes que perdieron cada asignatura.
 * Crear un funciona que muestre el estudiantes que más asignaturas perdió.
 */
public class p22e {
	public static void main (String args[]) {
		String estudiantes[] =
			{"juan","pedro","Andres","Maria","carlos",
			 "Jose","Marcos","Laura","manuel","emmanuel",
			 "Hugo","Ricardo","Otto","Ana","mariana",
			 "mano","eduardo","mariano","lamba","lufi",
			 "otocus","daniel","daniela","ibai","levi",
			 "eren","sara","sarah","jessica","natalia"};
		String calculo[] = {"Carlos","pedro"};
		String algebraLineal[] = {"Andres","Carlos","pedro"};
		String programacion[] = {"Juan","Maria","Pedro","natalia"};
		String electronica[] = {"andres","Pedro"};
		String res = sacarPerdioMas(estudiantes, calculo, algebraLineal, programacion, electronica);
		cial.imprimir("La persona que perdio mas materias fue:\n"+res);
	}
	public static String fixearCadena (String cadena) {
		int cant = cadena.length();
		String res = "";
		for(int i = 0;i<cant;i++) {
			char letra = cadena.charAt(i);
			if(letra>='A'&&letra<='Z') letra+=32;
			if(letra=='Á') letra='á';
			if(letra=='É') letra='é';
			if(letra=='Í') letra='í';
			if(letra=='Ó') letra='ó';
			if(letra=='Ú') letra='ú';
			res += letra+"";
		}
		return res;
	}
	public static String[] fixearArr (String arr[]) {
		int cant = arr.length;
		String res[] = new String[cant];
		for(int i = 0;i<cant;i++) {
			res[i] = fixearCadena(arr[i]);
		}
		return res;
	}
	public static String[] eliminarRepetidos (String[] arr) {
		String res = "";
		int cant = arr.length;
		for(int i = 0;i<cant;i++) {
			boolean estaLibre = true;
			for (int j = 0;j<i;j++) {
				if (arr[i].equals(arr[j])) estaLibre = false;
			}
			if (estaLibre) res+=arr[i]+"-";
		}
		String arrRes[] = res.split("-");
		return arrRes;
	}
	public static String[] juntarArr(String[] arr1,String arr2[]) {
		String res = "";
		for (int i = 0;i<arr1.length;i++) {
			res+=arr1[i]+"-";
		}
		for (int i = 0;i<arr2.length;i++) {
			res+=arr2[i]+"-";
		}
		String arrRes[] = res.split("-");
		return arrRes;
	}
	public static int[] calcArrFrecuencias(String arr[],String arrSinR[]) {
		int arrFrec[] = new int [arrSinR.length];
		for(int i = 0;i<arrSinR.length;i++) {
			int cant = 0;
			for(int j = 0;j<arr.length;j++) {
				if (arrSinR[i].equals(arr[j])) cant++;
			}
			arrFrec[i] = cant;
		}
		return arrFrec;
	}
	public static String calcularCadenaMayor (String[] arrSinR, int[] arrFrec) {
		int posMayor = 0;
		int mayor = arrFrec[0];
		for (int i = 1;i<arrFrec.length;i++) {
			if(arrFrec[i]>mayor) {
				mayor = arrFrec[i];
				posMayor = i;
			}
		}
		String cadenaMayor = arrSinR[posMayor];
		return cadenaMayor;
	}
	public static String sacarPerdioMas (String[] estudiantes, String[] calculo,
			String[] algebraLineal, String[] programacion, String[] electronica) {
		calculo = fixearArr(calculo);
		algebraLineal= fixearArr(algebraLineal);
		programacion = fixearArr(programacion);
		electronica = fixearArr(electronica);
		String arrPerdieron[];
		arrPerdieron = juntarArr(calculo,algebraLineal);
		arrPerdieron = juntarArr(arrPerdieron,programacion);
		arrPerdieron = juntarArr(arrPerdieron,electronica);
		String arrSinR[] = eliminarRepetidos(arrPerdieron);
		int arrFrec[] =calcArrFrecuencias(arrPerdieron, arrSinR);
		String res = calcularCadenaMayor(arrSinR,arrFrec);
		res = pasarInicialMayus(res);
		return res;
	}
	public static String pasarInicialMayus (String cadena) {
		String res = "";
		for (int j = 0;j<cadena.length();j++) {
			char letra = cadena.charAt(j);
			if(j==0&&letra>='a'&&letra<='z') letra-=32;
			res+=letra+"";
		}
		return res;
	}
}
