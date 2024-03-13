package clase2302;

import java.util.ArrayList;

public class TestSuperExtends {
	public TestSuperExtends() {
		ArrayList<? extends Empleado> listEmpleado = new ArrayList<>();
		ArrayList<? super Auxiliar> listAuxiliar = new ArrayList<>();
	}
}
