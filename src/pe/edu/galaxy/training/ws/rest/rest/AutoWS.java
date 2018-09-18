package pe.edu.galaxy.training.ws.rest.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.galaxy.training.ws.rest.bean.AutoBean;
import pe.edu.galaxy.training.ws.rest.bean.ClienteBean;
import pe.edu.galaxy.training.ws.rest.entity.Autos;
import pe.edu.galaxy.training.ws.rest.entity.Cliente;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.AutoService;

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

	public AutoService getAutoservice() {
		return autoservice;
	}

	public void setAutoservice(AutoService autoservice) {
		this.autoservice = autoservice;
	}

}
