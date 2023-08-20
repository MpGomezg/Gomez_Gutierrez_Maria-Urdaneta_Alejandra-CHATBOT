package co.edu.unbosque.model;

import co.edu.unbosque.controller.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RespuestaDAO {
	private ArrayList<RespuestaDTO> lista;
	Random r = new Random();

	public RespuestaDAO() {
		lista = new ArrayList<>();
	}

	public ArrayList<RespuestaDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<RespuestaDTO> lista) {
		this.lista = lista;
	}

	// QUIERO CARGAR EL ARCHIVO DE TEXTO, PERO LA DIRECCION DEL ARCHIVO CAMBIA
	// DEPENDIENDO
	private ArrayList<RespuestaDTO> cargar(String dir) {
		String contenido = FileHandler.abrirArchivoTexto(dir);
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attrs = linea.split(".");
			if (attrs.length == 2) {
				String num = attrs[0];
				String res = attrs[1];
				lista.add(new RespuestaDTO(num, res));
			}
		}
		return lista;
	}
	
	//Agarra sentimiento al azar del txt sentimientos
	
	private String sentimientoAzar() {
		List<String> sentimientos = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoTexto("sentimiento.txt");
		String[] lineas = contenido.split("\n");
		for(String linea : lineas) {
			sentimientos.add(linea);
		}
		int randomNum = r.nextInt(sentimientos.size());
		String sentimientoRandom = sentimientos.get(randomNum);
		return "" + sentimientoRandom;
	}

	private String chisteMaloAzar() {
		List<String> sentimientos = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoTexto("sentimiento.txt");
		String[] lineas = contenido.split("\n");
		for(String linea : lineas) {
			sentimientos.add(linea);
		}
		int randomNum = r.nextInt(sentimientos.size());
		String sentimientoRandom = sentimientos.get(randomNum);
		return "" + sentimientoRandom;
	}
	
	
	private void pedirNum(int num) {
		cargar("chatbot.txt");
		switch (num) {
		case 1: {
			sentimientoAzar();

			return;
		}
		case 2:
			cargar("dato.txt");

			return;
		case 3:
			cargar("chiste.txt");

			return;
			
		case 4:
			cargar("cancion.txt");

			return;
			
		case 5:
			cargar("serie.txt");

			return;

		default:
			throw new IllegalArgumentException("Unexpected value: " + num);
		}

	}
}
