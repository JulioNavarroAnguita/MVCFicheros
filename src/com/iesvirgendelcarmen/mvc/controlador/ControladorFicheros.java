package com.iesvirgendelcarmen.mvc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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
	private int contador = 0;
	private String path;

	public ControladorFicheros(VistaFicheros vista) {
		this.vista = vista;
		registrarComponentes();
		/*colectivo = new Colectivo("Datos/data.csv");
		listaPersona = colectivo.getListaPersona();
		//System.out.println(listaPersona);
		colocarFormulario(contador);
		vista.getButtonLeft().setEnabled(true);
		vista.getButtonLeft10().setEnabled(true);
		vista.getButtonRight().setEnabled(true);
		vista.getButtonRight10().setEnabled(true);*/


	}


	private void colocarFormulario(int i) {
		vista.getTextFieldName().setText(listaPersona.get(i).getNombre());
		vista.getTextFieldLastName().setText(listaPersona.get(i).getApellidos());
		vista.getTextFieldGender().setText(listaPersona.get(i).getGenero() + "");
		vista.getTextFieldLanguage().setText(listaPersona.get(i).getLenguaje());
		vista.getTextFieldRace().setText(listaPersona.get(i).getRaza());


	}


	private void registrarComponentes() {
		//botones de item
		vista.getMntmAbout().addActionListener(this);
		vista.getMntmData().addActionListener(this);
		vista.getMntmExit().addActionListener(this);
		//botones
		vista.getButtonLeft().addActionListener(this);
		vista.getButtonLeft10().addActionListener(this);
		vista.getButtonRight().addActionListener(this);
		vista.getButtonRight10().addActionListener(this);

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().getClass()== JMenuItem.class) {
			//System.out.println("Menu item pulsado");
			JMenuItem jMenuItem = (JMenuItem) e.getSource();
			if(jMenuItem.getText().equals("Exit"))
				salirAplicacion();
			else if (jMenuItem.getText().equals("About"))
				desplegarInformacion();
			else
				lanzarEleccionFichero();



		}

		//Agrupamos botones
		if(e.getSource().getClass() == JButton.class) {
			JButton jButton = (JButton)e.getSource();
			String textoBoton = jButton.getText();
			switch (textoBoton) {
			case ">":
				//System.out.println("pulsado " + textoBoton);
				contador++;
				//colocarFormulario(contador);
				break;
			case ">>":
				//System.out.println("pulsado " + textoBoton);
				contador += 10;
				//colocarFormulario(contador);
				break;
			case "<":
				//System.out.println("pulsado " + textoBoton);
				contador--;
				//colocarFormulario(contador);
				break;
			case "<<":
				//System.out.println("pulsado " + textoBoton);
				contador -= 10;
				//colocarFormulario(contador);
			default:
				break;
			}
			contador %= listaPersona.size();

			if(contador < 0) 
				contador += listaPersona.size();
			colocarFormulario(contador);

		}
	}

	private void desplegarInformacion() {
		JOptionPane jpJOptionPane = new JOptionPane();
		jpJOptionPane.showMessageDialog(vista.getFrame(), 
				"Creado por Julio Navarro Anguita", "Información autor",
				JOptionPane.INFORMATION_MESSAGE);

	}


	private void salirAplicacion() {
		System.exit(0);

	}


	private void lanzarEleccionFichero( ) {
		JFileChooser jFileChooser = new JFileChooser(".");
		int resultado = jFileChooser.showOpenDialog(vista.getFrame());
		if(resultado ==jFileChooser.APPROVE_OPTION) {
			path = jFileChooser.getSelectedFile().getPath();
			colectivo = new Colectivo(path);
			listaPersona = colectivo.getListaPersona();
			colocarFormulario(contador);
			vista.getButtonLeft().setEnabled(true);
			vista.getButtonLeft10().setEnabled(true);
			vista.getButtonRight().setEnabled(true);
			vista.getButtonRight10().setEnabled(true);
			vista.getMntmAbout().setEnabled(false);

		}


	}


}
