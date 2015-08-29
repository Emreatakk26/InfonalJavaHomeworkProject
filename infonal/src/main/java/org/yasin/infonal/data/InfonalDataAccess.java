package main.java.org.yasin.infonal.data;

import java.util.ArrayList;
import java.util.List;

import main.java.org.yasin.infonal.data.driver.DBDataObject;
import main.java.org.yasin.infonal.data.driver.DBDriver;
import main.java.org.yasin.infonal.data.driver.mongodb.MongoDBDriver;
import main.java.org.yasin.infonal.data.exception.DBConnectionException;
import main.java.org.yasin.infonal.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*******************************************************************************
 * Data Access for Infonal Project
 * 
 * Actually I can use spring-data-mongodb Library
 * 
 * @author Yasin
 *
 */
public class InfonalDataAccess {
	
	private static final Logger logger = LoggerFactory.getLogger(InfonalDataAccess.class);
	
	private String connectionString;
	
	private DBDriver dbDriver;
	
	public DBDriver getDbDriver(){
		return dbDriver;
	}
	
	public String getConnectionString() {
		return connectionString;
	}
	
	@Autowired
	public void setConnectionString (String connectionString){
		this.connectionString = connectionString;
		
		// we can not connect to database here because if we try to connect then Spring throwing
	    // nested exception is NullPointerException
	}
	
	public void connect () throws DBConnectionException{
		if(dbDriver == null){
			//Use factory pattern for here if time to be enough.
			logger.debug("---! Getting New Instance Of MongoDBDriver");
			dbDriver = new MongoDBDriver(connectionString);
		}
		
		if(!dbDriver.isConnected()){
			logger.debug("---! Opening a New Connection To Database");
			dbDriver.connect();
		}
	}
	
	public List<User> getUsers() throws DBConnectionException{
		connect();
		
		logger.debug("---! Getting DBDataObject List From Data Access Object");
		List<DBDataObject> dbDataObjects = dbDriver.getData();
		List<User> users = new ArrayList<>();
		
		User user = null;
		DBDataObject dbDataObject;
		for(int i = 0; i < dbDataObjects.size(); i++){
			dbDataObject = dbDataObjects.get(i);
			user = new User();
			user.setFirstname(dbDataObject.getValues().get("firstname").toString());
			user.setLastname(dbDataObject.getValues().get("lastname").toString());
			user.setId(dbDataObject.getValues().get("_id").toString());
			user.setPhone(dbDataObject.getValues().get("phone").toString());
			users.add(user);
		}
		
		return users;
	}
	
}

