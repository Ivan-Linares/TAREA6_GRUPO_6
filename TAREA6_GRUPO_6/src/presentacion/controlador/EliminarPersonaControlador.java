package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminarPersona;

public class EliminarPersonaControlador implements ActionListener {

	private JList listaPersonas;
	private DefaultListModel listaModel;
	private PersonaNegocio personaNegocio;
	private PanelEliminarPersona panelEliminarPersona;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public EliminarPersonaControlador(PanelEliminarPersona panelEliminarPersona, PersonaNegocio personaNegocio) {
		this.panelEliminarPersona = panelEliminarPersona;
		this.personaNegocio = personaNegocio;
		this.listaPersonas = panelEliminarPersona.getListaPersonas();
		setDefaultListModel();
	}
	
	public void setDefaultListModel()
	{
		List<Persona> listaPersonas =  personaNegocio.Listar();
		this.listaModel = new DefaultListModel();
		
		for(Persona persona : listaPersonas)
			listaModel.addElement(persona);

		this.listaPersonas.setModel(listaModel);
		
	}

}
