package view;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;




/**
Tomado de
http://static1.1.sqspcdn.com/static/f/923743/14411722/1317390535280/jtable
*/
public class VentanaJTable1 extends JFrame {
     /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private  JTable table;
	public VentanaJTable1(Object[][] data, String[] columnNames) {
        super("Ejemplo 1");
        //array bidimencional de objetos con los datos de la tabla

        //array de String's con los t�tulos de las columnas
       //se crea la Tabla
        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        //Creamos un JscrollPane y le agregamos la JTable
        JScrollPane scrollPane = new JScrollPane(table);
        //Agregamos el JScrollPane al contenedor
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        //manejamos la salida


    }

}


