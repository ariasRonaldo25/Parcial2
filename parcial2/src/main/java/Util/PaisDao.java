package Util;

import java.sql.SQLException;
import java.util.List;

import Modelo.Pais;



public interface PaisDao <T>{

	public void insertCarro(Pais pais) throws SQLException;
	public Pais selectCarro(T id);
	public List < Pais> selectAllCarro();
	public boolean deleteCarro(T id) throws SQLException;
	public boolean updateCarro(Pais pais) throws SQLException;
}