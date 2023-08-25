package clase8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cine extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCine;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cine frame = new Cine();
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
	public Cine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCine = new JButton("Cine");
		btnCine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCine.setBounds(67, 166, 183, 44);
		btnCine.addActionListener(this);
		contentPane.add(btnCine);

		JButton btnNewButton = new JButton("C0nfiteria");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Confiteria");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(266, 166, 146, 44);
		contentPane.add(btnNewButton);

		JButton btnRegistrarCiiente = new JButton("Registrar CIiente");
		btnRegistrarCiiente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarCiiente.setBounds(67, 220, 183, 44);
		contentPane.add(btnRegistrarCiiente);

		JButton btnDarTarjetaA = new JButton("Dar tarjeta a CIiente");
		btnDarTarjetaA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDarTarjetaA.setBounds(104, 282, 146, 44);
		contentPane.add(btnDarTarjetaA);

		JButton btnRecargarTarjeta = new JButton("Recargar tarjeta");
		btnRecargarTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRecargarTarjeta.setBounds(266, 282, 146, 44);
		contentPane.add(btnRecargarTarjeta);

		JButton btnHistriai = new JButton("hist0riaI");
		btnHistriai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHistriai.setBounds(104, 336, 146, 44);
		contentPane.add(btnHistriai);

		JButton btnCnsiidads = new JButton("C0ns0Iidad0s");
		btnCnsiidads.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCnsiidads.setBounds(266, 336, 146, 44);
		contentPane.add(btnCnsiidads);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCine) {
			String mensaje = JOptionPane.showInputDialog("Escribe un mensaje");
			MatrizCine MatrizCine = new MatrizCine(mensaje);
			MatrizCine.setVisible(true);
			this.setVisible(false);
		}
	}
}
