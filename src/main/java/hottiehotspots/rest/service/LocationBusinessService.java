package hottiehotspots.rest.service;

import hottiehotspots.dao.LocationDAO;
import hottiehotspots.dao.UserDAO;
import hottiehotspots.helper.LabelHelper;
import hottiehotspots.helper.SessionHelper;
import hottiehotspots.rest.model.Label;
import hottiehotspots.rest.model.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dnascimb
 *
 */
@Component("locationBS")
public class LocationBusinessService {

	@Autowired
	private LocationDAO locationDAO;
	
	public LocationDAO getLocationDAO() {
		return locationDAO;
	}
	public void setLocationDAO(LocationDAO dao) {
		this.locationDAO = dao;
	}
	
	public Boolean isDuplicate(Location location) {
		return getLocationDAO().isDuplicate(location);
	}
	
	public void save(Location location) throws Exception {
		getLocationDAO().save(location);
	}
    public Boolean isValid(Location theLocation)
    {
    	if(isIncomplete(theLocation))
    		return false;
    	if(isDuplicate(theLocation))
    		return false;
    	
    	return true;
    }
  
    public boolean isIncomplete(Location location) {
    	if(location.getAddress1() == null || location.getAddress1().trim().equals(""))
    		return true;
    	else if(location.getName() == null || location.getName().trim().equals(""))
    		return true;
    	else if(location.getType() == null || location.getType().trim().equals(""))
    		return true;
    	else if(location.getCity() == null || location.getCity().trim().equals(""))
    		return true;
    	else if(location.getState() == null || location.getState().trim().equals(""))
    		return true;
    	else if(location.getCountry() == null || location.getCountry().trim().equals(""))
    		return true;
    	else if(location.getHotspot().getRatings().isEmpty() && location.getHotspot().getUps() != 0 && location.getHotspot().getDowns() != 0)
    		return true;
    	else if(location.getHotspot().getOriginallyTaggedBy() == null || location.getHotspot().getOriginallyTaggedBy().trim().equals(""))
    		return true;
    	
    	return false;
    }
    
    public void cleanUp(Location location) {
    	cleanUpAddressData(location);
    	cleanUpLabelsData(location);
    }
    
    
	/**
	 * Sets address on a Hotspot to the current location defined by a user, if none is entered
	 * @param location
	 */
	private void cleanUpAddressData(Location location) {
		if(location == null) return;
		
    	if(location.getAddress1() != null && location.getAddress1().trim().equals(""))
    	{
    		//screen didn't have regional info
    		if(location.getCity() != null && location.getCity().trim().equals(""))
    		{
    			//no city info, take from referenced GEOCity
    			location.setCity(new SessionHelper("authToken").getCurrentLocation().getCity());
    		}
    		if(location.getState() != null && location.getState().trim().equals(""))
    		{
    			location.setState(new SessionHelper("authToken").getCurrentLocation().getRegionId().getRegion());
    		}
    		if(location.getCountry() != null && location.getCountry().trim().equals(""))
    		{
    			location.setCountry(new SessionHelper("authToken").getCurrentLocation().getCountryId().getCountry());
    		}
    		// don't care about postal really... not tracking by it anywhere
    		
    	}
    	
    	// associate with current location (best we have) since we can't guarantee that 
    	// - the data filled in on the address lines is correct
    	// - we have a match in the GEO database
    	location.setArea(new SessionHelper("authToken").getCurrentLocation());
	}
	
	/**
	 * Makes sure there are no duplicate labels or inconsistencies in labels string 
	 * @param location
	 * @param labels
	 */
	public void cleanUpLabelsData(Location location, String labels) {
		List<Label> theLabels = new ArrayList<Label>();		
		
		// USING StringTokenizer instead of .split because we don't want empties and have single delimiter
		StringTokenizer stTok = new StringTokenizer(labels,",");
		while(stTok.hasMoreElements()){
    		Label curLabel = new Label(((String)stTok.nextElement()).trim());
    		theLabels.add(curLabel);
    	}
		
		LabelHelper lh = new LabelHelper();
		location.setLabels(lh.replaceWithPersistedLabels(theLabels));
	
	}
	
	/**
	 * Makes sure there are no duplicate labels or inconsistencies in location.labels collection 
	 * @param location
	 * @param labels
	 */
	public void cleanUpLabelsData(Location location) {		
		LabelHelper lh = new LabelHelper();
		location.setLabels(lh.replaceWithPersistedLabels(location.getLabels()));
	
	}
	
}
