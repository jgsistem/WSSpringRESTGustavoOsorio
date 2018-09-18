package pe.edu.galaxy.training.ws.rest.service.inf;

import java.util.List;

import pe.edu.galaxy.training.ws.rest.entity.Autos;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;

public interface AutoService extends  GenericService<Autos> {
	
	public Autos 	findByRUC(String ruc) throws ServiceException;
	
	public List<Autos>  findByLikeRZ(String rz) throws ServiceException;

}
