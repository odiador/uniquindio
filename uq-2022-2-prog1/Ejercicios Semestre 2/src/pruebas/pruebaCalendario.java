package pruebas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

// Si sirve
public class pruebaCalendario extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private int diaCompra, diaCine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaCalendario frame = new pruebaCalendario();
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
	public pruebaCalendario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(33, 101, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(151, 101, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(265, 101, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		btnNewButton = new JButton("Accept");
		btnNewButton.setBounds(317, 221, 85, 21);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Get Dif");
		btnNewButton_1.setBounds(222, 221, 85, 21);
		btnNewButton_1.addActionListener(this);
		contentPane.add(btnNewButton_1);
	}

	public void actionPerformed(ActionEvent e) {
		LocalDate fechaCompra = LocalDate.now();
		diaCompra = fechaCompra.getDayOfYear();
		LocalDate fechaCine = LocalDate.of
				(Integer.parseInt(textField_2.getText()),
						Integer.parseInt(textField_1.getText()),
						Integer.parseInt(textField.getText()));
		diaCine = fechaCine.getDayOfYear();
		JOptionPane.showMessageDialog(null, "La diferencia de dias es: "+Math.abs(diaCine-diaCompra));
	}
}
