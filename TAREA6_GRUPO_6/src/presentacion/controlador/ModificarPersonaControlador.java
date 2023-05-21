package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminarPersona;
import presentacion.vista.PanelModificarPersona;

public class ModificarPersonaControlador implements ActionListener {
	
	private JList listaPersonas;
	private DefaultListModel listaModel;
	private PersonaNegocio personaNegocio;
	private PanelModificarPersona panelModificarPersona;
	private JButton btnModificarPersona;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	int personaSelectedIndex;
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}
	
	public ModificarPersonaControlador(PanelModificarPersona panelModificarPersona, PersonaNegocio personaNegocio) {
		this.panelModificarPersona = panelModificarPersona;
		this.personaNegocio = personaNegocio;
		this.listaPersonas = panelModificarPersona.getListPersonas();
		this.txtNombre = panelModificarPersona.getTxtNombre();
		this.txtApellido = panelModificarPersona.getTxtApellido();
		this.txtDNI = panelModificarPersona.getTxtDNI();
		
		agregarBtnModificarPersona();
		setDefaultListModel();
	}
	
	public void agregarBtnModificarPersona() {
		this.btnModificarPersona = panelModificarPersona.getBtnModificar();
		this.btnModificarPersona.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(personaSelectedIndex != -1) {
					Persona personaModificar = new Persona(txtDNI.getText(), txtNombre.getText(), txtApellido.getText());

					boolean modificado = personaNegocio.Modificar(personaModificar);
					
					if(modificado)
					{
						listaModel.remove(personaSelectedIndex);
						listaModel.addElement(personaModificar);
						
						limpiarCampos();
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
				
				
				Persona personaModificar = (Persona) listaPersonas.getSelectedValue();
				if(personaModificar != null) {
					txtNombre.setText(personaModificar.getNombre());
					txtApellido.setText(personaModificar.getApellido());
					txtDNI.setText(personaModificar.getDNI());	
				}
				else {
					limpiarCampos();
				}
			}
		});
	}

	
	public void limpiarCampos() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");	
	}
}
