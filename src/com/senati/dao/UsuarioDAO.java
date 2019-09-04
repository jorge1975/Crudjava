package com.senati.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.senati.conexion.Conexion;
import com.senati.model.Usuario;

public class UsuarioDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public boolean guardar(Usuario usuario) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO USUARIOS(nombre_usu,clave) VALUES(?,?)";
			statement=connection.prepareStatement(sql);
			
			
			statement.setString(1, usuario.getNombre_usu());
			statement.setString(2, usuario.getClave());
			
			estadoOperacion=statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return estadoOperacion;
	}
	
	public boolean editar(Usuario usuario) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE USUARIOS set nombre_usu=?,clave=? WHERE idusuario=?)";
			statement=connection.prepareStatement(sql);
			
			
			statement.setString(1, usuario.getNombre_usu());
			statement.setString(2, usuario.getClave());
			statement.setInt(3, usuario.getIdusuario());
						
			estadoOperacion=statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return estadoOperacion;
	}
	
	public boolean eliminar(int idUsuario) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM USUARIOS WHERE idusuario=?";
			statement=connection.prepareStatement(sql);
					
			statement.setInt(1, idUsuario);
						
			estadoOperacion=statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return estadoOperacion;
	}
	
	public List<Usuario> obtenerUsuario() throws SQLException {
		ResultSet resultSet=null;
		List<Usuario> listaUsuarios=new ArrayList<>();
		
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "SELECT * FROM USUARIOS";
			statement=connection.prepareStatement(sql);
			resultSet = statement.executeQuery();					
			
			while (resultSet.next()) {
				Usuario u=new Usuario();
				u.setIdusuario(resultSet.getInt(1));
				u.setNombre_usu(resultSet.getString(2));
				u.setClave(resultSet.getString(3));
				listaUsuarios.add(u);
			}
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	public Usuario obtenerUsuario(int idUsuario) throws SQLException {
		ResultSet resultSet=null;
		Usuario u=new Usuario();
		
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "SELECT * FROM USUARIOS WHERE idusuario=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idUsuario);
			
			resultSet = statement.executeQuery();					
			
			if (resultSet.next()) {
				
				u.setIdusuario(resultSet.getInt(0));
				u.setNombre_usu(resultSet.getString(1));
				u.setClave(resultSet.getString(2));
				
			}
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return u;
		
	}
	
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
