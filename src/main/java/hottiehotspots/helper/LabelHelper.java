package hottiehotspots.helper;

import hottiehotspots.rest.model.Label;
import hottiehotspots.rest.service.LabelService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class LabelHelper {

	@Autowired
	LabelService labelService;
	private static final Log  log = LogFactory.getLog(LabelHelper.class);

	// not used anymore?
	public LabelHelper(ApplicationContext appContext) {
		this.labelService = (LabelService)appContext.getBean("labelService");
	}
	
	public LabelHelper(LabelService labelService) {
		this.labelService = labelService;
	}
	
	public LabelHelper() {
	}
	
	/**
	 * Determines if we have existing database entries for any of the labels in the string
	 * @param list
	 * @return a list of labels
	 */
	public Set<Label> replaceWithPersistedLabels(Collection<Label> list) {
		
		Set<Label> newList = new HashSet<Label>();
		
		if(list != null && list.size() > 0)
		{
			
			Iterator iter = list.iterator();
			
			while(iter.hasNext())
			{
				Label curLabel = (Label)iter.next();
				Label result = labelService.find(curLabel);
				
				if(result != null){
					newList.add(result);
				}
				else {
					newList.add(curLabel);
				}
			}
		}
		return newList;
	}
}
