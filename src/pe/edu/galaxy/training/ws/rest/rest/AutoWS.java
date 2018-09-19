package pe.edu.galaxy.training.ws.rest.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.galaxy.training.ws.rest.bean.AutoBean;
import pe.edu.galaxy.training.ws.rest.bean.ClienteBean;
import pe.edu.galaxy.training.ws.rest.entity.Autos;
import pe.edu.galaxy.training.ws.rest.entity.Cliente;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.AutoService;

@Controller
@RequestMapping("/autoService")
public class AutoWS {

	@Autowired
	private AutoService autoservice;

	public AutoWS() {

	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<AutoBean> listar() {
		List<AutoBean> lstAutoBean = new ArrayList<AutoBean>();
		Autos auto = new Autos();
		try {
			System.out.println(auto);
			List<Autos> lstAuto = this.getAutoservice().findByLikeObject(auto);
			lstAutoBean = this.getAutoBean(lstAuto);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lstAutoBean;
	}

	private List<AutoBean> getAutoBean(List<Autos> lstAutos) {

		List<AutoBean> lstAutosBean = new ArrayList<AutoBean>();
		for (Autos oAutos : lstAutos) {
			AutoBean autoBean = new AutoBean();
			try {
				BeanUtils.copyProperties(autoBean, oAutos);
				lstAutosBean.add(autoBean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return lstAutosBean;
	}

	
	@RequestMapping(value = "/listarParam",	method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody List<AutoBean> listarParam(@RequestParam("rz") String rz) {
		System.out.println("listarParam "+rz);
		List<AutoBean> lstAutoBean = new ArrayList<AutoBean>();
		try {
			List<Autos> lstAutos=this.getAutoservice().findByLikeRZ(rz);
			lstAutoBean=this.getAutoBean(lstAutos);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lstAutoBean;
	}
	
	@RequestMapping(value = "/insertar",method = RequestMethod.POST,consumes="application/json; charset=utf-8",	produces = "application/json; charset=utf-8")
public @ResponseBody Object insertar(@RequestBody AutoBean AutoBean) {
		Autos auto = new Autos();
		boolean sw=false;
		try {
			BeanUtils.copyProperties(auto, AutoBean);
			sw=this.getAutoservice().insert(auto);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ret=(sw)?"\"Exito\"":"\"Error\"";
		String restultdo="{\"retultado\":"+ret+"}";
		return restultdo;
	}
	
	@RequestMapping(value = "/actualizar",
			method = RequestMethod.PUT,
			consumes="application/json; charset=utf-8",
			produces = "application/json; charset=utf-8")
	public @ResponseBody Object actualizar(@RequestBody AutoBean AutoBean) {
		Autos auto = new Autos();
		boolean sw=false;
		try {
			BeanUtils.copyProperties(auto, AutoBean);
			sw=this.getAutoservice().update(auto);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ret=(sw)?"\"Exito\"":"\"Error\"";
		String restultdo="{\"retultado\":"+ret+"}";
		return restultdo;
	}
	
	@RequestMapping(value = "/eliminar",method = RequestMethod.DELETE,consumes="application/json; charset=utf-8",produces = "application/json; charset=utf-8")
	public @ResponseBody Object eliminar(@RequestBody AutoBean AutoBean) {
		Autos auto = new Autos();
		boolean sw=false;
		try {
			BeanUtils.copyProperties(auto, AutoBean);
			sw=this.getAutoservice().delete(auto);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ret=(sw)?"\"Exito\"":"\"Error\"";
		String restultdo="{\"retultado\":"+ret+"}";
		return restultdo;
	}
	
	
	public AutoService getAutoservice() {
		return autoservice;
	}

	public void setAutoservice(AutoService autoservice) {
		this.autoservice = autoservice;
	}

}
