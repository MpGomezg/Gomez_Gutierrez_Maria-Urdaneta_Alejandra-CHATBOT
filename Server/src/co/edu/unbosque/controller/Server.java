package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import co.edu.unbosque.model.RespuestaDAO;
import co.edu.unbosque.model.RespuestaDTO;

public class Server extends Thread {
	private Socket socket;
	private Socket socketR;
	private ServerSocket server;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private int port;
	private String direccCliente;
	private RespuestaDAO rdao;

	public Server(int port) {
		super();
		this.socket = null;
		this.socketR = null;
		this.server = null;
		this.in = null;
		this.out = null;
		this.port = port;
		this.direccCliente = direccCliente;
		rdao = new RespuestaDAO();
	}

	RespuestaDTO res;

	public void run() {

		try {
			this.server = new ServerSocket(this.port);
			System.out.println("Server started");
			System.out.println("Waiting for a client ...");
			this.socket = server.accept();
			System.out.println("Client accepted");

			// q se mande el archivo txt

			this.out = new ObjectOutputStream(socket.getOutputStream());
			String menu = (String) rdao.cargar1("menu.txt");
			this.out.writeObject(menu);
			this.out.flush();

//-->>
			this.in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			
			
			for(int i=0; i<100;i++) {
			String num = in.readUTF();
			// this.socketR = new Socket(this.socket.getInetAddress(), this.port + 1);
//			this.out = new ObjectOutputStream(socketR.getOutputStream());
			System.out.println("El numero fue.." + num);
			String resp="";
			switch (num) {
			case "1": 
				resp = rdao.cargar2("sentimiento.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "2": 
				resp = rdao.cargar1("dato.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "2.1": 
				resp = rdao.cargar2("datoanimal.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "2.2": 
				resp = rdao.cargar2("datohistor.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "2.3": 
				resp = rdao.cargar2("datocult.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "2.4": 
				resp = rdao.cargar2("datojueg.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "3": 
				resp = rdao.cargar1("chiste.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "3.1": 
				resp = rdao.cargar2("chistemalo.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "3.2": 
				resp = rdao.cargar2("chistenegro.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "3.3": 
				resp = rdao.cargar2("chistedoble.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "4": 
				resp = rdao.cargar1("cancion.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "4.1": 
				resp = rdao.cargar2("pop.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "4.2": 
				resp = rdao.cargar2("rock.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "4.3": 
				resp = rdao.cargar2("clasica.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "5": 
				resp = rdao.cargar1("serie.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "5.1": 
				resp = rdao.cargar2("policiaca.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "5.2": 
				resp = rdao.cargar2("horror.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "5.3": 
				resp = rdao.cargar2("misterio.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "5.4": 
				resp = rdao.cargar2("romantica.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;
			case "5.5": 
				resp = rdao.cargar2("accion.txt");
				this.out.writeUTF(resp);
				this.out.flush();
				break;

			
			}
			}
			this.socket.close();
			this.out.close();
			this.in.close();
			return;
		} catch (IOException i) {
			System.out.println(i);
		}	}
	

	public void usuarioOpcion(int num) {
		try {
			if (socketR.isClosed()) {
				System.out.println("Connection is closed.");
				return;
			}

		} catch (Exception e) {
			// TODO: handle exception
    }
	}
}
