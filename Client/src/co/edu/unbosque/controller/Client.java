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

		try {
			this.socket = new Socket(this.address, this.port);
			this.in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

			String menu = (String) in.readObject();
			System.out.println("" + menu);

			System.out.print("Enter a number (1 for info from option 1): ");
			String userChoice = sc.nextLine();
			this.out = new ObjectOutputStream(socket.getOutputStream());
			// Send user's choice to the server
			this.out.writeUTF(userChoice);
			this.out.flush();
			switch (userChoice) {
			case "1": 
				
				String response = in.readUTF();
				System.out.println("Server response: " + response);
		
				
				
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + userChoice);
			}
			
			

			this.socket.close();
//            this.server = new ServerSocket(this.port+1);
//	        this.socket = server.accept(); 

			// Receive and process server's response

			this.out.close();
			this.in.close();
			

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// sends output to the socket

	}
}
