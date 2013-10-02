package hottiehotspots.rest.service;

import hottiehotspots.rest.model.GEOCities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GEOCitiesServiceImpl implements GEOCitiesService{
	 private EntityManager em;
	 private static final Log log = LogFactory.getLog(GEOCitiesServiceImpl.class);

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    private EntityManager getEntityManager() {
        return em;
    }
    
    public GEOCities findById(int id)
    {    	
    	Query query = getEntityManager().createQuery("from GEOCities where CityId = :cityId");
    	query.setParameter("cityId", id);
    	List list = query.getResultList();
    	
    	if(list.size() > 1)
    		log.debug("Problem... more than one entry returned from GEOCitiesServiceImpl.findById");
    	else if(list.size() == 1)
    		return (GEOCities) list.get(0);
    	
    	return null;
    }
    
    public GEOCities find(GEOCities model)
    {    	
    	Session session = null;
    	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    	session = sessionFactory.openSession();
    	    
    	Criteria criteria = session.createCriteria(GEOCities.class);
    	
    	if (model.getCityId() != null) {
    			criteria.add(Restrictions.eq("cityId", model.getCityId()));
    	}   
    	if(model.getCountryId() != null) {
			criteria.add(Restrictions.eq("countryId", model.getCountryId()));
    	}
    	if(model.getRegionId() != null) {
			criteria.add(Restrictions.eq("regionId", model.getRegionId()));
    	}
    	if(model.getCity() != null) {
			criteria.add(Restrictions.eq("city", model.getCity()));
    	}
    	if(model.getCode() != null) {
			criteria.add(Restrictions.eq("code", model.getCode()));
    	}
    	if(model.getCounty() != null) {
			criteria.add(Restrictions.eq("county", model.getCounty()));
    	}
    	if(model.getDmaId() != null) {
			criteria.add(Restrictions.eq("dmaId", model.getDmaId()));
    	}
    	if(model.getLatitude() != null) {
			criteria.add(Restrictions.eq("latitude", model.getLatitude()));
    	}
    	if(model.getLongitude() != null) {
			criteria.add(Restrictions.eq("longitude", model.getLongitude()));
    	}
    	if(model.getTimezone() != null) {
			criteria.add(Restrictions.eq("timezone", model.getTimezone()));
    	}
   
    	List list = criteria.list();
    	
    	if(list.size() > 1)
    	{
    		log.debug("\n------ Criteria");
    		log.debug("City: '" + model.getCity() + "'");
    		log.debug("Region: '" + model.getRegionId() + "'");
    		log.debug("Country: '" + model.getCountryId() + "'");
    		log.debug("-----------------------------------------\n");
    		
    		for(int i = 0; i<list.size();i++){
	    		
    			log.debug("Found: " + ((GEOCities)list.get(i)).getCity() + ", " 
	    							+ ((GEOCities)list.get(i)).getRegionId().getRegion() + ", "
	    							+ ((GEOCities)list.get(i)).getCountryId().getCountry());
    		}
    	} else if(list.size() == 1) {
    		return (GEOCities) list.get(0);
    	}
    	return null;
    }
    
    public List findCities(GEOCities model)
    {    	
    	Session session = null;
    	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    	session = sessionFactory.openSession();
    	    
    	Criteria criteria = session.createCriteria(GEOCities.class);
    	
    	if (model.getCityId() != null) {
    			criteria.add(Restrictions.eq("cityId", model.getCityId()));
    	}   
    	if(model.getCountryId() != null) {
			criteria.add(Restrictions.eq("countryId", model.getCountryId()));
    	}
    	if(model.getRegionId() != null) {
			criteria.add(Restrictions.eq("regionId", model.getRegionId()));
    	}
    	if(model.getCity() != null) {
			criteria.add(Restrictions.eq("city", model.getCity()));
    	}
    	if(model.getCode() != null) {
			criteria.add(Restrictions.eq("code", model.getCode()));
    	}
    	if(model.getCounty() != null) {
			criteria.add(Restrictions.eq("county", model.getCounty()));
    	}
    	if(model.getDmaId() != null) {
			criteria.add(Restrictions.eq("dmaId", model.getDmaId()));
    	}
    	if(model.getLatitude() != null) {
			criteria.add(Restrictions.eq("latitude", model.getLatitude()));
    	}
    	if(model.getLongitude() != null) {
			criteria.add(Restrictions.eq("longitude", model.getLongitude()));
    	}
    	if(model.getTimezone() != null) {
			criteria.add(Restrictions.eq("timezone", model.getTimezone()));
    	}
   
    	List list = criteria.list();
    	
    	return list;

    }
    
    public List findCitiesStartingWith(String city)
    {    	
    	List list = null;
    	
    	if(city == null || city.trim().equals(""))
    		return list;
    	
    	try
    	{
    		Query query = getEntityManager().createQuery("from GEOCities where city LIKE '" + city + "%' " + 
	    							"order by city, regionId.region, countryId.country");
	    	list = query.getResultList();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		list = null;
    	}
    	
    	return list;
    }
    
    public List findCitiesStartingWith(String city, String region)
    {    	
    	List list = null;
    	
    	if(city == null || city.trim().equals("")
    			|| region == null || region.trim().equals(""))
    		return list;
    	
    	try
    	{
    		Query query = getEntityManager().createQuery("from GEOCities where city LIKE '" + city + "%' " +
    								" and regionId.region like '" + region + "%' " +
	    							"order by city, regionId.region, countryId.country");
	    	list = query.getResultList();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		list = null;
    	}
    	
    	return list;
    }
    
    public List findCitiesStartingWith(String city, String region, String country)
    {    	
    	List list = null;
    	
    	if(city == null || city.trim().equals("")
    			|| region == null || region.trim().equals("")
    			|| country == null || country.trim().equals(""))
    		return list;
    	
    	try
    	{
    		Query query = getEntityManager().createQuery("from GEOCities where city LIKE '" + city + "%' " +
    								" and regionId.region like '" + region + "%' " +
    								" and countryId.country like '" + country + "%' " +
	    							"order by city, regionId.region, countryId.country");
	    	list = query.getResultList();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		list = null;
    	}
    	
    	return list;
    }
}
