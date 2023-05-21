package presentacion.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class PanelModificarPersona  extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JList listPersonas;
	private JButton btnModificar;
	
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}
	public PanelModificarPersona() {
		setBackground(SystemColor.controlHighlight);
		setLayout(null);
		
		JLabel lblSeleccionarUsuarioA = new JLabel("Seleccionar persona a modificar");
		lblSeleccionarUsuarioA.setBounds(25, 11, 201, 14);
		add(lblSeleccionarUsuarioA);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(25, 36, 274, 105);
		add(panel);
		
		listPersonas = new JList();
		panel.add(listPersonas);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(25, 152, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(121, 152, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setEnabled(false);
		txtDNI.setEditable(false);
		txtDNI.setBounds(213, 152, 86, 20);
		add(txtDNI);
		txtDNI.setColumns(10);
		
	    btnModificar = new JButton("Modificar");
		btnModificar.setBounds(121, 183, 89, 23);
		add(btnModificar);
		
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JTextField getTxtApellido() {
		return txtApellido;
	}
	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}
	public JTextField getTxtDNI() {
		return txtDNI;
	}
	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}
	public JList getListPersonas() {
		return listPersonas;
	}
	public void setListPersonas(JList listPersonas) {
		this.listPersonas = listPersonas;
	}
}
