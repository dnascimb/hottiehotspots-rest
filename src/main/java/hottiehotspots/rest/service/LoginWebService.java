package hottiehotspots.rest.service;

import hottiehotspots.rest.model.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
 * The Login service, provides services for authenticating user credentials
 */
@Service("loginWS")
@Path("/login")
public class LoginWebService {

	@Autowired
	private LoginBusinessService _loginBS;
	
    private static final Log log = LogFactory.getLog(LoginWebService.class);
    
    public LoginWebService() {
    	
    }
	
	/**
	 * Validate the credentials of a user.
	 * @param username The username we are validating
	 * @param password The password we are validating
	 * @return Success: Status 200 - User object that matches <br/>
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
    public Response login(@QueryParam("username") String username, @QueryParam("password") String password) {
    	ResponseBuilder responseBuilder = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
    	
    	User result = _loginBS.validateCredentials(username, password);
    	
    	if(result != null && result.getId() != null)
        	responseBuilder = Response.status(Response.Status.OK).entity(result);
    	else
    		responseBuilder = Response.status(Response.Status.UNAUTHORIZED);
    	
    	return responseBuilder.build();
    }
}
