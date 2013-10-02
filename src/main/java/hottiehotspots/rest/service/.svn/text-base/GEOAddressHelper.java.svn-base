package hottiehotspots.rest.service;

import hottiehotspots.rest.model.GEOCities;
import hottiehotspots.rest.model.GEOCountries;
import hottiehotspots.rest.model.GEORegions;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;


public class GEOAddressHelper {

	GEOCitiesService cityService;
	GEORegionsService regionService;
	GEOCountriesService countryService;
	private static final Log  log = LogFactory.getLog(GEOAddressHelper.class);
	
	public GEOAddressHelper(ApplicationContext appContext) {
		this.cityService = (GEOCitiesService)appContext.getBean("geoCitiesService");
		this.regionService = (GEORegionsService)appContext.getBean("geoRegionsService");
		this.countryService = (GEOCountriesService)appContext.getBean("geoCountriesService");
	}
	
	public GEOAddressHelper(GEOCitiesService cityService, GEORegionsService regionService, GEOCountriesService countryService)
	{
		this.cityService = cityService;
		this.regionService = regionService;
		this.countryService = countryService;
	}
	
    public List getListofCities(String city) {
    	
    	List returnList = new ArrayList();
    	
    	try {
	    	if(city != null && city.length() > 0) {
	            
	        	if(city.indexOf(",") == -1) {
	        		//only city entered
		            
	        		List<GEOCities> cities = cityService.findCitiesStartingWith(city);
		            
		            return cities;
	        	}
	        	else
	        	{
	        		//see if we have to search regions and countries
	        		String first = "";
	        		String second = "";
	        		String third = "";
	        		
	        		String[] result = city.split(",");
	        	    
	        		first = result[0];
	        		
	        		if(result.length > 1)
	        			second = result[1].trim();
	        		if(result.length > 2)
	        			third = result[2].trim();
	        		
	        		if(!(third.equals("")) && !(second.equals("")))
	        		{
	        			//search for city,region,country combo
	        			
	        			List<GEOCities> cities = cityService.findCitiesStartingWith(first, second, third);
			            
	        			return cities;
	        		}
	        		else if(!(second.equals("")))
	        	    {
	        	    	// search for city, region combo
	        	    	
	        	    	List<GEOCities> cities = cityService.findCitiesStartingWith(first, second);
			            
	        	    	return cities;
	        	    }
	        	}
	        }
    	} catch(Exception e) {
    		log.error("Problem while attempting .getListofCities() : \n" + e);
    		return returnList;
    	}
    	
    	return returnList;
    }
    
    public GEOCities getExactCity(String city) {
    	
    	try {
	    	if(city != null && city.length() > 0) {
	            
	        	if(city.indexOf(",") == -1) {
	        		//only city entered
		            
	        		GEOCities theCity = new GEOCities();
	        		theCity.setCity(city);
	        		
	        		GEOCities cities = cityService.find(theCity);
		            
		            return cities;
	        	}
	        	else
	        	{
	        		//see if we have to search regions and countries
	        		String first = "";
	        		String second = "";
	        		String third = "";
	        		
	        		String[] result = city.split(",");
	        	    
	        		first = result[0];
	        		
	        		if(result.length > 1)
	        			second = result[1].trim();
	        		if(result.length > 2)
	        			third = result[2].trim();
	        		
	        		if(!(third.equals("")) || !(second.equals("")))
	        		{
	        			//search for city,region,country combo
	        			GEOCities theCity = new GEOCities();
	        			GEORegions theRegion = new GEORegions();
	        			GEOCountries theCountry = new GEOCountries();

	        			theCity.setCity(first);
	        			theRegion.setRegion(second);
	        			theCountry.setCountry(third);
	        			
	        			// see if we can get lucky and there is only one city by the name entered
	        			GEOCities cities = cityService.find(theCity);
	        			if(cities != null) {
	        				// sweet - only one city in the database by that name
	        				return cities;
	        			}
	        			
	        			// keep looking
	        			// are we dealing with an abbreviation of the region or country?
	        			if(second.length() == 2)
	        			{
	        				GEORegions abbRegion = new GEORegions();
	        				abbRegion.setCode(second);
	        				
	        				List<GEORegions> abbRegions = regionService.findRegions(abbRegion);
	        				
	        				if(abbRegions != null)
	        				{
	        					if(abbRegions.size() > 1)
	        					{
	        						//more than on region with that abbreviation so lets narrow it down
	        						for(GEORegions aRegion: abbRegions) {
		        						 //try to find a match with each region
		        						 theCity.setRegionId(aRegion);
		        						 
		        						 cities = cityService.find(theCity);
		        						 if(cities != null)
		        							 return cities;
		        					 }
	        						
	        						//still no match, we tried
	        						return null;
	        					} else {
	        						theRegion.setRegion((abbRegions.get(0)).getRegion());
	        					}
	        				} else {
	        					// couldn't find region
	        					return null;
	        				}
	        			}
	        			// lets keep looking
	        			GEORegions region = regionService.find(theRegion);
	        			if(region == null)
	        			{
	        				//ok, still no luck, but that could mean there is more than one of those regions in the world
	        				List<GEORegions> geoRegions = regionService.findRegions(theRegion);
	        				if(geoRegions != null && geoRegions.size() > 0)
	        				{
	        					 for(GEORegions aRegion: geoRegions) {
	        						 //try to find a match with each region
	        						 theCity.setRegionId(aRegion);
	        						 
	        						 cities = cityService.find(theCity);
	        						 if(cities != null)
	        							 return cities;
	        					 }
	        					 
	        					 // wow, still haven't found it, lets try country if they filled it in
	        					 if(!third.equals("")) {
	        						GEOCountries country = countryService.find(theCountry);
	     	        				if(country == null)
	     	        				{
	     	        					//no luck
	     	        					return null;
	     	        				} else {
	     	        					//the country exists, lets see if we have a match
	     	        					theCity.setCountryId(country);
	     	        					cities = cityService.find(theCity);
	     	        					if(cities == null) {
	     	        						//no luck
	     	        						return null;
	     	        					} else {
	     	        						return cities;
	     	        					}
	     	        				} 
	        					 } else {
	        						 return null;
	        					 }
	        				}
	        				
	        				
	        				
	        			} else {
	        				// lets see if we have a match
	        				theCity.setRegionId(region);
	        				cities = cityService.find(theCity);
	        				return cities;
	        					
	        			}
	        			
	        		}
	        		
	        	}
	        }
    	} catch(Exception e) {
    		log.error("Problem while attempting .getExactCity() : \n" + e);
    		return null;
    	}
    	return null;
    }
    
    public void setGEOCitiesService(GEOCitiesService service) {
        this.cityService = service;
    }
    
}
