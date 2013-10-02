package hottiehotspots.rest.service;

import hottiehotspots.rest.model.GEORegions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GEORegionsServiceImpl implements GEORegionsService{
	 private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    private EntityManager getEntityManager() {
        return em;
    }
    
    public GEORegions findById(int id)
    {    	
    	Query query = getEntityManager().createQuery("from GEORegions where RegionID = :regionId");
    	query.setParameter("regionId", id);
    	List list = query.getResultList();
    	
    	if(list.size() > 1)
    		System.out.println("Problem... more than one entry returned from GEORegionsServiceImpl.findById");
    	else if(list.size() == 1)
    		return (GEORegions) list.get(0);
    	
    	return null;
    }
    
    public GEORegions find(GEORegions model)
    {    	
    	Session session = null;
    	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    	session = sessionFactory.openSession();
    	    
    	Criteria criteria = session.createCriteria(GEORegions.class);
    	
    	if (model.getRegionId() != null) {
    			criteria.add(Restrictions.eq("regionId", model.getRegionId()));
    	}   
    	if(model.getCountryId() != null) {
			criteria.add(Restrictions.eq("countryId", model.getCountryId()));
    	}
    	if(model.getRegion() != null) {
			criteria.add(Restrictions.eq("region", model.getRegion()));
    	}
    	if(model.getCode() != null) {
			criteria.add(Restrictions.eq("code", model.getCode()));
    	}
    	if(model.getADM1Code() != null) {
			criteria.add(Restrictions.eq("ADM1Code", model.getADM1Code()));
    	}
   
    	List list = criteria.list();
    	
    	if(list.size() > 1)
    		System.out.println("Problem... more than one entry returned from GEORegionsServiceImpl.find");
    	else if(list.size() == 1)
    		return (GEORegions) list.get(0);
    	
    	return null;
    }
    
    public List findRegions(GEORegions model)
    {    	
    	Session session = null;
    	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    	session = sessionFactory.openSession();
    	    
    	Criteria criteria = session.createCriteria(GEORegions.class);
    	
    	if (model.getRegionId() != null) {
    			criteria.add(Restrictions.eq("regionId", model.getRegionId()));
    	}   
    	if(model.getCountryId() != null) {
			criteria.add(Restrictions.eq("countryId", model.getCountryId()));
    	}
    	if(model.getRegion() != null) {
			criteria.add(Restrictions.eq("region", model.getRegion()));
    	}
    	if(model.getCode() != null) {
			criteria.add(Restrictions.eq("code", model.getCode()));
    	}
    	if(model.getADM1Code() != null) {
			criteria.add(Restrictions.eq("ADM1Code", model.getADM1Code()));
    	}
   
    	List list = criteria.list();
    	
    	return list;
   
    }
    

    
}
