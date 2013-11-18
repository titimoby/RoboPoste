package org.roboposte;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class testTouch {
	public static void main(String[] args) throws Exception {
	    TouchSensor touch = new TouchSensor(SensorPort.S1);
	    while (!touch.isPressed()) {
	    	// try again
	    }
	    LCD.drawString("Finished", 3, 4);
	    Thread.sleep(1000);
	  }
}
