package co.edu.uniquindio.p3.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * La conexion con el servidor se hace a través de Sockets, se conecta por medio
 * de una dirección ip y de un puerto de comunicación; el cliente debe de
 * inicializar el {@link Socket} con estos datos, el Servidor inicialmente debe
 * de crear una instancia de un objeto llamado {@link ServerSocket} el cual
 * tiene como parametro el puerto de coneccion y sera encargado de aceptar la
 * informacion. Los datos entre ellos se envian mediante flujos
 * {@link ObjectInputStream} y {@link ObjectOutputStream}, donde el flujo output
 * es usado por cliente y se inicializa con el mismo flujo del socket, lo usa
 * para enviar la informacion, con un writeObject, el server la recibe con el
 * flujo input y la lee mediante el metodo readObject. <br>
 * 
 * Para aceptar multiples conexiones de forma simultanea se hace uso de hilos,
 * estos pueden ser clases que extiendan o implemente de {@link Thread} o
 * {@link Runnable} respectivamente, o incluso hilos instanciados directamente
 * dentro de la clase server. El hilo es creado luego de aceptar la conexion del
 * {@link Socket}, y se envian los parametros necesarios para ejecutar el metodo
 * del hilo (puede ser informacion que se lea dede el inputstream o se puede
 * enviar directamente el socket para dentro del metodo crear este flujo y
 * obtener los datos. Se mantiene el server escuchando conexiones mediante es
 * uso de un "ciclo infinito" (while)
 */
public class Punto02Cliente {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 10);
				Scanner sc = new Scanner(System.in);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
			int numEnviar = sc.nextInt();
			System.out.println("Numero a enviar: " + numEnviar);
			oos.writeObject(numEnviar);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
