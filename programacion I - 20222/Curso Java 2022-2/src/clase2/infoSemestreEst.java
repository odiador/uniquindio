package clase2;

public class infoSemestreEst {
	public static int calcHtotalesSemana(int creditos) {
		int htotales =creditos*48/16;
		return htotales;
	}
	public static double calcHorasClaseSemana(int horasClaseSemestre) {
		double horasClaseSemana = horasClaseSemestre/16;
		return horasClaseSemana;
	}
	public static double calcHIndependientes(double htotalesSemana,double horasClaseSemana) {
		double hIndependientesSemana = htotalesSemana-horasClaseSemana;
		return hIndependientesSemana;
	}
	
}
