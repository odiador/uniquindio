package co.edu.uniquindio.p3.multithreading;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerApp {

	public static void startServer() {
		try (ServerSocket serverSocket = new ServerSocket(10)) {
			AtomicInteger contIDs = new AtomicInteger();
			System.out.println(prefix() + "Servidor iniciado [" + serverSocket.toString() + "]");
			while (true) {
				final int id = contIDs.get();
				final Socket socket = serverSocket.accept();
				new Thread(connectionThread(id, socket)).start();
				contIDs.incrementAndGet();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Runnable connectionThread(int id, Socket socket) {
		return () -> {
			try {
				System.out.println(prefix() + "Cliente conectado <#" + id + ">");
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				while (true) {
					Object objeto = input.readObject();
					System.out.println(prefix() + "<#" + id + "> " + objeto);
				}
			} catch (IOException | ClassNotFoundException e) {
				try {
					System.err.println(prefix() + "Closed #" + id);
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
	}

	public static String prefix() {
		return '[' + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")) + "] ";
	}
}
