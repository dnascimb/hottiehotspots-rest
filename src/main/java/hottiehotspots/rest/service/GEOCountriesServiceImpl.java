package hottiehotspots.rest.service;

import hottiehotspots.rest.model.GEOCountries;

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
public class GEOCountriesServiceImpl implements GEOCountriesService{
	 private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    private EntityManager getEntityManager() {
        return em;
    }
    
    public GEOCountries findById(int id)
    {    	
    	Query query = getEntityManager().createQuery("from GEOCountries where CountryId = :CountryId");
    	query.setParameter("CountryId", id);
    	List list = query.getResultList();
    	
    	if(list.size() > 1)
    		System.out.println("Problem... more than one entry returned from GEOCountriesServiceImpl.findById");
    	else if(list.size() == 1)
    		return (GEOCountries) list.get(0);
    	
    	return null;
    }
    
    public GEOCountries find(GEOCountries country)
    {    	
    	Session session = null;
    	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    	session = sessionFactory.openSession();
    	    
    	Criteria criteria = session.createCriteria(GEOCountries.class);
    	
    	if (country.getCountryId() != null) {
    			criteria.add(Restrictions.eq("countryId", country.getCountryId()));
    	}   
    	if(country.getCountry() != null) {
			criteria.add(Restrictions.eq("country", country.getCountry()));
    	}
    	if(country.getFIPS104() != null) {
			criteria.add(Restrictions.eq("FIPS104", country.getFIPS104()));
    	}
    	if(country.getISO2() != null) {
			criteria.add(Restrictions.eq("ISO2", country.getISO2()));
    	}
    	if(country.getISO3() != null) {
			criteria.add(Restrictions.eq("ISO3", country.getISO3()));
    	}
    	if(country.getISON() != null) {
			criteria.add(Restrictions.eq("ISON", country.getISON()));
    	}
    	if(country.getCapital() != null) {
			criteria.add(Restrictions.eq("capital", country.getCapital()));
    	}
    	if(country.getComment() != null) {
			criteria.add(Restrictions.eq("comment", country.getComment()));
    	}
    	if(country.getCurrency() != null) {
			criteria.add(Restrictions.eq("currency", country.getCurrency()));
    	}
    	if(country.getCurrencyCode() != null) {
			criteria.add(Restrictions.eq("currencyCode", country.getCurrencyCode()));
    	}
    	if(country.getInternet() != null) {
			criteria.add(Restrictions.eq("internet", country.getInternet()));
    	}
    	if(country.getMapReference() != null) {
			criteria.add(Restrictions.eq("mapReference", country.getMapReference()));
    	}
    	if(country.getNationalityPlural() != null) {
			criteria.add(Restrictions.eq("nationalityPlural", country.getNationalityPlural()));
    	}
    	if(country.getNationalitySingular() != null) {
			criteria.add(Restrictions.eq("nationalitySingular", country.getNationalitySingular()));
    	}
    	if(country.getPopulation() != null) {
			criteria.add(Restrictions.eq("population", country.getPopulation()));
    	}
    	if(country.getTitle() != null) {
			criteria.add(Restrictions.eq("title", country.getTitle()));
    	}
    	
    	List list = criteria.list();
    	
    	if(list.size() > 1)
    		System.out.println("Problem... more than one entry returned from GEOCountriesServiceImpl.find");
    	else if(list.size() == 1)
    		return (GEOCountries) list.get(0);
    	
    	return null;
    }
    
    public List findCountries(GEOCountries country)
    {    	
    	Session session = null;
    	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    	session = sessionFactory.openSession();
    	    
    	Criteria criteria = session.createCriteria(GEOCountries.class);
    	
    	if (country.getCountryId() != null) {
    			criteria.add(Restrictions.eq("countryId", country.getCountryId()));
    	}   
    	if(country.getCountry() != null) {
			criteria.add(Restrictions.eq("country", country.getCountry()));
    	}
    	if(country.getFIPS104() != null) {
			criteria.add(Restrictions.eq("FIPS104", country.getFIPS104()));
    	}
    	if(country.getISO2() != null) {
			criteria.add(Restrictions.eq("ISO2", country.getISO2()));
    	}
    	if(country.getISO3() != null) {
			criteria.add(Restrictions.eq("ISO3", country.getISO3()));
    	}
    	if(country.getISON() != null) {
			criteria.add(Restrictions.eq("ISON", country.getISON()));
    	}
    	if(country.getCapital() != null) {
			criteria.add(Restrictions.eq("capital", country.getCapital()));
    	}
    	if(country.getComment() != null) {
			criteria.add(Restrictions.eq("comment", country.getComment()));
    	}
    	if(country.getCurrency() != null) {
			criteria.add(Restrictions.eq("currency", country.getCurrency()));
    	}
    	if(country.getCurrencyCode() != null) {
			criteria.add(Restrictions.eq("currencyCode", country.getCurrencyCode()));
    	}
    	if(country.getInternet() != null) {
			criteria.add(Restrictions.eq("internet", country.getInternet()));
    	}
    	if(country.getMapReference() != null) {
			criteria.add(Restrictions.eq("mapReference", country.getMapReference()));
    	}
    	if(country.getNationalityPlural() != null) {
			criteria.add(Restrictions.eq("nationalityPlural", country.getNationalityPlural()));
    	}
    	if(country.getNationalitySingular() != null) {
			criteria.add(Restrictions.eq("nationalitySingular", country.getNationalitySingular()));
    	}
    	if(country.getPopulation() != null) {
			criteria.add(Restrictions.eq("population", country.getPopulation()));
    	}
    	if(country.getTitle() != null) {
			criteria.add(Restrictions.eq("title", country.getTitle()));
    	}
    	
    	List list = criteria.list();
    	
    	return list;
    	
    }
}
