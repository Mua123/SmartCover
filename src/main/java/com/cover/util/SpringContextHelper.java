package com.cover.util;

import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHelper implements ApplicationContextAware {

	private static ApplicationContext context = null;  
	
	private static IoSession session = null;
	  
    @Override  
    public void setApplicationContext(ApplicationContext applicationContext)  throws BeansException {  
    	
    	context = applicationContext;  
    	clientStart();
    }  
      
    private void clientStart() {
    	IoConnector connector = new NioSocketConnector();
    	
//      断线重连回调拦截器  
    	connector.getFilterChain().addFirst("reconnection", new IoFilterAdapter() {  
    		@Override  
    		public void sessionClosed(NextFilter nextFilter, IoSession ioSession) throws Exception {  
    			for(;;){  
    				try{  
    					Thread.sleep(3000);  
    					ConnectFuture future = connector.connect();  
    					future.awaitUninterruptibly();// 等待连接创建成功  
    					session = future.getSession();// 获取会话  
    					if(session.isConnected()){  
    						System.out.println("断线重连["+ ((InetSocketAddress) connector.getDefaultRemoteAddress()).getHostName() +":"+ ((InetSocketAddress) connector.getDefaultRemoteAddress()).getPort()+"]成功");  
    						break;  
    					}  
    				}catch(Exception ex){  
    					ex.printStackTrace();
    					System.out.println("重连服务器登录失败,3秒再连接一次:" + ex.getMessage());  
    				}  
    			}  
    		}  
    	});  
    	
    	connector.setDefaultRemoteAddress(new InetSocketAddress("localhost", 12346));// 设置默认访问地址
        connector.setHandler((IoHandlerAdapter)context.getBean("ClientHandler"));  
        ConnectFuture connFuture = connector.connect();  
        
          
        
        session = connFuture.getSession();
	}

	public static Object getBean(String name){  
        return context.getBean(name);  
    }  
	
	public static IoSession getSession(){  
		return session;
	}  

}
