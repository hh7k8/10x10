package nonUI;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class NonUI implements IApplication {

	@Inject
//	private EventBus eventBus;
	private IEventBroker eventBroker;

	public Object start(IApplicationContext app) {
 		System.err.println("starting in NonUI");
// 		eventBus.publish("MYTOPIC", "mydata", false);
 		for (int i=1; i<60; i++) {
 			eventBroker.post("MYTOPIC", "my data" + i);
 			try {
				Thread.sleep(1000);
				//System.out.println("loop count = " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
		return app;
	
	}
	public void stop() {
		 System.err.println("stopping in NonUI");
	}
}
