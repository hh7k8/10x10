package nonUI;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class NonUI implements IApplication {

	 public Object start(IApplicationContext app) {
 		System.err.println("starting in NonUI");
		return app;
	
	}
	 public void stop() {
		 System.err.println("stopping in NonUI");
	 }
}
