package clase8;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MatrizCine extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton matrizBotones[][];

	public MatrizCine(String mensaje) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(13,16,5,5));
		panel.setBounds(10, 79, 966, 474);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel(mensaje);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(425, 10, 210, 59);
		contentPane.add(lblNewLabel);

		matrizBotones = new JButton[13][16];
		for (int i = 0; i<13;i++) {
			for (int j = 0; j<16;j++) {
				char caracter = (char) ('A'+i);
				matrizBotones[i][j] = new JButton(caracter+""+(j+1));
				matrizBotones[i][j].addActionListener(this);
				panel.add(matrizBotones[i][j]);

			}
		}
	}
	public void actionPerformed(ActionEvent e) {

	}
}
