package nonUI;

import javax.annotation.PostConstruct;

import javafx.scene.layout.BorderPane;

public class NonUI {
	@PostConstruct
	void init(BorderPane pane){

 		System.err.println("in NonUI");
	
	}
}
