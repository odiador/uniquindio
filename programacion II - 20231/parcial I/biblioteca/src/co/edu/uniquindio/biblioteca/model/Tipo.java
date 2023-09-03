package co.edu.uniquindio.biblioteca.model;

public enum Tipo {

	CIENTIFICO(0), BIOGRAFIA(1), MONOGRAFIA(2);

	int valor;

	Tipo(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
