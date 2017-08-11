package com.thtf.sj.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thtf.sj.entity.User;

@Controller
@RequestMapping("/main/ajax")
public class AjaxController {

	/**
	 * 根据映射跳转到指定的页面
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAjaxAddPage() {
		// 解析 /WEB-INF/jsp/ajax-add-page.jsp
		return "ajax-add-page";
	}

	/**	 
     * 提交表单并进行运算.
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Integer add(
			@RequestParam(value = "inputNumber1", required = true)Integer inputNumber1,
			@RequestParam(value = "inputNumber2", required = true)Integer inputNumber2) {
		// 实现运算
		Integer sum = inputNumber1 + inputNumber2;
		System.out.println("sum: " + sum);
		// @ResponseBody 会自动的将返回值转换成JSON格式
		// 但是你必须添加jackson的jar包!!!
		return sum;
	}	

	@RequestMapping(value = "/getUser/{userId}", method = RequestMethod.POST)
	public @ResponseBody User getUser(@PathVariable("userId")String  userId) {
		System.out.println("根据ID获取用户对象: " + userId);		
		Map<String,User> users = new HashMap<String,User>();
		users.put("1", new User("123456", "李逵", "123", "成都市", "1", 23));
		users.put("2", new User("565676", "张三", "123", "北京市", "2", 53));
		users.put("3", new User("325566", "李四", "123", "河南省", "2", 93));
		users.put("4", new User("989654", "刘邦", "123", "蒙古包", "1", 13));
		users.put("5", new User("234444", "王熙凤", "123", "成都市", "1", 43));		
		return users.get(userId);
	}

	@RequestMapping(value = "/userList", method = RequestMethod.POST)
	public @ResponseBody
	List<User> getUsers() {		
		List<User> users = new ArrayList<User>();
		users.add(new User("123456", "李逵", "123", "成都市", "1", 23));
		users.add(new User("123457", "李四", "124", "北京市", "2", 53));
		users.add(new User("123458", "李三", "125", "河南市", "0", 73));
		users.add(new User("123459", "李五", "126", "大路市", "3", 93));
		return users;
	}
	
	@RequestMapping(value = "/userMap", method = RequestMethod.POST)
	public @ResponseBody Map<String,User> getUserMap() {		
		Map<String,User> users = new HashMap<String,User>();
		users.put("1", new User("123456", "李逵", "123", "成都市", "1", 23));
		users.put("2",new User("123457", "李四", "124", "北京市", "2", 53));
		users.put("3",new User("123458", "李三", "125", "河南市", "0", 73));
		users.put("4",new User("123459", "李五", "126", "大路市", "3", 93));
		return users;
	}
}
