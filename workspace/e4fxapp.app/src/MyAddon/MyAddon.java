package MyAddon;

import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MAddon;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

public class MyAddon {
	@Inject
	MyAddon(IEventBroker eventBroker, EModelService modelService, MAddon addon){
		Map<String, String> persist = addon.getPersistedState();
		System.out.println(persist);
		System.out.println("In myAddon");
	}
}
