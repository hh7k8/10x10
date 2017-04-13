package myAddon;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MAddon;
import org.eclipse.e4.ui.workbench.modeling.EModelService;



public class MyAddon {
	
	private final EModelService modelService;
	
	@Inject
	MyAddon(IEventBroker eventBroker, EModelService modelService, MAddon addon){
//		Map<String, String> persist = addon.getPersistedState();
//		System.out.println(persist);
//		System.out.println("In myAddon");
		System.out.println(eventBroker);
		
		this.modelService = modelService;
		System.out.println(this.modelService.toString());  // do this to get rid of warning
//		eventBroker.subscribe("TEST", this::handleWidget);
		final class MyAddonThread extends Thread{
			public void run() {
				int i = 0;
				System.out.println(eventBroker);
				while (true)
				{
					System.out.println(i++);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		(new MyAddonThread()).start();
		}

 		
//	void handleWidget(Event event){
//		
//	}
 
}
