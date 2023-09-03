package co.edu.uniquindio.biblioteca.model;

public class Util {
    public static int contarVocales(String cadena) {
        int cant = 0;

        for (int i = 0; i < cadena.length(); i++) {
            if (esVocal(cadena.charAt(i)))
                cant++;
        }
        return cant;

    }

    public static boolean esVocal(char letra) {
        char[] vocales = { 'a', 'b', 'c', 'd', 'e' };
        for (char vocal : vocales) {
            String vocalString = vocal + "";
            String letraString = letra + "";
            if (vocalString.equalsIgnoreCase(letraString)) {
                return true;
            }
        }
        return false;
    }
}
