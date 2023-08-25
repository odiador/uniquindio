import java.time.LocalDate;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        int dia = 1;
        int mes = 3;
        int anio = 2004;
        LocalDate l = LocalDate.of(anio, mes, dia);

        JOptionPane.showMessageDialog(null,
                "Real: " + l.getDayOfWeek().toString().toLowerCase() + "\nCalculado: " + getDiaSemana(l));

    }

    public static int getAnio(int anioCompleto, int mesReal) {
        int anio = anioCompleto % 100;
        if (mesRealEsEneroOFebrero(mesReal)) {
            anio--;
        }
        if (anio < 0)
            anio = 0;
        return anio;
    }

    private static boolean mesRealEsEneroOFebrero(int mesReal) {
        return mesReal > 10;
    }

    public static int getSiglo(int anioCompleto, int mesReal) {
        int anio = getAnio(anioCompleto, mesReal);
        int siglo = anioCompleto / 100;
        if (mesRealEsEneroOFebrero(mesReal) && anio == 0) {
            siglo--;
        }
        return siglo;
    }

    public static int getMes(int mes) {
        if (mes < 3) {
            return mes + 10;
        }
        return mes - 2;
    }

    public static String getDiaSemana(int ds) {
        String[] diaSm = { "domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado" };
        try {
            return diaSm[ds];
        } catch (ArrayIndexOutOfBoundsException e) {
            return e.getMessage();
        }
    }

    public static String getDiaSemana(LocalDate date) {
        return getDiaSemana(getResultado(date));
    }

    public static int getResultado(LocalDate date) {
        int anioCompleto = date.getYear();
        int mes = date.getMonthValue();
        int dia = date.getDayOfMonth();
        int mesReal = getMes(mes);
        int anio = getAnio(anioCompleto, mesReal);
        int siglo = getSiglo(anioCompleto, mesReal);
        int resultado = ((13 * mesReal - 1) / 5 + (anio / 4) + (siglo / 4)) + dia + anio - 2 * siglo;
        while (resultado < 0)
            resultado += 7;
        return resultado % 7;
    }
}
