package com.thtf.websocket;
import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebMvc
@EnableWebSocket
@Component
public class WebSocketConfig implements WebSocketConfigurer {

	@Resource
	ThtfWebSocketHandler handler;
	
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler, "/websocket.mvc").addInterceptors(new HandshakeInterceptor());;
        registry.addHandler(handler, "/websocket/sockjs").addInterceptors(new HandshakeInterceptor()).withSockJS();
    }

}