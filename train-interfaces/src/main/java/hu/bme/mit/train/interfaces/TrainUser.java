package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();
	
	boolean getAlarmState();
	
	void setAlarmState(boolean newState);

	void overrideJoystickPosition(int joystickPosition);

}
