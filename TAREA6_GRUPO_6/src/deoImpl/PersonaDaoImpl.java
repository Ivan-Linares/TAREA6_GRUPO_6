package deoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.IPersona;
import entidad.Persona;

public class PersonaDaoImpl implements IPersona{

	private static final String insertar = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String modificar = "UPDATE personas SET Nombre=?,Apellido=? where Dni=?";
	private static final String eliminar = "DELETE FROM personas WHERE dni = ?";
	private static final String listar = "SELECT * FROM personas";
	
	@Override
	public boolean Insertar(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean InsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insertar);
			statement.setString(1, persona.getDNI());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				InsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return InsertExitoso;
	}

	@Override
	public boolean Modificar(Persona modificarPersona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modificarExitoso = false;
		try
		{
			statement = conexion.prepareStatement(modificar);
			statement.setString(1, modificarPersona.getNombre());
			statement.setString(2, modificarPersona.getApellido());
			statement.setString(3, modificarPersona.getDNI());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				modificarExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return modificarExitoso;
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
