package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.RespuestaDTO;

public class Server extends Thread {
	private Socket socket;
	private Socket socketR;
	private ServerSocket server;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private int port;
	private String direccCliente;

	public Server(int port) {
		super();
		this.socket = null;
		this.socketR = null;
		this.server = null;
		this.in = null;
		this.out = null;
		this.port = port;
		this.direccCliente = direccCliente;
	}

	RespuestaDTO res;

	public void run() {
		try {
			this.server = new ServerSocket(this.port);
			System.out.println("Server started");
			System.out.println("Waiting for a client ...");
			this.socket = server.accept();
			System.out.println("Client accepted");
			this.in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			res = (RespuestaDTO) in.readObject();
			

		} catch (IOException i) {
			System.out.println(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void usuarioOpcion(int num) {
		
	}
}
