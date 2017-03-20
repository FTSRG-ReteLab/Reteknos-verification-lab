package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainController;

import static org.mockito.Mockito.*;

import javax.rmi.CORBA.Stub;

public class TrainSensorTest {
	TrainSensorImpl trainSensor;
	TrainUser mTrainUser;
	TrainController mController;
	
    @Before
    public void before() {
    	mTrainUser= mock(TrainUser.class);
    	mController = mock(TrainController.class);
        trainSensor = new TrainSensorImpl(mController,mTrainUser);
    }

    @Test
    public void NegativeSpeedLimitTest() {
        trainSensor.overrideSpeedLimit(-3);
    	verify(mTrainUser,times(1)).setAlarmState(true);
    }
    
    @Test
    public void ValidSpeedLimitTest() {
        trainSensor.overrideSpeedLimit(200);
        verify(mTrainUser,times(0)).setAlarmState(true);
    }
    
    @Test
    public void TooLargeSpeedLimitTest() {
        trainSensor.overrideSpeedLimit(501);
        verify(mTrainUser,times(1)).setAlarmState(true);
    }
    
    @Test
    public void HalfSpeedLimitTest() {
    	when(mController.getReferenceSpeed()).thenReturn(100);
    	trainSensor.overrideSpeedLimit(50);
    	verify(mTrainUser,times(0)).setAlarmState(true);
    }
    
    @Test
    public void MoreThanHalfSpeedLimitTest() {
    	when(mController.getReferenceSpeed()).thenReturn(200);
    	trainSensor.overrideSpeedLimit(50);
    	verify(mTrainUser,times(1)).setAlarmState(true);
    }
    
}
