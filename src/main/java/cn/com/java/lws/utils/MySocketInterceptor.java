package cn.com.java.lws.utils;

import cn.com.java.lws.model.User;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class MySocketInterceptor implements HandshakeInterceptor {
    /**
     * 握手后保存用户信息到webSocketSession
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> webSocketSession) throws Exception {
        if(request instanceof ServerHttpRequest){
              ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
              HttpSession session = servletRequest.getServletRequest().getSession();
              if(session!=null){
                  User htUser = (User) session.getAttribute("htUser");
                  webSocketSession.put("user_id",htUser.getId());
            }
            }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
