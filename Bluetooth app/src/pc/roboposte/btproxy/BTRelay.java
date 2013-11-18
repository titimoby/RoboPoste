package org.roboposte.btproxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.pc.comm.NXTCommLogListener;
import lejos.pc.comm.NXTConnector;

public class BTRelay {
	DataOutputStream outToSocket = null;
	DataInputStream inFromSocket = null;
	private NXTConnector mConn;
	private DataOutputStream mDataOutStream;
	private DataInputStream mDataInStream;

	public BTRelay() {
		
	}
	
	void initBTConnection() {
		mConn = new NXTConnector();
		mConn.addLogListener(new NXTCommLogListener(){

			public void logEvent(String message) {
				System.out.println("BTSend Log.listener: "+message);
				
			}

			public void logEvent(Throwable throwable) {
				System.out.println("BTSend Log.listener - stack trace: ");
				 throwable.printStackTrace();
				
			}
			
		} 
		);
		// Connect to any NXT over Bluetooth
		boolean connected = mConn.connectTo("btspp://");
	
		
		if (!connected) {
			System.err.println("Failed to connect to any NXT");
			System.exit(1);
		}
		
		mDataOutStream = new DataOutputStream(mConn.getOutputStream());
		mDataInStream = new DataInputStream(mConn.getInputStream());
			
	}
	
	void closeBTConnection() {
		try {
			mDataInStream.close();
			mDataOutStream.close();
			mConn.close();
		} catch (IOException ioe) {
			System.out.println("IOException closing connection:");
			System.out.println(ioe.getMessage());
		}
	}
	
	void relayLoop() {
		TouchSensor touch = new TouchSensor(SensorPort.S1);
	    while (!touch.isPressed()) {
			mConn.
		}
	}
}
