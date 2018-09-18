package pe.edu.galaxy.training.ws.rest.repository.inf;

import java.util.List;

import pe.edu.galaxy.training.ws.rest.entity.Autos;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;


public interface AutoRepository extends GenericRepository<Autos> {
	
public Autos 	findByRUC(String ruc) throws RepositoryException;
	
	public List<Autos>  findByLikeRZ(String rz) throws RepositoryException;

}
