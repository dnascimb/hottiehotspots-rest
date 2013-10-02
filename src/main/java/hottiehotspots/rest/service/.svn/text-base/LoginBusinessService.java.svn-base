package hottiehotspots.rest.service;


import hottiehotspots.dao.UserDAO;
import hottiehotspots.rest.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("loginBS")
public class LoginBusinessService{
    
	@Autowired
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO dao) {
		this.userDAO = dao;
	}

	public User validateCredentials(String username, String password) {
		return getUserDAO().findByUserNameAndPassword(username, password);
	}
}
