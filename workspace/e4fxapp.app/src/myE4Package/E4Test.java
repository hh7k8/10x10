package myE4Package;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.core.di.LocalInstance;
// import org.eclipse.fx.ui.di.FXMLLoader;
// import org.eclipse.fx.ui.di.FXMLLoaderFactory;
import org.osgi.service.event.Event;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class E4Test {
	@Inject
	private MPart part;
	@Inject
	private IEclipseContext context;
	@Inject
	private IEventBroker eventBroker;
	
	Text t = new Text("Initial value");
	
	@PostConstruct
	void initUI(BorderPane pane, @LocalInstance FXMLLoader loader) {

		class Pressure {
			public String description;
			public double pressure;
		}
		eventBroker.subscribe("DATA", this::printPost);
		Map<String, String> props = part.getProperties();
//		System.out.println(props.get("title"));
//		System.out.println(props.get("namespace prefix"));
//		System.out.println("y-axis");
		List<String> vars = part.getVariables();
		for (String temp : vars) {
			System.out.println(temp);
			Pressure pres = new Pressure();
			pres.description = "Analog description";
			pres.pressure = 34.56;
			context.set(temp, pres);
		}
		Pressure pres2 = new Pressure();
		pres2.description = "junk desc";
		pres2.pressure = 12.34;
		context.set("junk", pres2);
		Pressure retrieve = (Pressure) context.get("junk");
//		System.out.println(retrieve.description + " " + retrieve.pressure);

		Button b = new Button("button");
  		loader.setLocation(getClass().getResource("lg.fxml"));
		pane.setTop(b);
		try {
			pane.setCenter(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pane.setBottom(t);
	}
	/*
	 *	getPropertyNames returns 2 strings - org.eclipse.e4.data and event.topics
	 *	which can be used to get the data or the topic.
	 *
	 *	Of course using getTopic means that it is necessary to use getProperty only
	 *	with the first string (data)
	 */
	void printPost(Event event){
		t.setText((event.getProperty("org.eclipse.e4.data").toString()));
		
//		System.out.println(event.getTopic());
//		System.out.println(event.getPropertyNames()[1]);
//		System.out.println(event.getProperty("event.topics"));
//		System.out.println(event.getProperty("org.eclipse.e4.data"));
	}

}
