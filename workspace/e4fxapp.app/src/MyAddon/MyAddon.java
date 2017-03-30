package MyAddon;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

public class MyAddon {
	@Inject
	MyAddon(IEventBroker eventBroker, EModelService modelService){
		System.out.println("In myAddon");
	}
}
