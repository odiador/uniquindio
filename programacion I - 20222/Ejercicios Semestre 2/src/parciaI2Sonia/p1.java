package parciaI2Sonia;

import java.util.ArrayList;

public class p1 {

	public static void main (String[] args) {
		String arregloPdfs[] = {"archiv234.pdf","ar4hg9856.pdf","camisa125pft.txt","programacion120222.pdf"};
		ArrayList<String> arrayListPdfs = new ArrayList<String>();
		for (int i = 0; i < arregloPdfs.length; i++) {
			arrayListPdfs.add(arregloPdfs[i]);
		}
		System.out.println(devolverPdfsOrdenados(arrayListPdfs));

	}
	public static int contarDigitosPalabra (String nombrePdf) {
		int cantidad = 0;
		boolean centi = false;
		for(int i = 0;i<nombrePdf.length();i++) {
			char letra = nombrePdf.charAt(i);
			if(letra!='.'&&centi == false) {
				if(letra>='0'&&letra<='9') {
					cantidad++;
				}
			}
			else {
				centi = true;
			}
		}
		return cantidad;
	}
	public static ArrayList<String> devolverSoloPdfs (ArrayList<String> nombresArch) {
		ArrayList<String> nombrespdfs = new ArrayList<String>();
		for(int i = 0;i<nombresArch.size();i++) {
			boolean centi = false;
			String parteFinal = "";
			for(int j = 0;j<nombresArch.get(i).length();j++) {
				char letra = nombresArch.get(i).charAt(j);
				if(centi == true) {
					parteFinal+=letra;
				}
				if(letra=='.') {
					centi = true;
				}
			}
			if(parteFinal.equals("pdf")) {
				nombrespdfs.add(nombresArch.get(i));
			}
		}
		return nombrespdfs;
	}
	public static void ordenarBurbuja (ArrayList<String> nombresArch) {
		for(int i = 0;i<nombresArch.size();i++) {
			for(int j = i+1;j<nombresArch.size();j++) {
				if(contarDigitosPalabra(nombresArch.get(i))>contarDigitosPalabra(nombresArch.get(j))) {
					String aux = nombresArch.get(i);
					nombresArch.set(i, nombresArch.get(j));
					nombresArch.set(j, aux);
				}
			}
		}
	}
	public static ArrayList<String> devolverPdfsOrdenados (ArrayList<String> nombresArch) {
		ArrayList<String> nombrespdfs = devolverSoloPdfs(nombresArch);
		ordenarBurbuja(nombrespdfs);
		return nombrespdfs;
	}
}
