package co.edu.unbosque.model;

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

}
