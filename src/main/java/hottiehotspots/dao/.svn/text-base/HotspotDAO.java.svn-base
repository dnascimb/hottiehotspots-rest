package hottiehotspots.dao;

import hottiehotspots.rest.model.GEOCities;
import hottiehotspots.rest.model.Hotspot;
import hottiehotspots.rest.model.HotspotRating;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("hotspotDAO")
public class HotspotDAO {
	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	private EntityManager getEntityManager() {
		return em;
	}

	public void save(Hotspot hh) {
		if (hh.getHotspotId() == null) {
			// new
			em.persist(hh);
		} else {
			// update
			em.merge(hh);
		}
	}

	public void remove(int id) {

	}

	public double calculateTemperature(Hotspot h, HotspotRating latestRating) {

		Double currentTemp = h.getCurrentRating();
		Integer numberOfRatings = h.getTimesRated();
		Double newRating = latestRating.getRating();

		// reverse the average, then add the new rating in and average again
		Double newTemp = (((currentTemp * numberOfRatings) + newRating)
				/ numberOfRatings + 1);

		/*
		 * The LONG WAY assumes latestRating has been added to the hotspot
		 * already
		 * 
		 * Iterator iter = h.getRatings().iterator(); Double sum = 0.0;
		 * 
		 * 
		 * HotspotRating rating = null;
		 * 
		 * while (iter.hasNext()) { rating = null; rating = (HotspotRating)
		 * iter.next(); sum += rating.getRating(); } newTemp =
		 * sum/h.getTimesRated();
		 */

		return newTemp;

	}

	public List findHotSpotsByCity(GEOCities area) {
		return findHotSpotsByCity(area, null);
	}

	public List findHotSpotsByCity(GEOCities area, String searchText) {
		/**
		 * get all the locations that belong to an Area and have Hotspots
		 * associated with them
		 */
		Query query;

		if (searchText != null) {

			query = getEntityManager().createQuery(
					"from Location where area.cityId = " + area.getCityId()
							+ " and hotspot != NULL"
							+ " and name LIKE :searchText").setParameter(
					"searchText", '%' + searchText + '%');

		} else {

			query = getEntityManager().createQuery(
					"from Location where area.cityId = " + area.getCityId()
							+ " and hotspot != NULL");
		}

		List list = query.getResultList();
		return list;

	}

	public List findHotSpotsByCoordinates(double latitude, double longitude) {
		return findHotSpotsByCoordinates(latitude, longitude, null);
	}

	public List findHotSpotsByCoordinates(double latitude, double longitude,
			String searchText) {
		// get all the locations that belong to an range of GPS coordinates and
		// have Hotspots associated with them
		Query query;

		if (searchText != null) {

			query = getEntityManager().createQuery(
					"from Location where latitude <= " + (latitude + 1)
							+ " and latitude >= " + (latitude - 1)
							+ " and longitude <= " + (longitude + 1)
							+ " and longitude >= " + (longitude - 1)
							+ " and hotspot != NULL"
							+ " and name LIKE :searchText").setParameter(
					"searchText", '%' + searchText + '%');
		} else {
			query = getEntityManager().createQuery(
					"from Location where latitude <= " + (latitude + 1)
							+ " and latitude >= " + (latitude - 1)
							+ " and longitude <= " + (longitude + 1)
							+ " and longitude >= " + (longitude - 1)
							+ " and hotspot != NULL");
		}
		List list = query.getResultList();

		return list;

	}

	public List findNewestHotspots(int numberToRetrieve) {
		return findNewestHotspots(numberToRetrieve, null);
	}

	public List findNewestHotspots(int numberToRetrieve, GEOCities area) {
		if (area != null)
			return findNewestHotspots(numberToRetrieve, area.getLatitude(),
					area.getLongitude());
		else
			return findNewestHotspots(numberToRetrieve, 0.0, 0.0);
	}

	public List findNewestHotspots(int numberToRetrieve, double latitude,
			double longitude) {
		Query query;
		
		if(latitude == 0.0 || longitude == 0.0)
		{
			//no location specified - use the whole data set
			query = getEntityManager().createQuery(
					"from Location where " 
							+ " hotspot != NULL"
							+ " order by createdDate desc");
		}
		else
		{
			//look in a specific geographic area for the information
			query = getEntityManager().createQuery(
					"from Location where "
							+ " and latitude <= " + (latitude + 1)
							+ " and latitude >= " + (latitude - 1)
							+ " and longitude <= " + (longitude + 1)
							+ " and longitude >= " + (longitude - 1)
							+ " and hotspot != NULL"
							+ " order by createdDate desc");
		}
		
		query.setMaxResults(numberToRetrieve);
		List results = query.getResultList();
		return results;
	}
	
	public List findTopRatedHotspots(int numberToRetrieve) {
		return findTopRatedHotspots(numberToRetrieve, null);
	}

	public List findTopRatedHotspots(int numberToRetrieve, GEOCities area) {
		if (area != null)
			return findTopRatedHotspots(numberToRetrieve, area.getLatitude(),
					area.getLongitude());
		else
			return findTopRatedHotspots(numberToRetrieve, 0.0, 0.0);
	}

	public List findTopRatedHotspots(int numberToRetrieve, double latitude,
			double longitude) {
		Query query;
		
		if(latitude == 0.0 || longitude == 0.0)
		{
			//no location specified - use the whole data set
			query = getEntityManager().createQuery(
					"from Location where " 
							+ " hotspot != NULL"
							+ " order by hotspot.currentRating desc");
		}
		else
		{
			//look in a specific geographic area for the information
			query = getEntityManager().createQuery(
					"from Location where "
							+ " and latitude <= " + (latitude + 1)
							+ " and latitude >= " + (latitude - 1)
							+ " and longitude <= " + (longitude + 1)
							+ " and longitude >= " + (longitude - 1)
							+ " and hotspot != NULL"
							+ " order by hotspot.currentRating desc");
		}
		
		query.setMaxResults(numberToRetrieve);
		List results = query.getResultList();
		return results;
	}

}
