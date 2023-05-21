package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.IPersona;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersona;

public class AgregarPersonaControlador implements ActionListener{

	private PanelAgregarPersona panel;
	private PersonaNegocio PersonaNegocio;
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	public AgregarPersonaControlador(PanelAgregarPersona panelAgregar, PersonaNegocio personaNegocio) {
		this.panel = panelAgregar;
		this.panel.getBtnAceptar().addActionListener(a->agregarPersona(a));
		this.PersonaNegocio = personaNegocio;
	}
	
	private void agregarPersona(ActionEvent a) {
		String nombre = this.panel.getTxtNombre().getText();
		String apellido = this.panel.getTxtApellido().getText();
		String dni = this.panel.getTxtDNI().getText();
		Persona nuevaPersona = new Persona(nombre, apellido, dni);
		boolean estado = PersonaNegocio.Insertar(nuevaPersona);
		
		if(estado==true)
		{
			JOptionPane.showMessageDialog(null, "Persona agregada con exito");
			this.panel.getTxtNombre().setText("");
			this.panel.getTxtApellido().setText("");
			this.panel.getTxtDNI().setText("");
		}
		else
			JOptionPane.showMessageDialog(null, "Persona no agregada, complete todos los campos");
		
	}
	
}
