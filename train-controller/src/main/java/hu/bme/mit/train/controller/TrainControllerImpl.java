package hu.bme.mit.train.controller;

import java.util.Timer;
import java.util.TimerTask;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private TimerTask timertask=null;
	private Timer t=new Timer();

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}
	
	class SpeedSetTask extends TimerTask {
        public void run() {
           followSpeed();
        }
    }

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;	
		if (this.step==0) {
			if(timertask!=null) timertask.cancel();
			if(timertask!=null) timertask=null;
			return;
		}
		if(timertask==null) timertask= new SpeedSetTask();
		t.schedule(timertask, 1000,1000);
	}

}
