package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelListarPersonas;

public class ListarPersonaControlador implements ActionListener {
	PanelListarPersonas panelListarPersonas;
	PersonaNegocio personaNegocio;
	private ArrayList<Persona> personasEnTabla;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public ListarPersonaControlador(PanelListarPersonas panelListarPersonas, PersonaNegocio personaNegocio) {
		this.panelListarPersonas = panelListarPersonas;
		this.personaNegocio = personaNegocio;			
		refrescarTabla();
	}

	private void refrescarTabla()
	{
		this.personasEnTabla = (ArrayList<Persona>) personaNegocio.Listar();		
		this.panelListarPersonas.llenarTabla(this.personasEnTabla);
	}
}
