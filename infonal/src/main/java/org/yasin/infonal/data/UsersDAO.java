package main.java.org.yasin.infonal.data;

import java.util.ArrayList;
import java.util.List;

import main.java.org.yasin.infonal.data.driver.DBDataObject;
import main.java.org.yasin.infonal.data.driver.DBDriver;
import main.java.org.yasin.infonal.data.driver.DBDriverFactory;
import main.java.org.yasin.infonal.data.exception.ConnectionStringSyntaxException;
import main.java.org.yasin.infonal.data.exception.DBConnectionException;
import main.java.org.yasin.infonal.data.exception.DBDriverProcessException;
import main.java.org.yasin.infonal.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/***************************************************************
 * Data Access Object For Users Collection Of MongoDB.
 * 
 *
 * @author Yasin
 *
 */
public class UsersDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(UsersDAO.class);

	private DBDriver dbDriver;
	private DBDriverFactory dbDriverFactory;

	private final String tableName = "users";

	@Autowired
	public void setDbDriverFactory(DBDriverFactory dbDriverFactory) {
		this.dbDriverFactory = dbDriverFactory;
	}

	public void connect() throws DBConnectionException,
			ConnectionStringSyntaxException {
		if (dbDriver == null) {
			logger.debug("---! Getting DBDriver Object From db Driver Factory");
			dbDriver = dbDriverFactory.getDbDriver();
		}

		if (!dbDriver.isConnected()) {
			logger.debug("---! Opening a New Connection To Database");
			dbDriver.connect();
		}
	}

	public List<User> getUsers() throws DBConnectionException,
			ConnectionStringSyntaxException, DBDriverProcessException {
		connect();
		logger.debug("---! Getting DBDataObject List From Data Access Object");
		List<DBDataObject> dbDataObjects = dbDriver.get(tableName);
		List<User> users = new ArrayList<>();

		User user = null;
		DBDataObject dbDataObject;
		for (int i = 0; i < dbDataObjects.size(); i++) {
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

	public List<User> findUsers(User user) {
		return null;
	}

	public void updateUser(User updatedUser) throws DBDriverProcessException {
		DBDataObject whereDataObject = new DBDataObject();
		whereDataObject.getValues().put("_id", updatedUser.getId());

		DBDataObject updateDataObject = new DBDataObject();
		updateDataObject.getValues().put("firstname",updatedUser.getFirstname());
		updateDataObject.getValues().put("lastname", updatedUser.getLastname());
		updateDataObject.getValues().put("phone", updatedUser.getPhone());

		dbDriver.where(whereDataObject);
		dbDriver.uptade(tableName, updateDataObject);
	}

	public void insertUser(User newUser) throws DBDriverProcessException {
		DBDataObject dbDataObject = new DBDataObject();
		dbDataObject.getValues().put("firstname", newUser.getFirstname());
		dbDataObject.getValues().put("lastname", newUser.getLastname());
		dbDataObject.getValues().put("phone", newUser.getPhone());

		dbDriver.insert(tableName, dbDataObject);
	}

	public void deleteUser(User user) throws DBDriverProcessException {
		DBDataObject dbDataObject = new DBDataObject();
		dbDataObject.getValues().put("_id", user.getId());

		dbDriver.delete(tableName, dbDataObject);

	}
}
