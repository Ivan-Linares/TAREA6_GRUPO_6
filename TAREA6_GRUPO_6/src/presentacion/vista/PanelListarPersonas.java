package presentacion.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class PanelListarPersonas  extends JPanel {
	public PanelListarPersonas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{23, 122, 139, 120, 26, 0};
		gridBagLayout.rowHeights = new int[]{24, 24, 169, 28, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 2;
		gbc_lblApellido.gridy = 1;
		add(lblApellido, gbc_lblApellido);
		
		JLabel lblDni = new JLabel("DNI");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 3;
		gbc_lblDni.gridy = 1;
		add(lblDni, gbc_lblDni);
		
		JList listModificar = new JList();
		GridBagConstraints gbc_listModificar = new GridBagConstraints();
		gbc_listModificar.gridwidth = 3;
		gbc_listModificar.insets = new Insets(0, 0, 5, 5);
		gbc_listModificar.fill = GridBagConstraints.BOTH;
		gbc_listModificar.gridx = 1;
		gbc_listModificar.gridy = 2;
		add(listModificar, gbc_listModificar);
	}

}
