package activities;



import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class ActionBase {
	
	
	//create the pointer
	
	static final PointerInput pointer = new PointerInput(Kind.TOUCH,"finger");
	
	
	
	//create the action function
	public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration){    // point is collection of x and y
		
		//create the sequence of action
		
		Sequence swipe = new Sequence(pointer, 1).                                                               // below are the gestures sequence
				addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY())).
				addAction(pointer.createPointerUp(LEFT.asArg())).  //LEFT =0 (lift click basically)
				addAction(pointer.createPointerMove(ofMillis(duration), viewport(), start.getX(), start.getY())).
				addAction(pointer.createPointerDown(LEFT.asArg()));
		
		
		//perform the actions
		driver.perform(Arrays.asList(swipe)); // here why Array list is Perform will take it as collection, we have only sequence, it will convert as list for Swipe)
	}

}
