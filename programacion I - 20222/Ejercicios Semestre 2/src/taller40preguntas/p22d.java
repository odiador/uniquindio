package taller40preguntas;
import esen.cial;
/*
 * Se tiene un vector de tamaño 30, con el listado de estudiantes de un curso, y cuatro vectores
 * más de estudiantes llamados: calculo, algebraLineal, programación, electrónica, donde se
 * tienen los estudiantes que perdieron cada asignatura.
 * Crear una función que genere un vector con los estudiantes que perdieron tres asignaturas
 */
public class p22d {
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
		String arr[] = perdieron3(estudiantes, calculo, algebraLineal, programacion, electronica);
		cial.imprimir("Las personas que perdieron 3 materias fueron:\n"+cial.arregloSaString(arr));
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
	public static String[] generarArrPerdieron3 (String[] arrSinR, int[] arrFrec) {
		String res = "";
		for (int i = 0;i<arrSinR.length;i++) {
			if(arrFrec[i]==3) res += arrSinR[i]+"-";
		}
		String arrRes[] = res.split("-");
		return arrRes;
	}
	public static String[] perdieron3(String[] estudiantes, String[] calculo,
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
		String arrRes[] = generarArrPerdieron3(arrSinR,arrFrec);
		arrRes = generarInicialMayus(arrRes);
		return arrRes;
	}
	public static String[] generarInicialMayus (String arr[]) {
		String arrRes[] = new String [arr.length];
		for (int i = 0;i<arr.length;i++) {
			String cadena = "";
			for (int j = 0;j<arr[i].length();j++) {
				char letra = arr[i].charAt(j);
				if(j==0&&letra>='a'&&letra<='z') letra-=32;
				cadena+=letra+"";
			}
			arrRes[i] = cadena;
		}
		return arrRes;
	}
}
