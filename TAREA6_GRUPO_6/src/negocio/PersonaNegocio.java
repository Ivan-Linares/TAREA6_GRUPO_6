package negocio;

import java.util.List;
import entidad.Persona;

public interface PersonaNegocio {
	
	public boolean Insertar(Persona nuevaPersona);
	public boolean Modificar(Persona modificarPersona);
	public boolean Eliminar(Persona eliminarPersona);
	public List<Persona> Listar();
	
}
