package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.*;

public class AgregarVehiculo extends JFrame implements ActionListener
{
	private JPanel panelSuperior,panelCentral,panelInferior;
	private JButton btnAgregar,btnCancelar;
	private JLabel lblModelo,lblPlaca,lblAgregarVehiculo, lblNombre, lblTelefono;
	private JComboBox<String> tipoVehiculo;
	private JTextField tfModelo,tfPlaca, tfNombre, tfTelefono;
	private GenerarMatrizBotones miVentanaBotones;
	private VentanaPrincipal miVentanaPrincipal;


	public AgregarVehiculo(GenerarMatrizBotones miVentanaBotones, VentanaPrincipal miVentanaPrincipal)
    {
	    this.miVentanaBotones=miVentanaBotones;
	    this.miVentanaPrincipal=miVentanaPrincipal;
		iniciarPanelSuperior();
		iniciarPanelCentral();
		iniciarPanelInferior();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }


	public void iniciarPanelSuperior()
	{

		panelSuperior=new JPanel();
		panelSuperior.setLayout(new FlowLayout());

		lblAgregarVehiculo=new JLabel("Agregar Vehiculo");
		panelSuperior.add(lblAgregarVehiculo);

		getContentPane().add(panelSuperior,BorderLayout.NORTH);

	}

	public void iniciarPanelCentral()
	{
		panelCentral=new JPanel();
		panelCentral.setLayout(new GridLayout(5, 2));

		lblNombre=new JLabel("Nombre del propietario:");
		lblTelefono=new JLabel("Telefono del propietario:");
		tfNombre=new JTextField();
		tfTelefono=new JTextField();

		lblModelo=new JLabel("Modelo:");
		lblPlaca=new JLabel("Placa:");

		tipoVehiculo=new JComboBox<String>();
				tipoVehiculo.addItem("Carro");
		        tipoVehiculo.addItem("Moto");

		tfModelo=new JTextField();
		tfPlaca=new JTextField();

		panelCentral.add(lblNombre);
		panelCentral.add(tfNombre);
		panelCentral.add(lblTelefono);
		panelCentral.add(tfTelefono);
		panelCentral.add(lblModelo);
		panelCentral.add(tfModelo);
		panelCentral.add(lblPlaca);
		panelCentral.add(tfPlaca);

		panelCentral.add(tipoVehiculo);

		getContentPane().add(panelCentral,BorderLayout.CENTER);
	}

	public void iniciarPanelInferior()
	{
		panelInferior=new JPanel();
		panelInferior.setLayout(new FlowLayout());

		btnAgregar=new JButton("Agregar");
		this.btnAgregar.addActionListener(this);
		btnCancelar=new JButton("Cancelar");
		this.btnCancelar.addActionListener(this);

		panelInferior.add(btnAgregar);
		panelInferior.add(btnCancelar);

		getContentPane().add(panelInferior,BorderLayout.SOUTH);

	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnAgregar)
		{
			this.setVisible(false);
			int tipo=0;
			if(tipoVehiculo.getSelectedItem().toString().equals("Carro"))
			{
			   //miVehiculo=new Vehiculo(tfModelo.getText(), tfPlaca.getText(), new Propietario(tfNombre.getText(), tfTelefono.getText()));
			   tipo=0;
		    }

			if(tipoVehiculo.getSelectedItem().toString().equals("Moto"))
			{
				//miVehiculo=new Moto(tfModelo.getText(), tfPlaca.getText(), new Propietario(tfNombre.getText(), tfTelefono.getText()));
				tipo=1;
			}

			Vehiculo miVehiculo=new Vehiculo(Integer.parseInt(tfModelo.getText()), tfPlaca.getText(), new Propietario(tfNombre.getText(), tfTelefono.getText()),tipo);

			miVentanaPrincipal.agregarVehiculo(miVehiculo);
		    miVentanaBotones.pintarCasillas();
		    miVentanaBotones.setVisible(true);

		}

		if(e.getSource()==btnCancelar)
		{
			this.setVisible(false);

			miVentanaBotones.setVisible(true);
		}
	}



}
