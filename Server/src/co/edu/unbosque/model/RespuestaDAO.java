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


	public String cargar1(String dir) {
		String contenido = FileHandler.abrirArchivoTexto(dir);
		return contenido;
		}
	public String cargar2(String dir) {
		List<String> sentimientos = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoTexto(dir);
		String[] lineas = contenido.split("\n");
		for(String linea : lineas) {
			sentimientos.add(linea);
		}
		int randomNum = r.nextInt(sentimientos.size());
		String sentimientoRandom = sentimientos.get(randomNum);
		return "" + sentimientoRandom;
	}	
}
