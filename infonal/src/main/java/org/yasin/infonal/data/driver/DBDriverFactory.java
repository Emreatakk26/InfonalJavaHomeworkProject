package main.java.org.yasin.infonal.data.driver;

import main.java.org.yasin.infonal.data.driver.mongodb.MongoDBDriver;
import main.java.org.yasin.infonal.data.driver.mongodb.MysqlDBDriver;
import main.java.org.yasin.infonal.data.exception.ConnectionStringSyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DBDriverFactory {
	private static final Logger logger = LoggerFactory
			.getLogger(DBDriverFactory.class);

	private String connectionString;

	private DBDriver dbDriver = null;

	@Autowired
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	//Test Kodu yazýlacak olan method.
	public DBDriver getDbDriver() throws ConnectionStringSyntaxException{
		if(connectionString == null)
			throw new ConnectionStringSyntaxException("Connection string can not be null");
		
		if(dbDriver != null)
		return dbDriver;
		
		// Prefix Defined Section
		if(connectionString.startsWith("mongodb")){
			logger.debug("---! connectionString starts with mongodb and creating a new instance of mongo db driver");
			dbDriver = new MongoDBDriver(connectionString);
		}else if (connectionString.startsWith("mysql")) {
			logger.debug("---! connectionString starts with mongodb and creating a new instance of mysql db driver");
		}
		
		return dbDriver;
	}

}
