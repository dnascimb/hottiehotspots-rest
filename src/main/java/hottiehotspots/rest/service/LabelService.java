package hottiehotspots.rest.service;

import hottiehotspots.rest.model.Label;

import java.util.List;

import javax.persistence.EntityManager;

public interface LabelService {

	public void setEntityManager(EntityManager em);
	
    public List<Label> findAll();

    public void save(Label label);

    public void remove(int id);

    public Label find(int id);
    
    public Label find(Label model);
    
}
