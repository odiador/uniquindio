package parcial3Sonia;

import java.util.ArrayList;

public class p2 {
	public static void main(String[] args) {
		String[][] bolsa = {
				{"amor","leche","casa","nuevo","ensayo","amor",null,null,null},
				{"leche","miel","televisor","nevera",null,null,null,null,null},
				{"ensayo","amor","azucar","casa","miel",null,null,null,null}
		};
		ArrayList<ArrayList<String>> misDocumentos = new ArrayList<ArrayList<String>>();

		for(int i = 0;i<bolsa.length;i++) {
			ArrayList<String> documentoJ = new ArrayList<String>();
			for(int j = 0;j<bolsa[i].length;j++) {
				if(bolsa[i][j]!=null) {
					documentoJ.add(bolsa[i][j]);
				}
			}
			misDocumentos.add(documentoJ);
		}
		System.out.println("");
		System.out.println(misDocumentos);
		System.out.println(hallarVectorBolsa(misDocumentos));
	}
	public static ArrayList<String> hallarVectorBolsa(ArrayList<ArrayList<String>> misDocumentos) {
		ArrayList<String> res = new ArrayList<String>();
		for(int i = 0;i<misDocumentos.size();i++) {
			for(int j = 0;j<misDocumentos.get(i).size();j++) {
				String documento = misDocumentos.get(i).get(j);
				if(contarOcurrencias(documento,res)==0) {
					res.add(documento);
				}
			}
		}
		return res;
	}
	public static int contarOcurrencias(String cadena,ArrayList<String> vector) {
		int con = 0;
		for(int i = 0;i<vector.size();i++) {
			if(vector.get(i).equals(cadena)) {
				con++;
			}
		}
		return con;
	}

	public static String[] hallarVectorBolsaArreglo(String[][] misDocumentos) {
		int cant = 0;
		for(int i = 0;i<misDocumentos.length;i++) {
			for(int j = 0;j<misDocumentos[0].length;j++) {
				if(misDocumentos[i][j]!=null) {
					if(!seEncontro(i,j,misDocumentos)) {
						cant++;
					}
				}
			}
		}
		String res[] = new String[cant];
		int pos = 0;
		for(int i = 0;i<misDocumentos.length;i++) {
			for(int j = 0;j<misDocumentos[0].length;j++) {
				if(misDocumentos[i][j]!=null) {
					if(!seEncontro(i,j,misDocumentos)) {
						res[pos] = misDocumentos[i][j];
						pos++;
					}
				}
			}
		}
		return res;
	}
	public static boolean seEncontro(int i, int j, String[][] misDocumentos) {
		boolean seEncontro = false,termino = false;
		for(int x = 0;x<misDocumentos.length&&!termino;x++) {
			for(int y = 0;y<misDocumentos[0].length&&!termino;y++) {
				if(x==i&&y==j) {
					termino = true;
				} else {
					if(misDocumentos[x][y]!=null) {
						if(misDocumentos[i][j].equals(misDocumentos[x][y])) {
							seEncontro = true;
						}
					}
				}
			}
		}
		return seEncontro;
	}
}
