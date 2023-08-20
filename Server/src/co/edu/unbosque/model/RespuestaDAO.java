package co.edu.unbosque.model;

import co.edu.unbosque.controller.*;
import java.util.ArrayList;

public class RespuestaDAO {
	private ArrayList<RespuestaDTO> lista;

	public RespuestaDAO() {
		lista = new ArrayList<>();
	}

	public ArrayList<RespuestaDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<RespuestaDTO> lista) {
		this.lista = lista;
	}

	//QUIERO CARGAR EL ARCHIVO DE TEXTO, PERO LA DIRECCION DEL ARCHIVO CAMBIA DEPENDIENDO
	private ArrayList<RespuestaDTO> cargar(String dir) {
		FileHandler.abrirArchivoTexto(dir);
		return lista;
	}
	
	private void pedirNum(int num) {
		switch (num) {
		case 1: {
			
		return;
		}
		case 2:
			
			return;
		case 3: 
			
			return;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + num);
		}
		
	}
}
