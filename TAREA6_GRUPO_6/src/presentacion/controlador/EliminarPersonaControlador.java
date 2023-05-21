package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminarPersona;

public class EliminarPersonaControlador implements ActionListener {

	private JList listaPersonas;
	private DefaultListModel listaModel;
	private PersonaNegocio personaNegocio;
	private PanelEliminarPersona panelEliminarPersona;
	private JButton btnEliminarPersona;
	int personaSelectedIndex;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public EliminarPersonaControlador(PanelEliminarPersona panelEliminarPersona, PersonaNegocio personaNegocio) {
		this.panelEliminarPersona = panelEliminarPersona;
		this.personaNegocio = personaNegocio;
		this.listaPersonas = panelEliminarPersona.getListaPersonas();
		
		agregarBtnEliminarPersona();
		setDefaultListModel();
	}
	
	public void agregarBtnEliminarPersona() {
		this.btnEliminarPersona = panelEliminarPersona.getBtnEliminarPersona();
		this.btnEliminarPersona.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(personaSelectedIndex != -1) {
					Persona personaEliminar = (Persona) listaPersonas.getSelectedValue();
					boolean eliminado = personaNegocio.Eliminar(personaEliminar);
					
					if(eliminado)
					{
						listaModel.remove(personaSelectedIndex);
						JOptionPane.showMessageDialog(null, "Se eliminó la persona exitosamente!");
					}
					else {
						JOptionPane.showMessageDialog(null, "No se ha podido eliminar la persona seleccionada!");
					}
				}
			}
			
		});
	}
	public void setDefaultListModel()
	{
		List<Persona> listaPersonasNegocio =  personaNegocio.Listar();
		this.listaModel = new DefaultListModel();
		
		for(Persona persona : listaPersonasNegocio)
			listaModel.addElement(persona);

		setListSelectionEvent(listaPersonas);
		
		this.listaPersonas.setModel(listaModel);
		
	}
	
	public void setListSelectionEvent(JList lista) {
		lista.addListSelectionListener(new ListSelectionListener () {
			public void valueChanged(ListSelectionEvent e) {
				personaSelectedIndex = lista.getSelectedIndex();			
			}
		});
	}

}
