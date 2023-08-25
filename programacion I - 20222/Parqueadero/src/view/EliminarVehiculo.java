package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EliminarVehiculo extends JFrame implements ActionListener {
	private JLabel titulo, nombre, contenedorNombre, telefono, contenedorTelefono, placa, contenedorPlaca, modelo,
			contenedorModelo;
	private JPanel panelSuperior, panelCentral, panelInferior;
	private JButton btnEliminar, btnCancelar;
	private int guardaI;
	private int guardaJ;
	private GenerarMatrizBotones miVentanaBotones;
	private VentanaPrincipal miVentanaPrincipal;

	public EliminarVehiculo(int guardaI, int guardaJ, GenerarMatrizBotones miVentanaBotones,
			VentanaPrincipal miVentanaPrincipal) {
		this.guardaI = guardaI;
		this.guardaJ = guardaJ;
		this.miVentanaBotones = miVentanaBotones;
		this.miVentanaPrincipal = miVentanaPrincipal;
		crearPanelSupe();
		crearPanelCentral();
		crearPanelInferior();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public void crearPanelSupe () {
		panelSuperior = new JPanel();

		titulo = new JLabel("ESTE CAMPO ESTA OCUPADO POR: ");
		panelSuperior.add(titulo);

		getContentPane().add(panelSuperior, BorderLayout.NORTH);
	}

	public void crearPanelCentral () {
		panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(4, 2));

		nombre = new JLabel("NOMBRE: ");
		telefono = new JLabel("TELEFONO: ");
		placa = new JLabel("PLACA: ");
		modelo = new JLabel("MODELO: ");

		contenedorNombre = new JLabel(miVentanaPrincipal.getPropietario(guardaI, guardaJ).getNombre());
		contenedorTelefono = new JLabel(miVentanaPrincipal.getPropietario(guardaI, guardaJ).getTelefono());
		contenedorPlaca = new JLabel(miVentanaPrincipal.getMiVehiculo(guardaI, guardaJ).getPlaca());
		contenedorModelo = new JLabel("" + miVentanaPrincipal.getMiVehiculo(guardaI, guardaJ).getModelo());

		panelCentral.add(nombre);
		panelCentral.add(contenedorNombre);
		panelCentral.add(telefono);
		panelCentral.add(contenedorTelefono);
		panelCentral.add(placa);
		panelCentral.add(contenedorPlaca);
		panelCentral.add(modelo);
		panelCentral.add(contenedorModelo);

		getContentPane().add(panelCentral, BorderLayout.CENTER);
	}

	public void crearPanelInferior () {
		panelInferior = new JPanel();

		btnEliminar = new JButton("Eliminar");
		btnCancelar = new JButton("Cancelar");

		this.btnEliminar.addActionListener(this);
		this.btnCancelar.addActionListener(this);

		panelInferior.add(btnEliminar);
		panelInferior.add(btnCancelar);

		getContentPane().add(panelInferior, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			miVentanaPrincipal.eliminarVehiculo(guardaI, guardaJ);
			;
			miVentanaBotones.despintarCasilas(guardaI, guardaJ);
			this.setVisible(false);

			miVentanaBotones.setVisible(true);
		}

		if (e.getSource() == btnCancelar) {
			this.setVisible(false);

			miVentanaBotones.setVisible(true);
		}
	}

}
