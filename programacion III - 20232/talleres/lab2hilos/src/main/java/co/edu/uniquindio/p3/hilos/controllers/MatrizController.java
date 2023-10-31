package co.edu.uniquindio.p3.hilos.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MatrizController implements Initializable {

	@FXML
	private Pane panel;
	private Rectangle[][] matriz1, matriz2;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		// Se inicializan las dos matrices, una al lado de la otra
		matriz1 = crearMatrizBotones(4, 0);
		matriz2 = crearMatrizBotones(4, 250);
	}

	public void iniciarLlenado() {
		// Se llena la primer matriz al dar click en el botón de la ventana
		new Thread(() -> llenarMatriz1(matriz1)).start();
		new Thread(() -> llenarMatriz2(matriz2)).start();

	}

	private void llenarMatriz1(Rectangle[][] m) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				// En cada iteración se actualiza el color de fondo a rojo
				m[i][j].setFill(Color.RED);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}

	}

	private void llenarMatriz2(Rectangle[][] m) {

		int max = m.length + m[0].length - 1;
		int j = 0;
		int i = 0;
		for (int x = 0; x < max; x++) {
			j = x;
			i = 0;
			while (j >= 0) {
				if (i < m.length && j < m[0].length) {
					m[i][j].setFill(Color.BLUE);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
				i++;
				j--;
			}
		}

	}

	private Rectangle[][] crearMatrizBotones(int n, int xInicial) {

		Rectangle[][] botones = new Rectangle[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				Rectangle boton = new Rectangle();
				boton.setWidth(50);
				boton.setHeight(50);
				boton.setFill(Color.WHITE);

				// En cada iteración se actualiza la posición del botón en el eje X, X cambia
				// cuando cambia el valor de j. Ya que x representa las columnas (horizontal).
				boton.setLayoutX(xInicial + (50 + 3) * j);

				// En cada iteración se actualiza la posición del botón en el eje Y, Y cambia
				// cuando cambia el valor de i. Ya que y representa las fila (vertical).
				boton.setLayoutY((50 + 3) * i);

				botones[i][j] = boton;

				// El botón se añade al panel para poder visualizarlo
				panel.getChildren().add(boton);

			}
		}
		return botones;
	}
}
