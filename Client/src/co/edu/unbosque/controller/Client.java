package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client extends Thread {
	private Socket socket;
	private Scanner sc;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String address;
	private int port;

	public Client(String address, int port) {
		this.socket = null;
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
			this.out = new ObjectOutputStream(socket.getOutputStream());
			
			for (int i = 0; i < 50; i++) {
				System.out.println("" + menu);
				System.out.print("Digite un numero: ");
				String userChoice = sc.nextLine();
				this.out.writeUTF(userChoice);
				this.out.flush();
				String response = in.readUTF();
				String respuestas = "12345";
				System.out.println("Server response: \n" + response + "\n");
				
				if (respuestas.contains(userChoice) && !userChoice.equals("1")) {
					String userChoice2 = sc.nextLine();
					this.out.writeUTF(userChoice + "." + userChoice2);
					this.out.flush();
					
					String response2 = in.readUTF();
					System.out.println("Server response: \n" + response2 +"\n");
					
				}
			}

			this.socket.close();
			this.out.close();
			this.in.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
