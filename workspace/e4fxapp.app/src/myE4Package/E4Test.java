package myE4Package;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.core.di.LocalInstance;
// import org.eclipse.fx.ui.di.FXMLLoader;
// import org.eclipse.fx.ui.di.FXMLLoaderFactory;
import org.osgi.service.event.Event;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class E4Test {
	@Inject
	private MPart part;
	@Inject
	private IEclipseContext context;
	@Inject
	private IEventBroker eventBroker;
	
	Text t = new Text("Initial value");

	
	private Rectangle rect;
	private Rectangle rect1;
	private Rectangle rect2;
	private Rectangle rect3;
	private Rectangle rect4;
	private Rectangle rect5;
	private Rectangle rect6;
	private Rectangle rect7;
	private Rectangle rect8;
	private Rectangle rect9;
	private Rectangle rect10;
	private Rectangle rect11;
	private Rectangle rect12;
	private Rectangle rect13;
	private Rectangle rect14;
	private Rectangle rect15;
	private Rectangle rect16;
	private Rectangle rect17;
	private Rectangle rect18;
	private Rectangle rect19;

	
	private Timeline timeline;
	private Timeline timeline1;
	private Timeline timeline2;
	private Timeline timeline3;
	private Timeline timeline4;
	private Timeline timeline5;
	private Timeline timeline6;
	private Timeline timeline7;
	private Timeline timeline8;
	private Timeline timeline9;
	private Timeline timeline10;
	private Timeline timeline11;
	private Timeline timeline12;
	private Timeline timeline13;
	private Timeline timeline14;
	private Timeline timeline15;
	private Timeline timeline16;
	private Timeline timeline17;
	private Timeline timeline18;
	private Timeline timeline19;

	
	private double widthOfOneGradientCycle = 20.0;
	private double gradientSlopeDegree = 180.0;
	private double xStartStatic = 100.0;
	private double yStartStatic = 100.0;
	private double xEndStatic = xStartStatic + (widthOfOneGradientCycle * Math.cos(Math.toRadians(gradientSlopeDegree)));
	private double yEndStatic = yStartStatic + (widthOfOneGradientCycle * Math.sin(Math.toRadians(gradientSlopeDegree)));

	@PreDestroy
	void CleanUp () {
		timeline.stop();
		timeline1.stop();
		timeline2.stop();
		timeline3.stop();
		timeline4.stop();
		timeline5.stop();
		timeline6.stop();
		timeline7.stop();
		timeline8.stop();
		timeline9.stop();
		timeline10.stop();
		timeline11.stop();
		timeline12.stop();
		timeline13.stop();
		timeline14.stop();
		timeline15.stop();
		timeline16.stop();
		timeline17.stop();
		timeline18.stop();
		timeline19.stop();

	}
	
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
  		loader.setLocation(getClass().getResource("Lg.fxml"));
  		
  		
  		
  	// ******************* original rect and timeline 		
  		rect = new Rectangle(0, 0, 150, 20);
		timeline = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect.setFill(gradient);
				}
			});
			timeline.getKeyFrames().add(kf);
		}
		timeline.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect1 = new Rectangle(0, 0, 150, 20);
		timeline1 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect1.setFill(gradient);
				}
			});
			timeline1.getKeyFrames().add(kf);
		}
		timeline1.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect2 = new Rectangle(0, 0, 150, 20);
		timeline2 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect2.setFill(gradient);
				}
			});
			timeline2.getKeyFrames().add(kf);
		}
		timeline2.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect3 = new Rectangle(0, 0, 150, 20);
		timeline3 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect3.setFill(gradient);
				}
			});
			timeline3.getKeyFrames().add(kf);
		}
		timeline3.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect4 = new Rectangle(0, 0, 150, 20);
		timeline4 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect4.setFill(gradient);
				}
			});
			timeline4.getKeyFrames().add(kf);
		}
		timeline4.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect5 = new Rectangle(0, 0, 150, 20);
		timeline5 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect5.setFill(gradient);
				}
			});
			timeline5.getKeyFrames().add(kf);
		}
		timeline5.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect6 = new Rectangle(0, 0, 150, 20);
		timeline6 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect6.setFill(gradient);
				}
			});
			timeline6.getKeyFrames().add(kf);
		}
		timeline6.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect7 = new Rectangle(0, 0, 150, 20);
		timeline7 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect7.setFill(gradient);
				}
			});
			timeline7.getKeyFrames().add(kf);
		}
		timeline7.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect8 = new Rectangle(0, 0, 150, 20);
		timeline8 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect8.setFill(gradient);
				}
			});
			timeline8.getKeyFrames().add(kf);
		}
		timeline8.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect9 = new Rectangle(0, 0, 150, 20);
		timeline9 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect9.setFill(gradient);
				}
			});
			timeline9.getKeyFrames().add(kf);
		}
		timeline9.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
		// ******************* original rect and timeline 		
  		rect10 = new Rectangle(0, 0, 150, 20);
		timeline10 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect10.setFill(gradient);
				}
			});
			timeline10.getKeyFrames().add(kf);
		}
		timeline10.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect11 = new Rectangle(0, 0, 150, 20);
		timeline11 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect11.setFill(gradient);
				}
			});
			timeline11.getKeyFrames().add(kf);
		}
		timeline11.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect12 = new Rectangle(0, 0, 150, 20);
		timeline12 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect12.setFill(gradient);
				}
			});
			timeline12.getKeyFrames().add(kf);
		}
		timeline12.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect13 = new Rectangle(0, 0, 150, 20);
		timeline13 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect13.setFill(gradient);
				}
			});
			timeline13.getKeyFrames().add(kf);
		}
		timeline13.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect14 = new Rectangle(0, 0, 150, 20);
		timeline14 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect14.setFill(gradient);
				}
			});
			timeline14.getKeyFrames().add(kf);
		}
		timeline14.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect15 = new Rectangle(0, 0, 150, 20);
		timeline15 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect15.setFill(gradient);
				}
			});
			timeline15.getKeyFrames().add(kf);
		}
		timeline15.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect16 = new Rectangle(0, 0, 150, 20);
		timeline16 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect16.setFill(gradient);
				}
			});
			timeline16.getKeyFrames().add(kf);
		}
		timeline16.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect17 = new Rectangle(0, 0, 150, 20);
		timeline17 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect17.setFill(gradient);
				}
			});
			timeline17.getKeyFrames().add(kf);
		}
		timeline17.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect18 = new Rectangle(0, 0, 150, 20);
		timeline18 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect18.setFill(gradient);
				}
			});
			timeline18.getKeyFrames().add(kf);
		}
		timeline18.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
  		
 // ******************* original rect and timeline 		
  		rect19 = new Rectangle(0, 0, 150, 20);
		timeline19 = new Timeline();
		for (int i = 0; i < 10; i++) {
			int innerIterator = i;
			KeyFrame kf = new KeyFrame(Duration.millis(30 * innerIterator), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					
					double runningRadius = innerIterator * (widthOfOneGradientCycle / 10);
					double xStartDynamic = xStartStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yStartDynamic = yStartStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					double xEndDynamic = xEndStatic + (runningRadius * Math.cos(Math.toRadians(gradientSlopeDegree)));
					double yEndDynamic = yEndStatic + (runningRadius * Math.sin(Math.toRadians(gradientSlopeDegree)));
					
					LinearGradient gradient = new LinearGradient(xStartDynamic, yStartDynamic, xEndDynamic, yEndDynamic, 
							false, CycleMethod.REPEAT, new Stop[] {
								new Stop(0.0, Color.WHITE),
								new Stop(0.5, Color.BLACK),
								new Stop(1.0, Color.WHITE)
					});
					rect19.setFill(gradient);
				}
			});
			timeline19.getKeyFrames().add(kf);
		}
		timeline19.setCycleCount(Timeline.INDEFINITE);
