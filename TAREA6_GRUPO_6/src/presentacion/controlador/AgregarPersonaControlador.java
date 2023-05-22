package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.IPersona;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersona;

public class AgregarPersonaControlador implements ActionListener{

	private PanelAgregarPersona panel;
	private PersonaNegocio PersonaNegocio;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	public AgregarPersonaControlador(PanelAgregarPersona panelAgregar, PersonaNegocio personaNegocio) {
		this.panel = panelAgregar;
		this.panel.getBtnAceptar().addActionListener(a->agregarPersona(a));
		this.txtNombre = this.panel.getTxtNombre();
		this.txtApellido = this.panel.getTxtApellido();
		this.txtDni = this.panel.getTxtDNI();
		
		agregarKeyListener();

		this.PersonaNegocio = personaNegocio;
	}
	
	private void agregarPersona(ActionEvent a) {
		String nombre = this.panel.getTxtNombre().getText();
		String apellido = this.panel.getTxtApellido().getText();
		String dni = this.panel.getTxtDNI().getText();
		Persona nuevaPersona = new Persona(dni, nombre, apellido);
		
		boolean existente = false;
		
		for (Persona x : PersonaNegocio.Listar()) {
			if(x.getDNI().equals(dni)){
				existente = true;
				JOptionPane.showMessageDialog(null, "DNI ya existente");
			}
		}
		if(existente==false) {
			boolean estado = PersonaNegocio.Insertar(nuevaPersona);
			if(estado==true)
			{
				JOptionPane.showMessageDialog(null, "Persona agregada con exito");
				this.panel.getTxtNombre().setText("");
				this.panel.getTxtApellido().setText("");
				this.panel.getTxtDNI().setText("");
			}
			else
				JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos");
			
		}
		
		
		
	}
	
	private void agregarKeyListener() {
		txtNombre.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				verificarSoloLetras(e, txtNombre);
				
			}

        });
		
		txtApellido.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				verificarSoloLetras(e, txtApellido);
				
			}

        });
		
		txtDni.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				verificarSoloNumeros(e, txtDni);
				
			}

        });
	}
	
	private void verificarSoloLetras(KeyEvent e, JTextField txt) {
		if(!Character.isLetter(e.getKeyChar())) {
			int lengthString = txt.getText().length();
			String txtString = "";
			
			if(lengthString > 0) 
				txtString = txt.getText().substring(0, lengthString-1);
			
			txt.setText(txtString);
		}
	}
	
	private void verificarSoloNumeros(KeyEvent e, JTextField txt) {
		if(Character.isLetter(e.getKeyChar())) {
			int lengthString = txt.getText().length();
			String txtString = "";
			
			if(lengthString > 0) 
				txtString = txt.getText().substring(0, lengthString-1);
			
			txt.setText(txtString);
		}
	}
	
}
