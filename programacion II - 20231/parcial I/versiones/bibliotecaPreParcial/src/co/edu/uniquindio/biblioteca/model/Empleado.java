package co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;

public class Empleado {

	private String nombre;
	private double salario;
	private String cargo;
	private ArrayList<Prestamo> listaPrestamos;
	private int aniosExperiencia;
	
	
	public Empleado(String nombre, double salario, String cargo) {
		super();
		this.nombre = nombre;
		this.salario = salario;
		this.cargo = cargo;
		this.listaPrestamos = new ArrayList<Prestamo>();
	}
	
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", salario=" + salario + ", cargo=" + cargo + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}


	
}
