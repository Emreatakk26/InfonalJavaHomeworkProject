package test.java.org.yasin.infonal.data.driver;

import java.util.Arrays;
import java.util.List;

import main.java.org.yasin.infonal.data.driver.mongodb.MongoDBDriver;
import main.java.org.yasin.infonal.data.exception.ConnectionStringParseException;
import junit.framework.TestCase;

public class MongoDBDriverTest extends TestCase {

	public void testCheckConnectionStringSyntaxNull()
			throws IllegalArgumentException, ConnectionStringParseException {

		MongoDBDriver driver = new MongoDBDriver(null);

		try {
			driver.checkConnectionStringSyntax();
			fail("You must check connection string is null");
		} catch (IllegalArgumentException ex) {
		}
	}

	public void testCheckConnectionStringSyntax1()
			throws IllegalArgumentException, ConnectionStringParseException {

		MongoDBDriver driver = new MongoDBDriver(null);

		// You can increase examples
		List<String> connStrings = Arrays.asList("123123123", "mongo://",
				"mongodb://thrstreagrea");
		for (int i = 0; i < connStrings.size(); i++) {
			try {
				driver.setConnectionString(connStrings.get(i));
				driver.checkConnectionStringSyntax();
				fail("It must throw exception for that connection string: "
						+ connStrings.get(i));
			} catch (IllegalArgumentException ex) {
				assertTrue(ex.getLocalizedMessage().contains(
						"Conection string does not match any pattern"));
			}
		}
	}

	public void testCheckConnectionStringSyntax2()
			throws IllegalArgumentException, ConnectionStringParseException {

		MongoDBDriver driver = new MongoDBDriver(null);

		// You can increase examples
		List<String> connStrings = Arrays
				.asList("mongodb://localhost/test/testdata");
		for (int i = 0; i < connStrings.size(); i++) {
			driver.setConnectionString(connStrings.get(i));
			driver.checkConnectionStringSyntax();
		}
	}

}
