package hottiehotspots.rest.service;

import hottiehotspots.rest.model.User;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Don<br/>
 * The User service, provides functionality for dealing with Users
 */
@Service("userWS")
@Path("/users")
public class UserWebService {

	@Autowired
	private UserBusinessService userBS;
	
    private static final Log log = LogFactory.getLog(UserWebService.class);
    
    public UserWebService() {
    	
    }
	
 
	/**
	 * Create a new User
	 * @param username The username of the new User
	 * @param password The password of the new User
	 * @param email The email of the new User
	 * @return Success: Status 201 - User object of the newly created User <br/>
     *  Error: Status 401 Unauthorized 
     *  Example JSON Output: <br/>
     *  {
		    "id": 1,
		    "password": "pass",
		    "userName": "bob01",
		    "email": "bob01@bob01.com",
			...
		}
	*/
    @POST
    @Path("/")
    @Produces("application/json")
    public Response create(@QueryParam("username") String username, @QueryParam("password") String password,
    		 @QueryParam("email") String email) {
    	ResponseBuilder responseBuilder = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
    	
    	User newUser = new User();
    	newUser.setUserName(username);
    	newUser.setPassword(password);
    	newUser.setEmail(email);
    	
    	if(getUserBS().isValid(newUser)) {
    		newUser = getUserBS().create(newUser);
    	} else {
    		responseBuilder = Response.status(Response.Status.NOT_ACCEPTABLE);
    		return responseBuilder.build();
    	}
    	
    	if(newUser != null && newUser.getId() != null)
        	responseBuilder = Response.status(Response.Status.CREATED).entity(newUser);
    	else
    		responseBuilder = Response.status(Response.Status.UNAUTHORIZED);
    	
    	return responseBuilder.build();
    }
    
	/**
	 * Retrieve a list of Users
	 * @return Success: Status 200 - Collection of User object(s) <br/>
     *  Error: Status 401 Unauthorized 
     *  Example JSON Output: <br/>
     *  {
		    "id": 1,
		    "password": "pass",
		    "userName": "bob01",
		    "email": "bob01@bob01.com",
			...
		}
	*/
    @GET
    @Path("/")
    @Produces("application/json")
    public List<User> findAll() {
    	
    	return getUserBS().findAll();
    }
    
	/**
	 * Retrieve a specific User
	 * @param id The id of the User to retrieve
	 * @return Success: Status 200 - User object <br/>
     *  Error: Status 401 Unauthorized 
     *  Example JSON Output: <br/>
     *  {
		    "id": 1,
		    "password": "pass",
		    "userName": "bob01",
		    "email": "bob01@bob01.com",
			...
		}
	*/
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public User find(@PathParam("id")int id) {
        return getUserBS().find(id);
    }


	public UserBusinessService getUserBS() {
		return userBS;
	}


	public void setUserBS(UserBusinessService userBS) {
		this.userBS = userBS;
	}
}
