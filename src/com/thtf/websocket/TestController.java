package com.thtf.websocket;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/testController")
public class TestController {

	ThtfWebSocketHandler handler;
	
	@RequestMapping(value = "/broadcast", method = RequestMethod.GET)
	@ResponseBody
	public void broadcast(){
		try {
			handler.broadcast("zl", "这是指令的websocket，你们能收到吗？");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/broadcast2", method = RequestMethod.GET)
	@ResponseBody
	public void broadcast2(){
		try {
			handler.broadcast("zl2", "这是指令的websocket，你们能收到吗？");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
