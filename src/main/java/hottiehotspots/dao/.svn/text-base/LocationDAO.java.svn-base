package hottiehotspots.dao;

import hottiehotspots.rest.model.GEOCities;
import hottiehotspots.rest.model.Label;
import hottiehotspots.rest.model.Location;
import hottiehotspots.rest.model.User;

import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("locationDAO")
public class LocationDAO {
	 private EntityManager em;
	 private static final Log log = LogFactory.getLog(LocationDAO.class);
    
    private EntityManager getEntityManager() {
        return em;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    @SuppressWarnings("unchecked")
    public List<Location> findAll() {
        Query query = getEntityManager().createQuery("select p FROM Location p");
        return query.getResultList();
    }
    
    public Location find(int id) {
        return em.find(Location.class, id);
    }
    
    public void remove(int id) {
    	Location loc = find(id);   	
    	em.remove(loc); 	
    }
    
	public void save(Location location) throws Exception {
		
		if (location.getLocationId() == null) {
            
			//stash labels until after persist
			HashSet<Label> theLabels = new HashSet<Label>();
			theLabels = (HashSet<Label>)location.getLabels();
			location.setLabels(null);
			
			// check to make it is not a duplicate entry
			if(isDuplicate(location))
				throw new Exception("duplicate");
			
			// new
            em.persist(location);
            
            location.setLabels(theLabels);
            
            em.merge(location);

        } else {
            // update
            em.merge(location);
        }
	}

/*  COMMENTED BECAUSE WE ARE MOVING AWAY FROM AREAS
 
		// associate with proper Area
		AreaService a = new AreaServiceImpl();
		Area area = new Area(location.getCountry(), location.getCounty(),
							location.getPostalCode(), location.getState(), location.getCity());
		Area foundArea = null;
		
		foundArea = a.find(area);
		
		
		// Because an Area can be used between multiple entities, we 
		// have to see if one exists and then save it.  First, we 
		// have to call persist() on the location if its new so that we have its ID
		// when we return, which calling merge() will not do
		// so...
		// 1) find appropriate Area
		// 2) if new Location, persist
		// 3) check to make sure we have the best Area on the Location
		// 4) update the Location, with Area on it
		
      if (location.getLocationId() == null) {
            // new
    	    em.persist(location);
    	    
    	    if(location.getArea() == null || location.getArea().getCityId() == null)
    	    {
    	    	// there is no associated Area on the Location, or
    	    	// there is no existing Area associated with the Location
    	    	if(foundArea != null)
    	    		location.setArea(foundArea);
    	    	else
    	    		location.setArea(new Area(location.getCountry(), location.getCounty(),
							location.getPostalCode(), location.getState(), location.getCity()));
    	    }
    	    
    	    em.merge(location);
            
        } else {
            // update
        	
        	if(foundArea != null && location.getArea() != null &&
    				!foundArea.getId().equals(location.getArea().getCityId()))
    		{
    			// we find a matching Area and its not the same 
    			// as what we already have assocatied with the location
    			location.setArea(foundArea);
    		}
            em.merge(location);
        }
	}
*/
    
    public boolean isDuplicate(Location location) {
    	boolean isDuplicate = false;
    	StringBuffer hql = new StringBuffer();
    	
    	hql.append("from Location WHERE"
		+ " address1 = '" + location.getAddress1() + "'"
		+ " AND type = '" + location.getType() + "'");
    	
    /* HAVEN'T IMPLEMENTED EVENTS YET
     * 
     */
    /*  	if(location.getType().equals("Event")){
     
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		hql.append(" AND eventDate = '" + sdf.format(location.getEventDate()) + "'");
    	}
    */	
    	if(location.getAddress2() != null && location.getAddress2().trim().length() > 0)
    		hql.append(" AND address2 = '" + location.getAddress2() + "'");
    	
    	Query query = getEntityManager().createQuery(hql.toString());
    	isDuplicate = !query.getResultList().isEmpty();
    	
    	return isDuplicate;
    }
    
    public Location find(Location location)
    {    
    	Location result = new Location();
    	
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Location> criteria = builder.createQuery(Location.class);
		Root<Location> locationRoot = criteria.from(Location.class);
		
		criteria.where(builder.equal(locationRoot.get("locationId"), location.getLocationId()),
				builder.equal(locationRoot.get("name"), location.getName()),
				builder.equal(locationRoot.get("address1"), location.getAddress1()),
				builder.equal(locationRoot.get("city"), location.getCity()),
				builder.equal(locationRoot.get("country"), location.getCountry()),
				builder.equal(locationRoot.get("type"), location.getType()));

		try {
			result = getEntityManager().createQuery(criteria).getSingleResult();
		} catch (Exception ex) {	
			log.warn(ex.getMessage());
		}
		
		return result;
    }
    
    public List findLocationsByCity(GEOCities area)
    {
    	// TODO change to fetch based on county
    	// get all the locations that belong to an Area and have Hotspots associated with them
    	Query query = getEntityManager().createQuery("from Location where area.cityId = :area_id and hotspot = NULL");
    	query.setParameter("area_id", area.getCityId());
    	List list = query.getResultList();
    	
    	return list;
    }
    
}
