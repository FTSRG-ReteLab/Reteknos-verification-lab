package hu.bme.mit.train.controller;

public class TrainControllerScheduler extends Thread{
	
	TrainControllerImpl trainController ;
	
	
	TrainControllerScheduler(TrainControllerImpl trainController) {
		this.trainController=trainController;
	}
	
	@Override
	public void run() {	
		
		while (true) {
		try {
			trainController.followSpeed();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
		
	}

}
