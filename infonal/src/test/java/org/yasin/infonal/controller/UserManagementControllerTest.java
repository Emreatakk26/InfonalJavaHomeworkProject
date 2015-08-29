package test.java.org.yasin.infonal.controller;

import main.java.org.yasin.infonal.controller.UserManagementController;
import main.java.org.yasin.infonal.data.UsersDAO;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import junit.framework.TestCase;

public class UserManagementControllerTest extends TestCase {

	@Mock
	private UsersDAO usersDAO;
	@Mock
	private Model model;

	@Before
	protected void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	public void testGetAllUsers() {
		// when(model.addAttribute(null)).then
	}

	UserManagementController controller = new UserManagementController();
	// (Error !)controller.setUsersDao(usersDAO);
}
