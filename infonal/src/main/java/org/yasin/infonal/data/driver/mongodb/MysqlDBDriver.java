package main.java.org.yasin.infonal.data.driver.mongodb;

import java.util.List;

import main.java.org.yasin.infonal.data.driver.DBDataObject;
import main.java.org.yasin.infonal.data.driver.DBDriver;
import main.java.org.yasin.infonal.data.exception.ConnectionStringSyntaxException;
import main.java.org.yasin.infonal.data.exception.DBConnectionException;
import main.java.org.yasin.infonal.data.exception.DBDriverProcessException;

public class MysqlDBDriver extends DBDriver{

	public MysqlDBDriver(String connectionString) {
		super(connectionString);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkConnectionStringSyntax()
			throws ConnectionStringSyntaxException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect() throws DBConnectionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select(List<String> fields) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DBDataObject> get(String tableName)
			throws DBDriverProcessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void from(String tableName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DBDataObject> get() throws DBDriverProcessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refreshDriver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void where(DBDataObject dbDataObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(String tableName, DBDataObject data)
			throws DBDriverProcessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uptade(String tableName, DBDataObject data)
			throws DBDriverProcessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String tableName, DBDataObject data)
			throws DBDriverProcessException {
		// TODO Auto-generated method stub
		
	}

	
}
