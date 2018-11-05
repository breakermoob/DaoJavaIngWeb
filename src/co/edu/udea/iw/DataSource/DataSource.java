package co.edu.udea.iw.DataSource;
/**
 * @author Leon Dario Arango Amaya 
 * leon.arango@udea.edu.co
 *  Conexion a la DB 
 *  */

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import co.edu.udea.iw.Exception.Exceptions;

import co.edu.udea.iw.Exception.Exceptions;

public class DataSource {
	
	//JDBC driver name and database URL
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/LabIngWeb";
			
	//DataBase User and Pass 
	final String USUARIO = "root";
	final String CONTRASEÑA = "root";
	
	//connection to DataBase start in null for a singleton
	private static DataSource dbIsntance;
    private static Connection con = null;
    
    public DataSource() {
        // public constructor //
      }
	
    //Apply Singleton
	public static DataSource getInstance(){
	    if(con==null){
	        dbIsntance= new DataSource();
	    }
	    return dbIsntance;
	    }
	
	public Connection getConnection() throws Exceptions{
		
		if(con == null) {
			try {
				Class.forName(JDBC_DRIVER);
				con =DriverManager.getConnection(DB_URL,USUARIO,CONTRASEÑA);
			
			}catch(ClassNotFoundException e){ //Exception of forName and SQL
				throw new Exceptions("No ha encontrado el Driver de la DB ",e);//Error Control
			}catch(SQLException e){
				throw new Exceptions("Ha ocurrido un error tratando de conectarse a la DB ",e);//Error Control
			}
		} 
		return con;
	}
	
	public void closeConnection() throws Exceptions{
		try { // Method for close the connection 
			if(con != null) {
				if(!con.isClosed()) {
					con.close();
				}
			}
		}catch(SQLException e) {
			throw new Exceptions("Ha ocurrido un error tratando de desconectarse a la DB ",e);//Error Control
		}
		
	}
	
}
