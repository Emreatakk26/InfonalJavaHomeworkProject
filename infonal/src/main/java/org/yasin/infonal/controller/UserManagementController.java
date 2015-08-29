package main.java.org.yasin.infonal.controller;

import javax.servlet.http.HttpSession;

import main.java.org.yasin.infonal.data.UsersDAO;
import main.java.org.yasin.infonal.data.exception.ConnectionStringSyntaxException;
import main.java.org.yasin.infonal.data.exception.DBConnectionException;
import main.java.org.yasin.infonal.data.exception.DBDriverProcessException;
import main.java.org.yasin.infonal.model.ResponseJson;
import main.java.org.yasin.infonal.model.Status;
import main.java.org.yasin.infonal.model.User;
import main.java.org.yasin.infonal.model.userinput.AddUserForm;
import main.java.org.yasin.infonal.model.userinput.EditUserForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
@RequestMapping("/ajax/userManagement")
public class UserManagementController {
	private static final Logger logger = LoggerFactory
			.getLogger(UserManagementController.class);

	private UsersDAO usersDao;

	@Autowired
	public void setUsersDao(UsersDAO usersDao) {
		this.usersDao = usersDao;
	}
	// Keep Json response and data error 
	@RequestMapping(value = "/getAllUsers.do", method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		ResponseJson response = new ResponseJson();
		try {
			response.setData(usersDao.getUsers());
			response.setStatus(Status.OK);

			model.addAttribute("data", new Gson().toJson(response));
		} catch (DBConnectionException | ConnectionStringSyntaxException
				| DBDriverProcessException ex) {
			logger.error("---! Error: " + ex);

			response.setStatus(Status.ERROR);
			response.setData(ex.getLocalizedMessage());
			model.addAttribute("data", new Gson().toJson(response));
		}
		return "json";
	}
	 // Keep the captcha information from users
	 // Unidentified captcha identity response given
	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("addUserInfo") AddUserForm userInfo, Model model, HttpSession session){
		logger.debug("---! Incoming Message: " + userInfo);
		ResponseJson response = new ResponseJson();
		
		String captchaExcepted = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String captchaReceived = userInfo.getCaptcha();
		if(captchaExcepted.equals(captchaReceived)){
			try {
				logger.debug("---! Captcha Input Is Correct");
				
				//User Add
				User newUser = new User();
				newUser.setFirstname(userInfo.getFirstname());
				newUser.setLastname(userInfo.getLastname());
				newUser.setPhone(userInfo.getPhone());
				
				usersDao.insertUser(newUser);
				
				logger.debug("---! New User Added: " + new Gson().toJson(newUser));
				
				response.setData("User add operation succes");
				response.setStatus(Status.OK);
			} catch (DBDriverProcessException ex) {
				
				response.setData(ex.getLocalizedMessage());
				response.setStatus(Status.ERROR);
			}
		   }else {
			   logger.debug("---! Captcha Input Is Not Correct");
			   
			   response.setData("Captcha input is not correct");
			   response.setStatus(Status.ERROR);
		   }
		
		model.addAttribute("data", new Gson().toJson(response));
		return "json";
	}
		
	@RequestMapping(value = "/uptadeUser.do", method = RequestMethod.POST)
	public String uptadeUser(@ModelAttribute("uptadeUserInfo") AddUserForm userInfo, Model model, HttpSession session){
		ResponseJson response = new ResponseJson();
		
		// User Uptade
		try {
			User uptadeUser = new User();
			uptadeUser.setId(userInfo.getId());
			uptadeUser.setFirstname(userInfo.getFirstname());
			uptadeUser.setLastname(userInfo.getLastname());
			uptadeUser.setPhone(userInfo.getPhone());
			
			usersDao.updateUser(uptadeUser);
			
			logger.debug("---! User Updated: " + new Gson().toJson(uptadeUser));
			
			response.setData("User Updated");
			response.setStatus(Status.OK);
		} catch (DBDriverProcessException ex) {
			
			response.setData(ex.getLocalizedMessage());
			response.setStatus(Status.ERROR);
		}
		
		model.addAttribute("data", new Gson().toJson(response));
		return "json";
	}

	@RequestMapping(value = "/removeUser.do", method = RequestMethod.POST)
	public String removeUser (@ModelAttribute("deleteUserInfo") EditUserForm userInfo, Model model){
		logger.debug("---! Incoming message: " + userInfo);
		ResponseJson response = new ResponseJson();
		
		// User Deleted
		try {
			User deletedUser = new User();
			deletedUser.setId(userInfo.getId());
			
			usersDao.deleteUser(deletedUser);
			
			response.setData("User deleted");
			response.setStatus(Status.OK);
		} catch (DBDriverProcessException  ex) {
			
			response.setData(ex.getLocalizedMessage());
			response.setStatus(Status.ERROR);
		}
		
		model.addAttribute("data",  new Gson().toJson(response));
		return "json";
	}
	
}


