package com.ycx.websocket;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
@RequestMapping("websocket")
public class WebsocketEndPoint extends TextWebSocketHandler { 
	private static final ArrayList<WebSocketSession> users = new ArrayList<>();

    @Override  
    protected void handleTextMessage(WebSocketSession session,  
            TextMessage message) throws Exception {  
        super.handleTextMessage(session, message);  
        System.out.println(session.getId());
        if(!users.contains(session)){
        	users.add(session);
        }
        
        TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");  
        System.out.println("handleTextMessage is run...");
        sendMessageToUsers(returnMessage);  
    }  
    
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}  
