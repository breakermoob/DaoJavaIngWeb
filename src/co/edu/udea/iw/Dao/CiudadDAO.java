package co.edu.udea.iw.Dao;

import java.util.List;

import co.edu.udea.iw.Dto.Ciudad;
import co.edu.udea.iw.Exception.Exceptions;

/**
 * @author Leon Dario Arango Amaya 
 * leon.arango@udea.edu.co
 *  interface Dao with the CRUD
 *  */

public interface CiudadDAO {
	
	public void insertar(Ciudad ciudad) throws Exceptions;//Insert dates on ciudad
	public void actualizar(Ciudad ciudad) throws Exceptions;//Update dates on ciudad
	public void eliminar(Ciudad ciudad) throws Exceptions;//Delete dates on ciudad
	public List<Ciudad> Obtener() throws Exceptions;  
}
 