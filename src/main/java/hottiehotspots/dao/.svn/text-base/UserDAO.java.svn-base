package hottiehotspots.dao;
import hottiehotspots.rest.model.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("userDAO")
public class UserDAO {
    private EntityManager em;
    private static final Log log = LogFactory.getLog(UserDAO.class);


    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Query query = getEntityManager().createQuery("select p FROM User p");
        return query.getResultList();
    }
        
    public User find(int id) {
        return em.find(User.class, id);
    }

    public User find(User user) {
    	User returnedUser = null;
		
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> userRoot = criteria.from(User.class);
		
		criteria.where(builder.equal(userRoot.get("userName"), user.getUserName()), 
				builder.equal(userRoot.get("email"), user.getEmail()));
		
		try {
			returnedUser = getEntityManager().createQuery(criteria).getSingleResult();
		} catch (Exception ex) {	
			log.warn(ex.getMessage());
		}
		
		return returnedUser;
    }
    
    public void save(User user) {

		if (user.getId() == null) {
            // new
            em.persist(user);
        } else {
            // update
            em.merge(user);
        }
    }

    public void remove(int id) {
        User user = find(id);
        if (user != null) {
            em.remove(user);
        }
    }
    
    /**
	 * find a user in the system by the given username and password
	 * 
	 * @param username id of the user
	 * @param password password for the specified user
	 * @return User object that is empty if no matches were found or populated with the match
	 */
    @Transactional
	public User findByUserNameAndPassword(String username, String password) {
		
    	User returnedUser = new User();
		
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> userRoot = criteria.from(User.class);
		
		criteria.where(builder.equal(userRoot.get("userName"), username), 
				builder.equal(userRoot.get("password"), password));
		
		try {
			returnedUser = getEntityManager().createQuery(criteria).getSingleResult();
		} catch (Exception ex) {	
			log.warn(ex.getMessage());
		}
		
		return returnedUser;
	}

    private EntityManager getEntityManager() {
        return em;
    }
    
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }


}