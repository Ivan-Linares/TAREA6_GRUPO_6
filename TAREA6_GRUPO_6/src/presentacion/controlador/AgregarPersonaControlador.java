package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.IPersona;
import entidad.Persona;
import presentacion.vista.PanelAgregarPersona;

public class AgregarPersonaControlador implements ActionListener{

	private PanelAgregarPersona panel;
	private IPersona iPer;
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	public AgregarPersonaControlador(PanelAgregarPersona panelAgregar) {
		
		this.panel.getBtnAceptar().addActionListener(a->agregarPersona(a));
	}
	
	private void agregarPersona(ActionEvent a) {
		String nombre = this.panel.getTxtNombre().getText();
		String apellido = this.panel.getTxtApellido().getText();
		String dni = this.panel.getTxtDNI().getText();
		Persona nuevaPersona = new Persona(nombre, apellido, dni);
		
		boolean estado = iPer.Insertar(nuevaPersona);
		
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
