package pe.edu.galaxy.training.ws.rest.service.inf;

import java.util.List;

import pe.edu.galaxy.training.ws.rest.entity.Cliente;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;

public interface ClienteService extends GenericService<Cliente> {
	
	public Cliente 	findByRUC(String ruc) throws ServiceException;
	
	public List<Cliente>  findByLikeRZ(String rz) throws ServiceException;
}
