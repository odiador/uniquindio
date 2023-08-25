package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Button;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelSuperior;
	private JPanel panelMedio;
	private JLabel lblTitulo;
	private JLabel lblNewLabel;
	private JLabel lblLado;
	private JComboBox comboBox;
	private JTextField campoLado;
	private JPanel panelFinal;
	static JButton boton;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		crearPanelSuperior();
		crearPanelMedio();
		crearPanelFinal();		
		
	}
	public void crearPanelSuperior() {
		panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		lblTitulo = new JLabel("Sacar area y perimetro a un cuadrado");
		lblTitulo.setFont(new Font("Andy", Font.PLAIN, 17));
		panelSuperior.add(lblTitulo);
		
		panelMedio = new JPanel();
		panelMedio.setLayout(new GridLayout(2,2));
		contentPane.add(panelMedio, BorderLayout.CENTER);
	}
	public void crearPanelMedio() {
		
		lblLado = new JLabel("Medida del lado");
		lblLado.setFont(new Font("Andy", Font.PLAIN, 18));
		panelMedio.add(lblLado);
		
		campoLado = new JTextField();
		panelMedio.add(campoLado);
		campoLado.setColumns(10);
		
		lblNewLabel = new JLabel("Se va a calcular el/la:");
		lblNewLabel.setFont(new Font("Andy", Font.PLAIN, 18));
		panelMedio.add(lblNewLabel);
		
		comboBox = new JComboBox();
		panelMedio.add(comboBox);
		
		comboBox.addItem("Área");
		comboBox.addItem("Perímetro");
		comboBox.addItem("Hipotenusa");
		
	}
	public void crearPanelFinal() {
		panelFinal = new JPanel();
		boton = new JButton("Calcular");
		panelFinal.add(boton);
		contentPane.add(panelFinal, BorderLayout.SOUTH);
		boton.addActionListener(this);
	}
	public double calculos (int medicion, double lado) {
		double resultado;
		if (medicion==0) resultado = funciones.Cuadrado.calcArea(lado);
		else if (medicion==1) resultado = funciones.Cuadrado.calcPerimetro(lado);
		else resultado = funciones.Cuadrado.calcHipotenusa(lado);
		return resultado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==boton) {
			double lado = Double.parseDouble(campoLado.getText());
			int opcion = comboBox.getSelectedIndex();
			double resultado = calculos(opcion,lado);
			funciones.Cuadrado.imprimir("El resultado es: "+ resultado);
			
		}
	
		
	}

}
