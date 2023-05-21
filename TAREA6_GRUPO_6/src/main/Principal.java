package main;
import presentacion.vista.VentanaPrincipal;
import presentacion.controlador.*;

public class Principal {

	public static void main(String[] args) {
			
		try 
		{
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.setVisible(true);
			
			VentanaPrincipalControlador controladorVentana = new VentanaPrincipalControlador(ventanaPrincipal);
			controladorVentana.inicializar();		
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
