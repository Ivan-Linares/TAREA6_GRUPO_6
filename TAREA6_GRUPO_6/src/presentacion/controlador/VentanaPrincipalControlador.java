package presentacion.controlador;

import java.awt.event.ActionEvent;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import java.awt.event.ActionListener;
import presentacion.vista.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import presentacion.vista.VentanaPrincipal;

public class VentanaPrincipalControlador implements ActionListener
{
	private VentanaPrincipal ventanaPrincipal;
	private JPanel contentPane; 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public VentanaPrincipalControlador(VentanaPrincipal ventana) {
		
		this.ventanaPrincipal = ventana;
		this.contentPane = 	(JPanel) ventanaPrincipal.getContentPane();
		
		JMenuBar menuBar = this.ventanaPrincipal.getJMenuBar();
		
		JMenu menu = menuBar.getMenu(0);
		
		setearEventosAMenuItems(menu);
	}
	
	public void setearEventosAMenuItems(JMenu menu) {
		
		JMenuItem menuItemAgregarPersona = (JMenuItem)menu.getMenuComponent(0);
		menuItemAgregarPersona.addActionListener(e->abrirPanelAgregarPersona(e));
		
		JMenuItem menuItemModificarPersona = (JMenuItem)menu.getMenuComponent(1);
		menuItemModificarPersona.addActionListener(e->abrirPanelModificarPersona(e));
		
		JMenuItem menuItemEliminarPersona = (JMenuItem)menu.getMenuComponent(2);
		menuItemEliminarPersona.addActionListener(e->abrirPanelEliminarPersona(e));
		
		JMenuItem menuItemListarPersonas = (JMenuItem)menu.getMenuComponent(3);
		menuItemListarPersonas.addActionListener(e->abrirPanelListarPersonas(e));
	
	}
	
	public void abrirPanelAgregarPersona(ActionEvent e) {
		contentPane.removeAll();
		
		PanelAgregarPersona panelAgregarPersona = new PanelAgregarPersona();
		contentPane.add(panelAgregarPersona);
		contentPane.repaint();
		contentPane.revalidate();		
		
		PersonaNegocio personaNegocio = new PersonaNegocioImpl();
		AgregarPersonaControlador controladorAgregarPersona = new AgregarPersonaControlador(panelAgregarPersona, personaNegocio);
	}
	
	public void abrirPanelModificarPersona(ActionEvent e) {
		ventanaPrincipal.getContentPane().removeAll();
		PanelModificarPersona panelModificarPersona = new PanelModificarPersona();
		contentPane.add(panelModificarPersona);
		contentPane.repaint();
		contentPane.revalidate();	
		
		PersonaNegocio personaNegocio = new PersonaNegocioImpl();
		ModificarPersonaControlador modificarPersonaControlador = new ModificarPersonaControlador(panelModificarPersona, personaNegocio);
	}
	
	public void abrirPanelEliminarPersona(ActionEvent e) {
		ventanaPrincipal.getContentPane().removeAll();
		PanelEliminarPersona panelEliminarPersona = new PanelEliminarPersona();
		contentPane.add(panelEliminarPersona);
		contentPane.repaint();
		contentPane.revalidate();
		
		PersonaNegocio personaNegocio = new PersonaNegocioImpl();
		EliminarPersonaControlador eliminarPersonaControlador = new EliminarPersonaControlador(panelEliminarPersona, personaNegocio);
	}
	
	public void abrirPanelListarPersonas(ActionEvent e) {
		ventanaPrincipal.getContentPane().removeAll();
		PanelListarPersonas panelListarPersonas = new PanelListarPersonas();
		contentPane.add(panelListarPersonas);
		contentPane.repaint();
		contentPane.revalidate();
		
		PersonaNegocio personaNegocio = new PersonaNegocioImpl();
		ListarPersonaControlador listarPersonaControlador = new ListarPersonaControlador(panelListarPersonas, personaNegocio);
	}
	
	public void inicializar() {
		this.ventanaPrincipal.show();
	}
}
