package pagina133;
import esen.cial;

public class vocalesLuegoCons {
	public static String reordenarCadena (String cadena) {
		String cadenaNueva="";
		for (int i = 0; i<cadena.length();i++){
			char letra = cadena.charAt(i);
			if (letra>='A'&&letra<='Z') letra = (char) (letra+32);
			if (letra>='a'&&letra<='z'&&(letra=='a'||letra=='e'||letra=='i'||letra=='o'||letra=='u')) cadenaNueva+=""+letra;
		}
		for (int i = 0; i<cadena.length();i++){
			char letra = cadena.charAt(i);
			if (letra>='A'&&letra<='Z') letra = (char) (letra+32);
			if (letra>='a'&&letra<='z'&&(letra!='a'&&letra!='e'&&letra!='i'&&letra!='o'&&letra!='u')) cadenaNueva+=""+letra;
		}
		return cadenaNueva;
	}
	public static void main(String[] args) {
		String cadena =cial.leerString("Escriba la cadena:");
		String cadenaNueva = reordenarCadena (cadena);
		cial.imprimir("La cadena nueva es: "+cadenaNueva);
	}
}