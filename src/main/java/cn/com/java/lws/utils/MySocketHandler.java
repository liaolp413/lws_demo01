package cn.com.java.lws.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *   服务器端的Socket对象
 */
@Component
@RequestMapping("/mySocketHandler")
public class MySocketHandler implements WebSocketHandler {
	
	//日志对象
    private Logger logger = LoggerFactory.getLogger(MySocketHandler.class);
    //用户握手集合  key为用户id   value为WebSocketSession对象，服务器端保存多个客户端的WebSocketSession对象
    private static final Map<Integer, WebSocketSession> users = new ConcurrentHashMap<Integer, WebSocketSession>();

    //连接成功后操作
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

        Integer id = this.parsing(webSocketSession);  //登录后的此用户id
		logger.info("用户id为"+id+"的webSocket链接成功。。");

    }

    //处理消息
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
		String msgStr = webSocketMessage.getPayload().toString();
		logger.info(msgStr);
	}

    //连接异常操作
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable exception) throws Exception {
        if(webSocketSession.isOpen()){
        	webSocketSession.close();
        }
		Integer id = this.parsing(webSocketSession);  //登录后的此用户id
        logger.error("用户id为"+id+"的webSocket连接出现错误",exception);

    }

    //关闭连接后的操作
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
    	if (webSocketSession.isOpen()) {
    		webSocketSession.close();
		}
		Integer id = this.parsing(webSocketSession);  //登录后的此用户id
        logger.info("用户id为"+id+"的webSocket连接关闭");
    }

    @Override
    public boolean supportsPartialMessages() {

        return false;
    }
    
    /**
	 * @功能:解析出登录id
	 * @作者:djin
	 * @时间:2018年12月12日
	 * @param webSocketSession
	 * @return
	 */
	private Integer parsing(WebSocketSession webSocketSession) {
		
		return (Integer) webSocketSession.getAttributes().get("user_id");
	}

 }
