package co.edu.uniquindio.biblioteca.test;

import org.junit.Assert;

import javax.swing.JOptionPane;

import org.junit.Test;

import co.edu.uniquindio.biblioteca.model.*;

public class TestsParcial {
    @Test
    public void TestParcialPunto3() {
        Biblioteca biblioteca = new Biblioteca("Biblioteca UQ", "calle 3N 23 - 40", "3128629619");

        try {
            String resCrearEstudiante = biblioteca.crearEstudiante("Juan", "Amador", 10, "Ing. Sistemas", "Activo",
                    "1234565432");
            Assert.assertEquals(resCrearEstudiante, "El estudiante ha sido registrado");
        } catch (BibliotecaException e) {
            Assert.fail(e.getMessage());
        }
        try {
            String resCrearEmpleado = biblioteca.crearEmpleado("Juse", 2000000d, "Granjero", TipoEmpleado.AUXILIAR);
            Assert.assertEquals(resCrearEmpleado, "El estudiante ha sido registrado");
        } catch (BibliotecaException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void TestErrorEstudiantesMismoId() {
        Biblioteca biblioteca = new Biblioteca("Biblioteca UQ", "calle 3N 23 - 40", "3128629619");

        try {
            String resCrearEstudiante = biblioteca.crearEstudiante("Juan", "Amador", 10, "Ing. Sistemas", "Activo",
                    "1234565432");
            Assert.assertEquals(resCrearEstudiante, "El estudiante ha sido registrado");
        } catch (BibliotecaException e) {
            Assert.fail(e.getMessage());
        }
        try {
            String resCrearEstudiante = biblioteca.crearEstudiante("Juan", "Amador", 10, "Ing. Sistemas", "Activo",
                    "1234565432");
            Assert.assertEquals(resCrearEstudiante, "El estudiante ha sido registrado");
        } catch (BibliotecaException e) {
            Assert.fail(e.getMessage());
        }
    }

}
