package pe.edu.galaxy.training.ws.rest.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.galaxy.training.ws.rest.entity.Autos;
import pe.edu.galaxy.training.ws.rest.entity.Cliente;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;
import pe.edu.galaxy.training.ws.rest.repository.inf.AutoRepository;

@Transactional
@Repository("autoRepository")
public class AutoRepositoryImpl implements AutoRepository {

	@PersistenceContext
	private EntityManager em;

	
	@Override
	public boolean insert(Autos auto) throws RepositoryException {

		boolean sw=false;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("auto.insert");			
			spq.setParameter("P_PLACA", auto.getPlaca());
			spq.setParameter("P_ANO", auto.getAno());
			spq.setParameter("P_MODELO", auto.getModelo());
			spq.setParameter("P_MARCA", auto.getMarca());
			spq.execute();
			Object id= spq.getOutputParameterValue(1);// P_ID_CLIENTE
			if (id!=null) {
				auto.setCodigo(Integer.valueOf(id.toString()));
				sw=true;
			}

		} catch (Exception e) {
			sw=false;
			throw new RepositoryException(e);
		}
		return sw;
	}

	@Override
	public boolean update(Autos auto) throws RepositoryException {
		boolean sw=false;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("auto.update");			
			spq.setParameter("P_CODIGO", auto.getCodigo());
			spq.setParameter("P_PLACA", auto.getPlaca());
			spq.setParameter("P_ANO", auto.getAno());
			spq.setParameter("P_MODELO", auto.getModelo());
			spq.setParameter("P_MARCA", auto.getMarca());
			spq.execute();
			sw=true;
		} catch (Exception e) {
			sw=false;
			throw new RepositoryException(e);
		}
		return sw;
	}


	@Override
	public boolean delete(Autos auto) throws RepositoryException {
		boolean sw=false;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("auto.delete");
			
			spq.setParameter("P_CODIGO", auto.getCodigo());
			spq.execute();
			sw=true;
		} catch (Exception e) {
			sw=false;
			throw new RepositoryException(e);
		}
		return sw;
	}

	@Override
	public Autos findByObject(Autos prmObject) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Autos> findByLikeObject(Autos auto) throws RepositoryException {
		List<Autos> lstAutos = null;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("autos.listar");
			System.out.println("StoredProcedure " + spq);	
			if (spq.execute()) {
				
				lstAutos = (List<Autos>)spq.getOutputParameterValue("P_C_CURSOR");
				System.out.println("Lista Autos " + lstAutos);
			}
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException(e);
		}
		return lstAutos;
	}

	@Override
	public Autos findByRUC(String ruc) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Autos> findByLikeRZ(String rz) throws RepositoryException {
		List<Autos> lstAutos = null;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("autos.findByLikeRZ");
			spq.setParameter("P_RAZON_SOCIAL", rz);
			if (spq.execute()) {
				lstAutos = (List<Autos>)spq.getOutputParameterValue("P_C_CURSOR");
				
			}
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException(e);
		}
		return lstAutos;
	}

}
