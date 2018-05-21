package com.iesvirgendelcarmen.mvc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.iesvirgendelcarmen.mvc.modelo.Colectivo;
import com.iesvirgendelcarmen.mvc.modelo.Persona;
import com.iesvirgendelcarmen.mvc.vista.VistaFicheros;

public class ControladorFicheros implements ActionListener {

	private VistaFicheros vista;
	//private Modelo modelo;
	private Colectivo colectivo;
	private List<Persona> listaPersona;

	public ControladorFicheros(VistaFicheros vista) {
		colectivo = new Colectivo("Datos/data.csv");
		this.vista = vista;
		registrarComponentes();
	}


	private void registrarComponentes() {
		
		vista.getMntmAbout().addActionListener(this);
		vista.getMntmData().addActionListener(this);
		vista.getMntmExit().addActionListener(this);

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().getClass()== JMenuItem.class) {
			//System.out.println("Menu item pulsado");
			JMenuItem jMenuItem = (JMenuItem) e.getSource();
			if(jMenuItem.getText().equals("Exit"))
				System.exit(0);
			else if (jMenuItem.getText().equals("About"))
				vista.lanzarDialogo("Autor: Julio Navarro");
			
				
				
			
		}

	}



}
