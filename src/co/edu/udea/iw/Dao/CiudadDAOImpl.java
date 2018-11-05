package co.edu.udea.iw.Dao;
/**
 * @author Leon Dario Arango Amaya 
 * leon.arango@udea.edu.co
 *  Implement Dao Interface
 *  */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.DataSource.DataSource;
import co.edu.udea.iw.Dto.Ciudad;
import co.edu.udea.iw.Exception.Exceptions;

public class CiudadDAOImpl extends DataSource implements CiudadDAO {
	
	private Connection con = null;

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private int codigoCiudad = 0;
	private String ciudadName = null;
	private String codigoArea = null;
	public String sentenciaSQL = null;  
	
	@Override
	public void insertar(Ciudad ciudad) throws Exceptions {
		try {
			
		//Get connection
		con = DataSource.getInstance().getConnection();
		
		//Get Dates for Insert
		codigoCiudad = ciudad.getCodigo();
		ciudadName = ciudad.getNombre();
		codigoArea = ciudad.getCodigoArea();
		
		//Prepare the query
		sentenciaSQL = "INSERT INTO ciudades(codigo,nombre,codigoArea) VALUES('"+codigoCiudad+"','"+ciudadName+"','"+codigoArea+"')";
		con.prepareStatement(sentenciaSQL);
		ps.executeUpdate();
		
		}catch(SQLException e){
			throw new Exceptions("Ha ocurrido un error al insertar en la DB  ", e);//Error Control
		}finally {
			this.closeConnection();//Close the connection DB
		}
		
	}
	@Override
	public void actualizar(Ciudad ciudad) throws Exceptions {
		try {
			
			//Get connection
			con = DataSource.getInstance().getConnection();
			
			//Get Dates for Insert
			codigoCiudad = ciudad.getCodigo();
			ciudadName = ciudad.getNombre();
			codigoArea = ciudad.getCodigoArea();
			
			//Prepare the query
			sentenciaSQL = "UPDATE ciudades set codigo="+codigoCiudad+" nombre="+ciudadName+", CodigoArea="+codigoArea+" where codigo ="+codigoCiudad;
			con.prepareStatement(sentenciaSQL);
			ps.executeUpdate();
			
			}catch(SQLException e){
				throw new Exceptions("Ha ocurrido un error al actualizar en la DB  ", e);//Error Control
			}finally {
				this.closeConnection();//Close the connection DB
			}
		
	}
	@Override
	public void eliminar(Ciudad ciudad) throws Exceptions {
		
		try {
			
			//Get connection
			con = DataSource.getInstance().getConnection();
			
			//Get Dates for Insert
			codigoCiudad = ciudad.getCodigo();
			ciudadName = ciudad.getNombre();
			codigoArea = ciudad.getCodigoArea();
			
			//Prepare the query
			sentenciaSQL = "DELETE FROM ciudades where codigo ="+codigoCiudad;
			con.prepareStatement(sentenciaSQL);
			ps.executeUpdate();
			
			}catch(SQLException e){
				throw new Exceptions("Ha ocurrido un error al borrar en la DB  ", e);//Error Control
			}finally {
				this.closeConnection();//Close the connection DB
			}			
		
	}
	@Override
	public List<Ciudad> Obtener() throws Exceptions {
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Ciudad> ciudades = new ArrayList<Ciudad>(); 
		DataSource ds = new DataSource();  
		
		try{
			con = ds.getConnection(); 
			ps = con.prepareStatement("SELECT * FROM Ciudades");
			rs = ps.executeQuery();
			while(rs.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getInt("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudades.add(ciudad);
			}
		}catch(SQLException e){
			throw new Exceptions("Ha ocurrido un error en la lista ", e);
			
		}finally {
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e) {
				throw new Exceptions(" ", e);

			}
		}
		
		return ciudades;
	}
	
}
