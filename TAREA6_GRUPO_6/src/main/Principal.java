package main;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
			
		try 
		{
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.setVisible(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
