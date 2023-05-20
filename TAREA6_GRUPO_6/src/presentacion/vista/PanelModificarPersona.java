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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
		
		JList list = new JList();
		panel.add(list);
		
		textField = new JTextField();
		textField.setBounds(25, 152, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 152, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(213, 152, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(121, 183, 89, 23);
		add(btnModificar);
		
	}
}