//************** end of rect and timeline
		
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(rect, rect1, rect2, rect3, rect4, rect5,
				rect6, rect7,rect8, rect9,rect10, rect11, rect12, rect13, 
				rect14, rect15, rect16, rect17,rect18, rect19);
		
		pane.setCenter(hbox);
		
/*
 *		pane.setCenter(rect);
 *		pane.setCenter(rect1);
 * 		pane.setCenter(rect2);
 * 		pane.setCenter(rect3);
 * 		pane.setCenter(rect4);
 * 		pane.setCenter(rect5);
 * 		pane.setCenter(rect6);
 * 		pane.setCenter(rect7);
 * 		pane.setCenter(rect8);
 * 		pane.setCenter(rect9);
 */ 		
//		pane.setTop(b);
/*		try {
 *			pane.setCenter(loader.load());
 *		} catch (IOException e) {
 *			// TODO Auto-generated catch block
 *			e.printStackTrace();
 *		}
 */
//		pane.setBottom(t);
		
		timeline.play();
		timeline1.play();
		timeline2.play();
		timeline3.play();
		timeline4.play();
		timeline5.play();
		timeline6.play();
		timeline7.play();
		timeline8.play();
		timeline9.play();
		timeline10.play();
		timeline11.play();
		timeline12.play();
		timeline13.play();
		timeline14.play();
		timeline15.play();
		timeline16.play();
		timeline17.play();
		timeline18.play();
		timeline19.play();

	}
	/*
	 *	getPropertyNames returns 2 strings - org.eclipse.e4.data and event.topics
	 *	which can be used to get the data or the topic.
	 *
	 *	Of course using getTopic means that it is necessary to use getProperty only
	 *	with the first string (data)
	 */
	void printPost(Event event){
		int i = (int) event.getProperty("org.eclipse.e4.data");
		if (i % 2 == 1) timeline.play(); else timeline.pause(); 
		if (i % 2 == 1) timeline1.play(); else timeline1.stop(); 
		if (i % 2 == 1) timeline2.play(); else timeline2.stop(); 
		if (i % 2 == 1) timeline3.play(); else timeline3.stop(); 
		if (i % 2 == 1) timeline4.play(); else timeline4.stop(); 
		if (i % 2 == 1) timeline5.play(); else timeline5.stop(); 
		if (i % 2 == 1) timeline6.play(); else timeline6.stop(); 
		if (i % 2 == 1) timeline7.play(); else timeline7.stop(); 
		if (i % 2 == 1) timeline8.play(); else timeline8.stop(); 
		if (i % 2 == 1) timeline9.play(); else timeline9.stop(); 

		t.setText((event.getProperty("org.eclipse.e4.data").toString()));
		
//		System.out.println(event.getTopic());
//		System.out.println(event.getPropertyNames()[1]);
//		System.out.println(event.getProperty("event.topics"));
//		System.out.println(event.getProperty("org.eclipse.e4.data"));
	}

}
