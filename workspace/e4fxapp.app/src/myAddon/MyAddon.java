package myAddon;

import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MAddon;
import org.eclipse.e4.ui.workbench.modeling.EModelService;



public class MyAddon {
	
	private final EModelService modelService;
	
	@Inject
	MyAddon(IEventBroker eventBroker, EModelService modelService, MAddon addon){
		Map<String, String> persist = addon.getPersistedState();
//		System.out.println(persist);
//		System.out.println("In myAddon");
		
		this.modelService = modelService;
//		eventBroker.subscribe("TEST", this::handleWidget);

		/*		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		}
//	void handleWidget(Event event){
//		
//	}
}
