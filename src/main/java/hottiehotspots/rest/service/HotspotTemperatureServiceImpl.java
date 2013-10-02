package hottiehotspots.rest.service;

import hottiehotspots.rest.model.Hotspot;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HotspotTemperatureServiceImpl implements HotspotTemperatureService{
	 private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	public double calculateTemperature(Hotspot hh, String Event) {
		double newTemperature = 0.0;
		
		//TODO calculate temperature based on events
		
		return newTemperature;
	}
    
    private EntityManager getEntityManager() {
        return em;
    }
}
