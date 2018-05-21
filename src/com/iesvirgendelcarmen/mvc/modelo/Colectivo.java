package com.iesvirgendelcarmen.mvc.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Colectivo {

	private List<Persona> listaPersona = new ArrayList<>();
	
	public Colectivo(String path) {
		cargarDatosFichero(path);
	}

	private void cargarDatosFichero(String path) {
		try (Scanner in = new Scanner(new File(path));){
			Sexo genero = Sexo.HOMBRE;
			in.nextLine();
			while(in.hasNextLine()) {
				//System.out.println(in.nextLine());
				String[] datos = in.nextLine().split(",");
				if(datos[2].equalsIgnoreCase("FEMALE"))
					genero = Sexo.MUJER;
				listaPersona.add(new Persona(datos[0], datos[1], genero, datos[3], datos[4]));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
		}
		
	}

	public List<Persona> getListaPersona() {
		return listaPersona;
	}

	public boolean addPersona(Persona persona) {
		return listaPersona.add(persona);
	}

	public boolean eliminarPersona(Persona persona) {
		return listaPersona.remove(persona);
	}
	
	public static void main(String[] args) {
		Colectivo c = new Colectivo("Datos/data.csv");
		System.out.println(c.getListaPersona());
	}
}
