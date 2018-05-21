package com.iesvirgendelcarmen.mvc;

import java.awt.EventQueue;

import com.iesvirgendelcarmen.mvc.controlador.ControladorFicheros;
import com.iesvirgendelcarmen.mvc.vista.VistaFicheros;

public class MainFicheros {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaFicheros vista = new VistaFicheros();
					new ControladorFicheros(vista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
