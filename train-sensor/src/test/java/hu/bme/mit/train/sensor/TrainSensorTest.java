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
	
	
	
    @Before
    public void before() {
    	TrainUser trainUser= mock(TrainUser.class);
    	TrainController controller = mock(TrainController.class);
        trainSensor = new TrainSensorImpl(controller,trainUser);
    }

    @Test
    public void NegativeSpeedLimitTest() {
        
    }
    
    @Test
    public void ValidSpeedLimitTest() {
        
    }
    
    @Test
    public void TooLargeSpeedLimitTest() {
        
    }
    
    @Test
    public void HalfSpeedLimitTest() {
        
    }
    
    @Test
    public void MoreThanHalfSpeedLimitTest() {
        
    }
    
}
