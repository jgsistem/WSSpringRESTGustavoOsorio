package pe.edu.galaxy.training.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.ws.rest.entity.Autos;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;
import pe.edu.galaxy.training.ws.rest.repository.inf.AutoRepository;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.AutoService;

@Service("autoService")
public class AutoServiceImpl implements AutoService {


	@Autowired
	private AutoRepository autorepository;

	public AutoServiceImpl() {
		
	}
	
	@Override
	public boolean insert(Autos auto) throws ServiceException {
		try {
			return this.getAutorepository().insert(auto);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean update(Autos auto) throws ServiceException {
		try {
			return this.getAutorepository().update(auto);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean delete(Autos auto) throws ServiceException {
		try {
			return this.getAutorepository().delete(auto);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Autos findByObject(Autos prmObject) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Autos> findByLikeObject(Autos auto) throws ServiceException {
		try {
			return this.getAutorepository().findByLikeObject(auto);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Autos findByRUC(String ruc) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Autos> findByLikeRZ(String rz) throws ServiceException {
		try {
			return this.getAutorepository().findByLikeRZ(rz);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}
	
	public AutoRepository getAutorepository() {
		return autorepository;
	}


	public void setAutorepository(AutoRepository autorepository) {
		this.autorepository = autorepository;
	}


}
