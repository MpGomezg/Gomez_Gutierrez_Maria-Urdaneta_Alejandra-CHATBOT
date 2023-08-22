package co.edu.unbosque.model;

import java.util.ArrayList;


import co.edu.unbosque.controller.*;

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
	public ArrayList<RespuestaDTO> cargar(String dir) {
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
	
	public String sentimientoAzar() {
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
	

	

}
