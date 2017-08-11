package com.thtf.sj.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.thtf.sj.entity.User;

@Controller
@RequestMapping("/user")
@SessionAttributes("users")
public class DemoController {

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ModelAttribute("users")
	@ResponseBody
	public Map<String, Object> getUserMaps() {

		List<User> list = new ArrayList<User>();
		User um = new User();
		um.setId("1");
		um.setName("sss");
		um.setAge(66);
		list.add(um);
		
		um = new User();
		um.setId("2");
		um.setName("aaa");
		um.setAge(44);
		list.add(um);
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("total", list.size());
		modelMap.put("data", list);
		modelMap.put("success", "true");
		return modelMap;
	}

	  @RequestMapping(value = "/add", method = RequestMethod.POST)   
	  @ResponseBody   
	  //二种方式: A HttpEntity<User>  B使用注解 @ResponseBody
	  public Map<String, Object> addUser(HttpEntity<User> model,javax.servlet.http.HttpServletRequest request) {   
		System.out.println("user: " + model.getBody());
	
		Map<String, Object> map = (Map)request.getSession().getAttribute("users");
		if(null == map){
			map = getUserMaps();
		}
		List<User> list = (List<User>)map.get("data");
		list.add(model.getBody());
		map.put("total", list.size());
		map.put("data", list);
		request.getSession().setAttribute("users",map);
		return map;
	}


	@RequestMapping("/ajaxPage")
	public String ajaxAddPage() {
		return "ajax-add-page2";
	}
}