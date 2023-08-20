package co.edu.unbosque.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {
	private static Scanner lector;
	private static File archivo;
	private static PrintWriter escritor; // clase para escribir en el archivo

	public FileHandler() {

	}

	public static String abrirArchivoTexto(String nombre_archivo) {
		archivo = new File("src/co/edu/unbosque/model/persistence/" + nombre_archivo);

		StringBuilder contenido = new StringBuilder();
		try {
			lector = new Scanner(archivo);
			while (lector.hasNext()) {
				contenido.append(lector.nextLine() + "\n");
			}

			lector.close();
		} catch (FileNotFoundException e) {
			System.err.println("ERROR DE APERTURA: Error al abrir el archivo.");
		} catch (IOException ex) {
			System.err.println("NO SE CUENTA CON LOS SUFICIENTES PERMISOS");
			ex.printStackTrace();

		}
		return contenido.toString();
	}

	public static void escribirArchivoTexto(String nombre_archivo, String texto_a_escribir) {
		archivo = new File("src/co/edu/unbosque/model/persistence/" + nombre_archivo);
		try {
			escritor = new PrintWriter(archivo);
			escritor.println(texto_a_escribir);
			escritor.close();
		} catch (FileNotFoundException e) {
			System.err.println("ERROR DE LECTURA: Archivo no encontrado.");
			e.printStackTrace();
			try {
				archivo.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			System.out.println("error de escritura: revise permisos");

			e.printStackTrace();
		}
	}

	public static void borrarTextoArchivo(String nombre_archivo) {
		archivo = new File("src/co/edu/unbosque/model/persistence/" + nombre_archivo);
		try {
			escritor = new PrintWriter(archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
