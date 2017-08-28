package com.thtf.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * Socket处理器
 * 
 * @author Goofy
 * @Date 2015年6月11日 下午1:19:50
 */
@Component
public class ThtfWebSocketHandler implements WebSocketHandler {
	
	//{type:{sessionId:session}}//
	public static final Map<String, HashMap<String,WebSocketSession>> userSocketSessionMap;

	static {
		userSocketSessionMap = new HashMap<String, HashMap<String,WebSocketSession>>();
	}

	/**
	 * 建立连接后
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String type = (String) session.getAttributes().get("type");
		if (userSocketSessionMap.get(type) == null) {
			userSocketSessionMap.put(type, new HashMap<String,WebSocketSession>());
		}
		if(userSocketSessionMap.get(type).get(session.getId())==null){
			userSocketSessionMap.get(type).put(session.getId(),session);
		};
	}

	/**
	 * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	 */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		if (message.getPayloadLength() == 0)
			return;
		//如果有需要，修改Message类适应其消息内容
		/*Message msg = new Gson().fromJson(message.getPayload().toString(), Message.class);
		msg.setDate(new Date());
		sendMessageToUser(msg.getTo(),new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));*/
	}

	/**
	 * 消息传输错误处理
	 */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		
		if (session.isOpen()) {
			session.close();
		}
		
		Iterator<HashMap<String, WebSocketSession>> it = userSocketSessionMap.values().iterator();
		while (it.hasNext()) {
			HashMap<String, WebSocketSession> map = it.next();
			if(map.get(session.getId())!=null){
				map.remove(session.getId());
				System.out.println("Socket会话已经移除: sessionID = " + session.getId());
			}
		}
	}

	/**
	 * 关闭连接后
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.out.println("Websocket:" + session.getId() + "已经关闭");
		
		Iterator<HashMap<String, WebSocketSession>> it = userSocketSessionMap.values().iterator();
		while (it.hasNext()) {
			HashMap<String, WebSocketSession> map = it.next();
			if(map.get(session.getId())!=null){
				map.remove(session.getId());
				System.out.println("Socket会话已经移除: sessionID = " + session.getId());
			}
		}
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 给所有在线用户发送消息
	 * 
	 * @param message
	 * @throws IOException
	 */

	public void broadcast(final String type, final String message) throws IOException {

		if(userSocketSessionMap.get(type)!=null){
			Map<String,WebSocketSession> map = userSocketSessionMap.get(type);
			Iterator<WebSocketSession> it = map.values().iterator();
			// 多线程群发
			while (it.hasNext()) {
				final WebSocketSession session = it.next();
				if (session.isOpen()) {
					new Thread(new Runnable() {
						public void run() {
							try {
								session.sendMessage(new TextMessage(message));
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}).start();
				}
			}
		}
		
	}

	/**
	 * 给某个用户发送消息
	 * 
	 * @param userName
	 * @param message
	 * @throws IOException
	 */
	public void sendMessageToUser(Long uid, TextMessage message) throws IOException {
		/*WebSocketSession session = userSocketSessionMap.get(uid);
		if (session != null && session.isOpen()) {
			session.sendMessage(message);
		}*/
	}

}
