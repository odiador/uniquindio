package taller40preguntas;
import esen.cial;
/*
 * Se tiene un vector de tamaño 30, con el listado de estudiantes de un curso, y cuatro vectores
 * más de estudiantes llamados: calculo, algebraLineal, programación, electrónica, donde se
 * tienen los estudiantes que perdieron cada asignatura.
 * Crear una función que genere un vector con los estudiantes que ganaron todas las asignaturas.
 */
public class p22a {
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
		String arr[] = ganaronTodas(estudiantes, calculo, algebraLineal, programacion, electronica);
		cial.imprimir(cial.arregloSaString(arr));
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
		System.out.println(cial.arregloSaString(res));
		return res;
	}
	public static String[] ganaronTodas(String[] estudiantes, String[] calculo,
			String[] algebraLineal, String[] programacion, String[] electronica) {
		estudiantes = fixearArr(estudiantes);
		calculo = fixearArr(calculo);
		algebraLineal = fixearArr(algebraLineal);
		programacion = fixearArr(programacion);
		electronica = fixearArr(electronica);
		int cant = estudiantes.length;
		int cantAux = calculo.length;
		String ganaronCalc = "";
		for (int i = 0; i<cant;i++) {
			int cantAux2 = 0;
			for (int j = 0; j<cantAux;j++) {
				if (!estudiantes[i].equals(calculo[j])) cantAux2++;
			}
			if (cantAux == cantAux2) ganaronCalc+=estudiantes[i]+"-";
		}
		String arrGCalc[] = ganaronCalc.split("-");
		cant = arrGCalc.length;
		cantAux = algebraLineal.length;
		String g12 = "";
		for (int i = 0; i<cant;i++) {
			int cantAux2 = 0;
			for (int j = 0; j<cantAux;j++) {
				if (!arrGCalc[i].equals(algebraLineal[j])) cantAux2++;
			}
			if (cantAux == cantAux2) g12+=arrGCalc[i]+"-";
		}
		String arrG12[] = g12.split("-");
		cant = arrG12.length;
		cantAux = programacion.length;
		String g123 = "";
		for (int i = 0; i<cant;i++) {
			int cantAux2 = 0;
			for (int j = 0; j<cantAux;j++) {
				if (!arrG12[i].equals(programacion[j])) cantAux2++;
			}
			if (cantAux == cantAux2) g123+=arrG12[i]+"-";
		}
		String arrG123[] = g123.split("-");
		cant = arrG123.length;
		cantAux = electronica.length;
		String ganaronTodos = "";
		for (int i = 0; i<cant;i++) {
			int cantAux2 = 0;
			for (int j = 0; j<cantAux;j++) {
				if (!arrG123[i].equals(electronica[j])) cantAux2++;
			}
			if (cantAux == cantAux2) ganaronTodos+=arrG123[i]+"-";
		}
		String arrGanaronTodos[] = ganaronTodos.split("-");
		return arrGanaronTodos;
	}
}
