package clase8;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class matriz extends JFrame {

	private JPanel contentPane;
	private JTextField columnasTxt;
	private static matrizBotones mB;

	/**
	 * Launch the application.
	 */
	private static matriz frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new matriz();
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
	public matriz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 480);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel colLBL = new JLabel("Escribe la cantidad de puestos");
		colLBL.setHorizontalAlignment(SwingConstants.CENTER);
		colLBL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		colLBL.setBounds(46, 189, 404, 38);
		contentPane.add(colLBL);

		JButton btnNewButton = new JButton("Ir a sala");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidad = Integer.parseInt(columnasTxt.getText());
				mB = new matrizBotones(cantidad);
				mB.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(273, 286, 210, 99);
		btnNewButton.setBackground(new Color(255,255,255));
		contentPane.add(btnNewButton);

		columnasTxt = new JTextField();
		columnasTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		columnasTxt.setColumns(10);
		columnasTxt.setBounds(474, 198, 96, 19);
		contentPane.add(columnasTxt);
	}

	public void boton() {
		frame.setVisible(true);
		mB.setVisible(false);
	}
}
