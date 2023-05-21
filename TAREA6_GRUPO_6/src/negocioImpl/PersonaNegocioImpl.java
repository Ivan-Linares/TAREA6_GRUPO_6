package negocioImpl;

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
			System.out.println("entroPerwsonaNegocioIMpl");
			estado= personaDao.Insertar(nuevaPersona);
		}
		
		return estado;
	}

	@Override
	public boolean Modificar(Persona modificarPersona) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Eliminar(Persona eliminarPersona) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
