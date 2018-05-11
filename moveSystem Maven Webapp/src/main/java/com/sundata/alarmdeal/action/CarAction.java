package com.sundata.alarmdeal.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sundata.alarmdeal.model.CarModel;
import com.sundata.alarmdeal.service.CarService;
import com.sundata.common.base.BaseAction;
@Controller
@RequestMapping("car")
public class CarAction extends BaseAction {
	@Autowired 
	private CarService carService;
	
	String path="alarm";
	@RequestMapping("/init")
public ModelAndView init(){
	Map<String,Object> context= new HashMap<String,Object>();
	return forword(path+"/carManage", context);
}
@RequestMapping("/queryCar")
public void queryCar(HttpServletResponse response){
	sendData(response,carService.queryCar());
}
@RequestMapping("display")
public ModelAndView display(HttpServletResponse response,CarModel model){
	Map<String,Object> context= new HashMap<String,Object>();
	context.put("carModel",carService.display(model));
	return forword(path+"/carTab", context);
}


}
