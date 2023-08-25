package clase8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class matrizBotones extends JFrame  {
	private JButton matrizBotones[][];
	private JPanel contentPane;
	private JTextField txtPantalla;
	private JButton bArriba;
	private JButton bAbaj;
	private JButton bIzq;
	private JButton bDere;
	private JButton btnAceptar;
	private JLabel lblNewLabel_1;
	private int posI = 0;
	private int posJ = 0;
	/**
	 * Create the frame.
	 */
	public matrizBotones(int cant) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1100,708);
		setResizable(false);
		contentPane = new JPanel();
		Color bgCol = new Color(0, 0, 51);
		contentPane.setBackground(bgCol);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelArriba = new JPanel();
		panelArriba.setBounds(10,0,1065,100);
		contentPane.add(panelArriba);
		panelArriba.setLayout(null);
		panelArriba.setBackground(bgCol);

		JPanel panelAbaj = new JPanel();
		panelAbaj.setBounds(10, 520, 1065, 140);
		contentPane.add(panelAbaj);
		panelAbaj.setLayout(null);
		panelAbaj.setBackground(bgCol);

		String label = "Sala ";
		int num2 = getBounds().width;
		for(int i = 0;i<(num2/4.4194);i++) {
			label+="-";
		}
		JLabel lblNewLabel = new JLabel(label);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 10, 1059, 13);
		lblNewLabel.setBackground(new Color(255,255,255));
		lblNewLabel.setForeground(new Color(255,255,255));
		panelArriba.add(lblNewLabel);

		txtPantalla = new JTextField();
		txtPantalla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPantalla.setText("Pantalla");
		txtPantalla.setEditable(false);
		txtPantalla.setBackground(new Color(0,0,0));
		txtPantalla.setForeground(new Color(255,255,255));
		txtPantalla.setHorizontalAlignment(SwingConstants.CENTER);
		txtPantalla.setBounds(184, 41, 700, 50);
		panelArriba.add(txtPantalla);

		int col = 16;
		int cantFil = 'M'-'A'+1;
		JPanel panelMatriz = new JPanel();
		panelMatriz.setBounds(10,110,1065,400);
		panelMatriz.setLayout(new GridLayout(cantFil,col,5,5));
		panelMatriz.setBackground(bgCol);
		contentPane.add(panelMatriz);

		bIzq = new JButton("←");
		bIzq.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bIzq.setBackground(new Color(255, 255, 255));
		bIzq.setBackground(Color.BLACK);
		bIzq.setForeground(Color.WHITE);
		bIzq.setEnabled(false);
		bIzq.setBounds(449, 75, 53, 53);
		panelAbaj.add(bIzq);

		bAbaj = new JButton("↓");
		bAbaj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bAbaj.setBackground(Color.BLACK);
		bAbaj.setForeground(Color.WHITE);
		bAbaj.setBounds(512, 75, 53, 53);
		panelAbaj.add(bAbaj);

		bArriba = new JButton("↑");
		bArriba.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bArriba.setBackground(Color.BLACK);
		bArriba.setForeground(Color.WHITE);
		bArriba.setEnabled(false);
		bArriba.setBounds(512, 10, 53, 53);
		panelAbaj.add(bArriba);

		bDere = new JButton("→");
		bDere.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bDere.setBackground(Color.BLACK);
		bDere.setForeground(Color.WHITE);
		bDere.setBounds(573, 75, 53, 53);
		panelAbaj.add(bDere);

		matrizBotones = new JButton[cantFil][col];
		for(char i = 'A';i<='M';i++) {
			for(int j = 0;j<col;j++) {
				int num = i-'A';
				matrizBotones[num][j] = new JButton();
				matrizBotones[num][j].setText(i+""+(j+1));
				String mensaje = "Boton: "+i+""+(j+1);
				matrizBotones[num][j].setActionCommand(mensaje);
				matrizBotones[num][j].setEnabled(false);
				matrizBotones[num][j].setForeground(new Color(255,255,255));
				if(i<'J') {
					matrizBotones[num][j].setBackground(new Color(10,10,100));
				} else {
					matrizBotones[num][j].setBackground(new Color(30,30,150));
				}
				panelMatriz.add(matrizBotones[num][j]);
			}
		}
		for(char i = 'A';i<='M';i++) {
			for(int j = 0;j<cant;j++) {
				matrizBotones[posI][j].setBackground(new Color(100,250,100));
			}
		}
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(714, 60, 100, 30);
		panelAbaj.add(lblNewLabel_1);

		bAbaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton evento = (JButton)e.getSource();
				posI++;
				if(posI<cantFil) {
					bArriba.setEnabled(true);
					Color colorOg = obtenerColor(posI,posJ,cant,matrizBotones,true,false,false);
					for(int j = posJ;j<(posJ+cant);j++) {
						matrizBotones[posI][j].setBackground(new Color(100,250,100));
					}
					for(int j = posJ;j<(posJ+cant);j++) {
						matrizBotones[posI-1][j].setBackground(colorOg);
					}
				} else {
					posI--;
					evento.setEnabled(false);
					bArriba.setEnabled(true);
				}
				lblNewLabel_1.setText("Pos: ["+posI+","+posJ+"]");
			}
		});

		bArriba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton evento = (JButton)e.getSource();
				posI--;
				if(posI>=0) {
					bAbaj.setEnabled(true);
					Color colorOg = obtenerColor(posI,posJ,cant,matrizBotones,true,true,false);
					for(int j = posJ;j<(posJ+cant);j++) {
						matrizBotones[posI][j].setBackground(new Color(100,250,100));
					}
					for(int j = posJ;j<(posJ+cant);j++) {
						matrizBotones[posI+1][j].setBackground(colorOg);
					}
				} else {
					posI++;
					evento.setEnabled(false);
					bAbaj.setEnabled(true);

				}
				lblNewLabel_1.setText("Pos: ["+posI+","+posJ+"]");
			}
		});
		bIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton evento = (JButton)e.getSource();
				posJ--;
				if(posJ>=0) {
					bDere.setEnabled(true);
					Color colorOg = obtenerColor(posI,posJ,cant,matrizBotones,false,false,true);
					matrizBotones[posI][posJ+cant].setBackground(colorOg);
					for(int j = posJ;j<(posJ+cant);j++) {
							matrizBotones[posI][j].setBackground(new Color(100,250,100));
					}
				} else {
					posJ++;
					evento.setEnabled(false);
					bDere.setEnabled(true);
				}
				lblNewLabel_1.setText("Pos: ["+posI+","+posJ+"]");
			}
		});

		bDere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton evento = (JButton)e.getSource();
				posJ++;
				bIzq.setEnabled(true);
				if(posJ<=(col-cant)) {
					Color colorOg = obtenerColor(posI,posJ,cant,matrizBotones,false,false,false);
					matrizBotones[posI][posJ-1].setBackground(colorOg);
					for(int j = posJ;j<(posJ+cant);j++) {
							matrizBotones[posI][j].setBackground(new Color(100,250,100));
					}
				} else {
					posJ--;
					evento.setEnabled(false);
				}
				lblNewLabel_1.setText("Pos: ["+posI+","+posJ+"]");
			}
		});

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(880, 50, 150, 40);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelAbaj.add(btnAceptar);

		btnAceptar.addActionListener(new ActionListener() {
			//Aquí genera la matriz de los puestos
			public void actionPerformed(ActionEvent e) {
				String arrTxT[] = new String[cant];

				for(int i = 0;i<cant;i++) {
					arrTxT[i] = matrizBotones[posI][posJ+i].getText();
				}

			}
		});
	}
	public static Color obtenerColor(int i,int j,int cant,JButton mb[][],boolean esVertical,boolean va_a_Arriba,boolean va_a_Izq) {
		//Aquí busca el color para reemplazar al inicio
		Color col;
		if(!esVertical) {
			if(va_a_Izq) {
				if(j!=0) {
					col = mb[i][j].getBackground();
				} else {
					col = mb[i][j+cant+1].getBackground();
				}
			} else {
				if(j>1) {
					col = mb[i][j-2].getBackground();
				} else {
					col = mb[i][j+cant-1].getBackground();
				}

			}

		} else {
			if(va_a_Arriba) {
				if(j!=0) {
					col = mb[i+1][j-1].getBackground();
				} else {
					col = mb[i+1][j+cant].getBackground();
				}
			} else {
				if(j!=0) {
					col = mb[i-1][j-1].getBackground();
				} else {
					col = mb[i-1][j+cant].getBackground();
				}

			}

		}
		return col;
	}
}