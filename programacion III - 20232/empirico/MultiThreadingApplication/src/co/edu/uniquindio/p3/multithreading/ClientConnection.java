package co.edu.uniquindio.p3.multithreading;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClientConnection {

	private Socket socket;
	private ObjectOutputStream output;

	private ClientConnection(Socket socket) throws IOException {
		this.socket = socket;
		this.output = new ObjectOutputStream(socket.getOutputStream());
	}

	private void run() {
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				String s = sc.nextLine();
				output.writeObject(s);
				if (s.equalsIgnoreCase("salir"))
					socket.close();
			}
		} catch (IOException e) {
			System.err.println(prefix() + "Error: \"" + e.getMessage() + "\"");
		}
	}

	public static void startConnection(String host, int port) {
		try {
			new ClientConnection(new Socket(host, port)).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String prefix() {
		return '[' + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")) + "] ";
	}

}
