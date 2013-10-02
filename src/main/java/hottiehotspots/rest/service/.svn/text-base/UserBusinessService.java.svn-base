package hottiehotspots.rest.service;


import hottiehotspots.dao.UserDAO;
import hottiehotspots.rest.model.User;

import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userBS")
public class UserBusinessService{
    
	@Autowired
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO dao) {
		this.userDAO = dao;
	}

	public List<User> findAll() {
		return getUserDAO().findAll();
	}
	
	public User find(int id) {
		return getUserDAO().find(id);
	}
	
	public User create(User newUser) {
		
		if(isValid(newUser))
			getUserDAO().save(newUser);
		
		return newUser;
	}
	
    public Boolean isValid(User user)
    {
    	EmailValidator ev = EmailValidator.getInstance();
    	
    	if(isIncomplete(user))
    		return false;
    	if(!ev.isValid(user.getEmail()))
    		return false;
    	if(isDuplicate(user))
    		return false;
    	
    	return true;
    }
    
    public boolean isIncomplete(User user) {
    	if(user.getUserName() == null || user.getUserName().trim().equals(""))
    		return true;
    	else if(user.getEmail() == null || user.getEmail().trim().equals(""))
    		return true;
    	
    	return false;
    }
    
	public Boolean isDuplicate(User user) {
		
		if(getUserDAO().find(user) != null)
			return true;
		else
			return false;
	}
	
}
