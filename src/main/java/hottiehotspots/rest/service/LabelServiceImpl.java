package hottiehotspots.rest.service;

import hottiehotspots.rest.model.Label;

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

public class LabelServiceImpl implements LabelService {
	
	   private EntityManager em;
	   private static final Log log = LogFactory.getLog(LabelServiceImpl.class);

	    @PersistenceContext
	    public void setEntityManager(EntityManager em) {
	        this.em = em;
	    }
	    private EntityManager getEntityManager() {
	        return em;
	    }
	    
	    public Label find(Label model) {
	    	Session session = null;
	    	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    	session = sessionFactory.openSession();
	    	    
	    	Criteria criteria = session.createCriteria(Label.class);
	    	
	    	if (model.getLabel() != null) {
	    			criteria.add(Restrictions.eq("label", model.getLabel()));
	    	}
	    	
	    	List list = criteria.list();
	    	
	    	if(list.size() > 1)
	    		log.error("Problem... more than one entry returned from LabelServiceImpl.find() when looking for:" +
	    				model.toString());
	    	else if(list.size() == 1)
	    		return (Label) list.get(0);
	    	
	    	return null;
	    }
	    
	    
	    public Label find(int id) {
	        return em.find(Label.class, id);
	    }
	 
	    @SuppressWarnings("unchecked")
	    public List<Label> findAll() {
	        Query query = getEntityManager().createQuery("select p FROM Label p");
	        return query.getResultList();
	    }
	    
	    public void save(Label model) {

			if (model.getLabelId() == null) {
	            // new
	            em.persist(model);
	        } else {
	            // update
	            em.merge(model);
	        }
	    }

	    public void remove(int id) {
	        Label label = find(id);
	        if (label != null) {
	            em.remove(label);
	        }
	    }
}
