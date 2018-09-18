package pe.edu.galaxy.training.ws.rest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.edu.galaxy.training.ws.rest.bean.ClienteBean;
import pe.edu.galaxy.training.ws.rest.bean.TallerBean;
import pe.edu.galaxy.training.ws.rest.entity.Cliente;
import pe.edu.galaxy.training.ws.rest.entity.Taller;
import pe.edu.galaxy.training.ws.rest.service.inf.TallerService;
@Path("/tallerService/v1")
public class TallerWS extends SpringBeanAutowiringSupport{
	@Autowired
	private TallerService tallerService;
	
	@GET
	@Path("/listar/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TallerBean> listar(@PathParam("nombre") String nombre){
		List<TallerBean> lst= new ArrayList<TallerBean>();
		try {
			Taller taller= new Taller();
			taller.setNombre(nombre);
			List<Taller> lstE= this.getTallerService().findByLikeObject(taller);
			for (Taller oTaller : lstE) {
				TallerBean tallerBean= new TallerBean();
				BeanUtils.copyProperties(tallerBean,oTaller);
				lst.add(tallerBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object insertar(TallerBean tallerBean) {
		Taller taller = new Taller();
		boolean sw=false;
		try {
			BeanUtils.copyProperties(taller, tallerBean);
			sw=this.getTallerService().insert(taller);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ret=(sw)?"\"Exito\"":"\"Error\"";
		String restultdo="{\"retultado\":"+ret+"}";
		
		System.out.println(restultdo);
		return restultdo;
	}
	
	
	public TallerService getTallerService() {
		return tallerService;
	}

	public void setTallerService(TallerService tallerService) {
		this.tallerService = tallerService;
	}
	

}
