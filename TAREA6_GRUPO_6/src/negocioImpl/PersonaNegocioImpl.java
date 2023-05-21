package negocioImpl;

import java.util.ArrayList;
import java.util.List;
import entidad.Persona;
import negocio.PersonaNegocio;
import deoImpl.PersonaDaoImpl;

public class PersonaNegocioImpl implements PersonaNegocio {

	PersonaDaoImpl personaDao = new PersonaDaoImpl();
	@Override
	public boolean Insertar(Persona nuevaPersona) {
		
		boolean estado=false;
		
		if(nuevaPersona.getNombre().trim().length()>0 && nuevaPersona.getApellido().trim().length()>0 && nuevaPersona.getDNI().length() > 0)
		{
			estado= personaDao.Insertar(nuevaPersona);
		}
		
		return estado;
	}

	@Override
	public boolean Modificar(Persona modificarPersona) {
		boolean estado = false;
		estado = personaDao.Modificar(modificarPersona);
		return estado;
	}

	@Override
	public boolean Eliminar(Persona eliminarPersona) {
		boolean estado = false;
		
		estado = personaDao.Eliminar(eliminarPersona);
		
		return estado;
	}

	@Override
	public List<Persona> Listar() {
		
		List<Persona> personas = personaDao.Listar();
		
		return personas;
	}

}
