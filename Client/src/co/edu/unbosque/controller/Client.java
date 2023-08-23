package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import co.edu.unbosque.model.RespuestaDTO;

public class Client extends Thread {
	private Socket socket;
	private ServerSocket server;
	private Scanner sc;
	private ObjectOutputStream out;
	private ObjectInputStream in; // Input stream from server
	private String address;
	private int port;

	public Client(String address, int port) {
		// initialize socket and input output streams
		this.socket = null;
		this.server = null;
		this.sc = new Scanner(System.in);
		this.out = null;
		this.address = address;
		this.port = port;
	}

	@Override
	public void run() {

//while (true) {
		try {
			this.socket = new Socket(this.address, this.port);
			this.in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			// -->>
			String menu = (String) in.readObject();
//			while(true) {

			System.out.println("" + menu);

			System.out.print("Enter a number (1 for info from option 1): ");
			this.out = new ObjectOutputStream(socket.getOutputStream());
			// Send user's choice to the server
			for (int i = 0; i < 20; i++) {
				String userChoice = sc.nextLine();
				this.out.writeUTF(userChoice);
				this.out.flush();
				String response = in.readUTF();
				String respuestas = "12345";
				System.out.println("Server response: " + response);
				if (respuestas.contains(userChoice) && !userChoice.equals("1")) {
					String userChoice2 = sc.nextLine();
					this.out.writeUTF(userChoice + "." + userChoice2);
					this.out.flush();
					String response2 = in.readUTF();
					System.out.println("Server response: " + response2);

				}

				this.socket.close();

				// throw new IllegalArgumentException("Unexpected value: " + userChoice);
				// this.socket.close();
				// this.out.close();
				// this.in.close();

			}

			this.socket.close();
			this.out.close();
			this.in.close();

//            this.server = new ServerSocket(this.port+1);
//	        this.socket = server.accept(); 

			// Receive and process server's response

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// sends output to the socket

	}
}
