package com.cover.handler;

import javax.annotation.Resource;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.cover.entity.WellLocation;
import com.cover.entity.WellStatus;
import com.cover.service.WellService;

public class ClientHandler extends IoHandlerAdapter{
	@Resource 
	private WellService wellService;
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sessionCreated");
		super.sessionCreated(session);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("sessionOpened");
		super.sessionOpened(session);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(session, cause);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("messageReceived");
		byte[] result=new byte[1];
		IoBuffer ioBuffer = (IoBuffer)message;
		
        byte[] data = new byte[ioBuffer.limit()-ioBuffer.position()];
        ioBuffer.get(data);
        WellStatus well = new WellStatus();
        well.setWellNo("TX-001");
        String s = new String(data,"UTF-8");
        if(s.startsWith("Up Cover"))
        	if(s.endsWith("Closed"))
        		well.setUpCoverStatus(1);
        	else
        		well.setUpCoverStatus(2);
        else if(s.startsWith("Down Cover"))
        	if(s.endsWith("Closed"))
        		well.setDownCoverStatus(1);
        	else
        		well.setDownCoverStatus(2);
        else if(s.startsWith("Vibrating"))
        	well.setVibratingStatus(1);
        else if(s.startsWith("VibCancel"))
        	well.setVibratingStatus(2);
        
        wellService.updateWellById(well);
		result = strToByte("00-00");
   	 	// 组织IoBuffer数据包的方法：本方法才可以正确地让客户端UDP收到byte数组
        IoBuffer buf = IoBuffer.wrap(result);

        // 回复数据
        WriteFuture future = session.write(buf);
		
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.inputClosed(session);
	}

	public static String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
	
   /**
     * 将16进制的字符串转成byte[]数组
     * “AA-41-42-43”
     * @param s
     * @return
     */
	public static byte[] strToByte(String s) {
		String[] sList = s.split("-");
		byte[] bytes = new byte[sList.length];
		for(int i = 0; i < sList.length; i++) {
			int iValue = Integer.parseInt(sList[i], 16);
			bytes[i] = (byte)iValue;
		}
		
		return bytes;
	}
	
}
