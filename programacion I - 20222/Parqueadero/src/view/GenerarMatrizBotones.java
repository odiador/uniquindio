package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Parqueadero;
import model.Puesto;
import model.Vehiculo;

public class GenerarMatrizBotones extends JFrame implements ActionListener
{

	private JPanel contenedorSuperior, contenedorCentral, contenedorInferior;
	private JLabel titulo;
	private JButton matrizBotones[][], agregarVehiculo, consulta;
	private int tamanio;
	private VentanaPrincipal miVentanaPrincipal;
	private AgregarVehiculo miVentanaAgregar;
	private EliminarVehiculo miVentanaEliminar;

	public GenerarMatrizBotones(int tamanio, VentanaPrincipal miVentanaPrincipal)
	{
		this.tamanio=tamanio;
		this.miVentanaPrincipal=miVentanaPrincipal;
		panelSuperior();
		panelCentral();
		panelInferior();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public void panelSuperior()
	{
		contenedorSuperior=new JPanel();

		titulo=new JLabel("MATRIZ DE BOTONES");

		contenedorSuperior.add(titulo);

		this.add(contenedorSuperior, BorderLayout.NORTH);
	}

	public void panelCentral()
	{

		matrizBotones=new JButton[tamanio][tamanio];

		contenedorCentral=new JPanel();
		contenedorCentral.setLayout(new GridLayout(tamanio, tamanio));

		for(int i=0; i<tamanio; i++)
		{
			for(int j=0; j<tamanio; j++)
			{   Puesto miPuesto=miVentanaPrincipal.getMiParqueadero().getMisPuestos()[i][j];
				int tipo=miPuesto.getTipo();
				matrizBotones[i][j]=new JButton(""+tipo);
				this.matrizBotones[i][j].addActionListener(this);

				contenedorCentral.add(matrizBotones[i][j]);
			}
		}

		this.add(contenedorCentral, BorderLayout.CENTER);
	}

	public void panelInferior()
	{
		contenedorInferior=new JPanel();

		agregarVehiculo=new JButton("Agregar Vehiculo");
		consulta=new JButton("Consulta");
		consulta.addActionListener(this);

		this.agregarVehiculo.addActionListener(this);

		contenedorInferior.add(agregarVehiculo);
		contenedorInferior.add(consulta);

		this.add(contenedorInferior, BorderLayout.SOUTH);

	}

	public void pintarCasillas()
	{
		for(int s=0; s<tamanio; s++)
		{
			for(int m=0; m<tamanio; m++)
			{
				if(miVentanaPrincipal.verificarDisponibilidadPuesto(s, m)==false)
				{
					matrizBotones[s][m].setBackground(Color.red);
					matrizBotones[s][m].setText("Ocupado");
				}
			}
		}
	}

	public void despintarCasilas(int i, int j)
	{
		String mostrar=Integer.toString(miVentanaPrincipal.getMiParqueadero().getMisPuestos()[i][j].getTipo());

		matrizBotones[i][j].setBackground(Color.white);
		matrizBotones[i][j].setText(mostrar);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0; i<tamanio; i++)
		{
			for(int j=0; j<tamanio; j++)
			{
				if(e.getSource()==matrizBotones[i][j])
				{
					if(miVentanaPrincipal.verificarDisponibilidadPuesto(i, j)==true)
					{
						JOptionPane.showMessageDialog(null, "Campo vacio");
					}
					else
					{
					    this.setVisible(false);
					    miVentanaEliminar=new EliminarVehiculo(i, j, this, miVentanaPrincipal);
					    miVentanaEliminar.setBounds(0, 0, 300, 300);
					    miVentanaEliminar.setLocationRelativeTo(null);
					    miVentanaEliminar.setVisible(true);
					}
				}
			}
		}

		if(e.getSource()==agregarVehiculo)
		{
			this.setVisible(false);
			miVentanaAgregar=new AgregarVehiculo(this, miVentanaPrincipal);
			miVentanaAgregar.setBounds(0, 0, 500, 250);
			miVentanaAgregar.setLocationRelativeTo(null);
			miVentanaAgregar.setVisible(true);
		}
		if(e.getSource()==consulta)
		{
		String[] nombreColumnas = {"Placa", "Tipo", "Modelo", "Propietario"};
		ArrayList<Vehiculo> lista= miVentanaPrincipal.listarVehiculoModeloSup2016();

		String data[][]=miVentanaPrincipal.toStringVehiculos(lista);

		VentanaJTable1 miVentanaJTable1= new VentanaJTable1(data, nombreColumnas);
		miVentanaJTable1.setVisible(true);
		miVentanaJTable1.setSize(600, 400);
		}
	}
}
