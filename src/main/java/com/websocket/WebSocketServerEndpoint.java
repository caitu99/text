package com.websocket;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@ServerEndpoint(value = "/game")
public class WebSocketServerEndpoint {

    private Logger logger = Logger.getLogger(getClass());
    private Logger loginLogger = Logger.getLogger("login");
    private Logger goodsLogger = Logger.getLogger("goods");
    private Logger orderLogger = Logger.getLogger("order");
    private Logger manageLogger = Logger.getLogger("manage");
    private Logger couponLogger = Logger.getLogger("coupon");
    
    private Logger _logger = null;
    
    private static final Map<String,Logger> logs = new HashMap<String,Logger>();
    {
    	logs.put("login", loginLogger);
    	logs.put("goods", goodsLogger);
    	logs.put("order", orderLogger);
    	logs.put("manage", manageLogger);
    	logs.put("coupon", couponLogger);
    }

    @OnOpen
    public void onOpen(Session session) {
        logger.info("Connected ... " + session.getId());
    }

    @OnMessage
	public String onMessage(String unscrambledWord, Session session) {
    	JSONObject json = JSON.parseObject(unscrambledWord);
    	//日志等级
    	String grade = json.getString("grade");
    	//日志内容
    	String message = json.getString("message");
    	//设备机型
    	String type = json.getString("type");
    	//日记分组
    	String name = json.getString("name");
    	
    	Iterator<Map.Entry<String, Logger>> iterator = logs.entrySet().iterator();
    	
    	while(iterator.hasNext()){
    		Map.Entry<String, Logger> i = iterator.next();
    		String log = i.getKey();
    		Logger logger = i.getValue();
    		
    		if(log.equals(name)){
        		_logger = logger;
        		break;
    		}
    	}
    	
    	if(null == _logger){
    		_logger = logger;
    	}
    	
    	if("info".equals(grade)){
    		_logger.info("设备机型:" + type + ",Session:" + session.getId() + "-->" + message);
    	}else if("error".equals(grade)){
    		_logger.error("设备机型:" + type + ",Session:" + session.getId() + "-->" + message);
    	}else if("warn".equals(grade)){
    		_logger.warn("设备机型:" + type + ",Session:" + session.getId() + "-->" + message);
    	}else if("log".equals(grade)){
    		_logger.info("设备机型:" + type + ",Session:" + session.getId() + "-->" + message);
    	}else{
    		_logger.info("设备机型:" + type + ",Session:" + session.getId() + "-->" + message);
    	}
    	
    	return null;
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }
}
