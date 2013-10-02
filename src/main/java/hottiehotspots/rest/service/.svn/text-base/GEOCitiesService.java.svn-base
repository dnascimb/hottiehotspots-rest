package hottiehotspots.rest.service;

import hottiehotspots.rest.model.GEOCities;

import java.util.List;

import javax.persistence.EntityManager;

public interface GEOCitiesService {

	public void setEntityManager(EntityManager em);
    public GEOCities findById(int id);
    public GEOCities find(GEOCities model);
    public List findCities(GEOCities model);
    public List findCitiesStartingWith(String city);
    public List findCitiesStartingWith(String city, String region);
    public List findCitiesStartingWith(String city, String region, String country);
    
}
