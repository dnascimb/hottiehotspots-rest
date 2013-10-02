package hottiehotspots.rest.service;

import hottiehotspots.dao.LocationDAO;
import hottiehotspots.rest.model.Location;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("locationWS")
@Path("/hotspots")
public class LocationWebService {
	
	@Autowired
	private LocationBusinessService _locationBS;
	@Autowired
	private LocationDAO _dao;
	
    private static final Log log = LogFactory.getLog(LocationWebService.class);

    public LocationWebService() {

    }

    
    @GET
    @Path("/")
    @Produces("application/json")
    public List<Location> findAllJSON() {
    	return get_Dao().findAll();
    }
    
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Location findJSON(@PathParam("id")int id) {
        return get_Dao().find(id);
    }
        
    private LocationDAO get_Dao() {
        return _dao;
    }
    
    public void set_Dao(LocationDAO dao) {
    	this._dao = dao;
    }
    
    @POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createHotspot(Location newLocation) {
    	ResponseBuilder responseBuilder = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
		
    	try
    	{
    		if(_locationBS.isValid(newLocation))
    		{
    			_locationBS.cleanUp(newLocation);    		
    			_locationBS.save(newLocation);
    			responseBuilder = Response.status(Response.Status.CREATED);
    		}
    	} catch (Exception e) {
    		log.warn("Error message: " + e.getMessage());
			log.warn("Stack Trace - " + ExceptionUtils.getStackTrace(e));
    	}
    	
    	return responseBuilder.build();
    }
    
	public LocationBusinessService getLocationBS() {
		return _locationBS;
	}
	public void setLocationBS(LocationBusinessService locationBS) {
		this._locationBS = locationBS;
	}
}
