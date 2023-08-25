package model;

public class Nino {
	private String nombre;
	private int sexo;
	private boolean estaVacunado;
	private String identificacion;

	public static final int SEXO_FEMENINO = 1;
	public static final int SEXO_MASCULINO = 2;

	public Nino(String identificacion, String nombre, int sexo, boolean estaVacunado) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.sexo = sexo;
		this.estaVacunado = estaVacunado;
	}

	public Nino(String identificacion, String nombre, int sexo) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.sexo = sexo;
		this.estaVacunado = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public boolean estaVacunado() {
		return estaVacunado;
	}

	public void setEstaVacunado(boolean estaVacunado) {
		this.estaVacunado = estaVacunado;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
}
