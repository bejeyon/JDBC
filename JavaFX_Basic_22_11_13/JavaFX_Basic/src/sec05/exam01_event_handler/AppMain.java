package sec05.exam01_event_handler;

import javafx.application.Application;/*
Class Application
java.lang.Object
javafx.application.Application
Direct Known Subclasses:
Preloader

public abstract class Application
extends Object
Application class from which JavaFX applications extend.
Life-cycle

The entry point for JavaFX applications is the Application class. The JavaFX runtime does the following, in order, whenever an application is launched:

Constructs an instance of the specified Application class
Calls the init() method
Calls the start(javafx.stage.Stage) method
Waits for the application to finish, which happens when either of the following occur:
the application calls Platform.exit()
the last window has been closed and the implicitExit attribute on Platform is true
Calls the stop() method
Note that the start method is abstract and must be overridden. The init and stop methods have concrete implementations that do nothing.

Calling Platform.exit() is the preferred way to explicitly terminate a JavaFX Application. Directly calling System.exit(int) is an acceptable alternative, but doesn't allow the Application stop() method to run.

A JavaFX Application should not attempt to use JavaFX after the FX toolkit has terminated or from a ShutdownHook, that is, after the stop() method returns or System.exit(int) is called.
*/
import javafx.event.ActionEvent;/*
Class ActionEvent
java.lang.Object
java.util.EventObject
javafx.event.Event
javafx.event.ActionEvent
All Implemented Interfaces:
Serializable, Cloneable
Direct Known Subclasses:
MediaMarkerEvent

public class ActionEvent
extends Event
An Event representing some type of action. This event type is widely used to represent a variety of things, such as when a Button has been fired, when a KeyFrame has finished, and other such usages.
*/
import javafx.event.EventHandler;/*
Interface EventHandler<T extends Event>
Type Parameters:
T - the event class this handler can handle
All Superinterfaces:
EventListener
All Known Implementing Classes:
WeakEventHandler
Functional Interface:
This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.

@FunctionalInterface
public interface EventHandler<T extends Event>
extends EventListener
Handler for events of a specific class / type.
*/
import javafx.geometry.Pos;/*
Enum Pos
java.lang.Object
java.lang.Enum<Pos>
javafx.geometry.Pos
All Implemented Interfaces:
Serializable, Comparable<Pos>

public enum Pos
extends Enum<Pos>
A set of values for describing vertical and horizontal positioning and alignment.
*/
import javafx.scene.Scene;/*
Class Scene
java.lang.Object
javafx.scene.Scene
All Implemented Interfaces:
EventTarget

@DefaultProperty(value="root")
public class Scene
extends Object
implements EventTarget
The JavaFX Scene class is the container for all content in a scene graph. The background of the scene is filled as specified by the fill property.
The application must specify the root Node for the scene graph by setting the root property. If a Group is used as the root, the contents of the scene graph will be clipped by the scene's width and height and changes to the scene's size (if user resizes the stage) will not alter the layout of the scene graph. If a resizable node (layout Region or Control is set as the root, then the root's size will track the scene's size, causing the contents to be relayed out as necessary.

The scene's size may be initialized by the application during construction. If no size is specified, the scene will automatically compute its initial size based on the preferred size of its content. If only one dimension is specified, the other dimension is computed using the specified dimension, respecting content bias of a root.

An application may request depth buffer support or scene anti-aliasing support at the creation of a Scene. A scene with only 2D shapes and without any 3D transforms does not need a depth buffer nor scene anti-aliasing support. A scene containing 3D shapes or 2D shapes with 3D transforms may use depth buffer support for proper depth sorted rendering; to avoid depth fighting (also known as Z fighting), disable depth testing on 2D shapes that have no 3D transforms. See depthTest for more information. A scene with 3D shapes may enable scene anti-aliasing to improve its rendering quality.

The depthBuffer and antiAliasing flags are conditional features. With the respective default values of: false and SceneAntialiasing.DISABLED. See ConditionalFeature.SCENE3D for more information.

A default headlight will be added to a scene that contains one or more Shape3D nodes, but no light nodes. This light source is a Color.WHITE PointLight placed at the camera position.

Scene objects must be constructed and modified on the JavaFX Application Thread.
*/
import javafx.scene.control.Button;/*
Class Button
java.lang.Object
javafx.scene.Node
javafx.scene.Parent
javafx.scene.layout.Region
javafx.scene.control.Control
javafx.scene.control.Labeled
javafx.scene.control.ButtonBase
javafx.scene.control.Button
All Implemented Interfaces:
Styleable, EventTarget, Skinnable

public class Button
extends ButtonBase
A simple button control. The button control can contain text and/or a graphic. A button control has three different modes

Normal: A normal push button.
Default: A default Button is the button that receives a keyboard VK_ENTER press, if no other node in the scene consumes it.
Cancel: A Cancel Button is the button that receives a keyboard VK_ESC press, if no other node in the scene consumes it.
When a button is pressed and released a ActionEvent is sent. Your application can perform some action based on this event by implementing an EventHandler to process the ActionEvent. Buttons can also respond to mouse events by implementing an EventHandler to process the MouseEvent

MnemonicParsing is enabled by default for Button.
*/
import javafx.scene.layout.HBox;/*
Class HBox
java.lang.Object
javafx.scene.Node
javafx.scene.Parent
javafx.scene.layout.Region
javafx.scene.layout.Pane
javafx.scene.layout.HBox
All Implemented Interfaces:
Styleable, EventTarget

public class HBox
extends Pane
HBox lays out its children in a single horizontal row. If the hbox has a border and/or padding set, then the contents will be layed out within those insets.
*/
import javafx.stage.Stage;/*
Class Stage
java.lang.Object
javafx.stage.Window
javafx.stage.Stage
All Implemented Interfaces:
EventTarget

public class Stage
extends Window
The JavaFX Stage class is the top level JavaFX container. The primary Stage is constructed by the platform. Additional Stage objects may be constructed by the application.
Stage objects must be constructed and modified on the JavaFX Application Thread.

Many of the Stage properties are read only because they can be changed externally by the underlying platform and therefore must not be bindable.
*/

public class AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {/*
	start
		public abstract void start(Stage primaryStage)
		                    throws Exception
		The main entry point for all JavaFX applications. The start method is called after the init method has returned, and after the system is ready for the application to begin running.
		NOTE: This method is called on the JavaFX Application Thread.
		
		Parameters:
		primaryStage - the primary stage for this application, onto which the application scene can be set. The primary stage will be embedded in the browser if the application was launched as an applet. Applications may create other stages, if needed, but they will not be primary stages and will not be embedded in the browser.
		Throws:
		Exception
	
	public class Stage
		extends Window
		The JavaFX Stage class is the top level JavaFX container. The primary Stage is constructed by the platform. Additional Stage objects may be constructed by the application.
		Stage objects must be constructed and modified on the JavaFX Application Thread.
		
		Many of the Stage properties are read only because they can be changed externally by the underlying platform and therefore must not be bindable.
	*/
		HBox root = new HBox();/*
		public class HBox
			extends Pane
			HBox lays out its children in a single horizontal row. If the hbox has a border and/or padding set, then the contents will be layed out within those insets.
		*/
		root.setPrefSize(200, 50);/*HBox Methods inherited from class javafx.scene.layout.Region
		setPrefSize
			public void setPrefSize(double prefWidth,
			                        double prefHeight)
			Convenience method for overriding the region's computed preferred width and height. This should only be called if the region's internally computed preferred size doesn't meet the application's layout needs.
			Parameters:
			prefWidth - the override value for preferred width
			prefHeight - the override value for preferred height
		*/
		root.setAlignment(Pos.CENTER);/*
		setAlignment
			public final void setAlignment(Pos value)
			Sets the value of the property alignment.
			Property description:
			The overall alignment of children within the hbox's width and height.
		*/
		root.setSpacing(20);/*
		setSpacing
			public final void setSpacing(double value)
			Sets the value of the property spacing.
			Property description:
			The amount of horizontal space between each child in the hbox.
		*/
		Button btn1 = new Button("버튼1");/*Button(String text)	Creates a button with the specified text as its label.
		public class Button
			extends ButtonBase
			A simple button control. The button control can contain text and/or a graphic. A button control has three different modes
			
			Normal: A normal push button.
			Default: A default Button is the button that receives a keyboard VK_ENTER press, if no other node in the scene consumes it.
			Cancel: A Cancel Button is the button that receives a keyboard VK_ESC press, if no other node in the scene consumes it.
			When a button is pressed and released a ActionEvent is sent. Your application can perform some action based on this event by implementing an EventHandler to process the ActionEvent. Buttons can also respond to mouse events by implementing an EventHandler to process the MouseEvent
			
			MnemonicParsing is enabled by default for Button.
		*/
		//버튼에 이벤트핸들러 생성 및 등록
		btn1.setOnAction(new EventHandler<ActionEvent>() {//Button Methods inherited from class javafx.scene.control.ButtonBase
		/*
		setOnAction
			public final void setOnAction(EventHandler<ActionEvent> value)
			Sets the value of the property onAction.
			Property description:
			The button's action, which is invoked whenever the button is fired. This may be due to the user clicking on the button with the mouse, or by a touch event, or by a key press, or if the developer programmatically invokes the fire() method.
		 */
			@Override
			public void handle(ActionEvent event) {/*
			handle
				void handle(T event)
				Invoked when a specific event of the type for which this handler is registered happens.
				Parameters:
				event - the event which occurred
			*/
				System.out.println("버튼1 클릭");
			}//end handle
		});//end setOnAction
		
		Button btn2 = new Button("버튼2");
		//람다식으로 이벤트 처리
		btn2.setOnAction(event->System.out.println("버튼2 클릭"));
		
		root.getChildren().addAll(btn1, btn2);/*
		getChildren
			public ObservableList<Node> getChildren()
			Description copied from class: Parent
			Gets the list of children of this Parent.
			See the class documentation for Node for scene graph structure restrictions on setting a Parent's children list. If these restrictions are violated by a change to the list of children, the change is ignored and the previous value of the children list is restored. An IllegalArgumentException is thrown in this case.
			
			If this Parent node is attached to a Scene attached to a Window that is showning (Window.isShowing()), then its list of children must only be modified on the JavaFX Application Thread. An IllegalStateException is thrown if this restriction is violated.
			
			Note to subclasses: if you override this method, you must return from your implementation the result of calling this super method. The actual list instance returned from any getChildren() implementation must be the list owned and managed by this Parent. The only typical purpose for overriding this method is to promote the method to be public.
			
			Overrides:
			getChildren in class Parent
			Returns:
			modifiable list of children.
			
		addAll
			boolean addAll(E... elements)
			A convenient method for var-arg adding of elements.
			Parameters:
			elements - the elements to add
			Returns:
			true (as specified by Collection.add(E))
		*/
		Scene scene = new Scene(root);//Scene(Parent root)	Creates a Scene for a specific root Node.
		primaryStage.setTitle("AppMain");/*
		setTitle
			public final void setTitle(String value)
			Sets the value of the property title.
			Property description:
			Defines the title of the Stage.
			Default value:
			empty string
		*/
		primaryStage.setScene(scene);/*
		setScene
			public final void setScene(Scene value)
			Specify the scene to be used on this stage.
			Overrides:
			setScene in class Window
		*/
		//종료시 이벤트 등록
		primaryStage.setOnCloseRequest(event->System.out.println("종료 클릭"));/*Stage Methods inherited from class javafx.stage.Window
		setOnCloseRequest
			public final void setOnCloseRequest(EventHandler<WindowEvent> value)
			Sets the value of the property onCloseRequest.
			Property description:
			Called when there is an external request to close this Window. The installed event handler can prevent window closing by consuming the received event.
		*/
		primaryStage.show();/*
		show
			public final void show()
			Description copied from class: Window
			Attempts to show this Window by setting visibility to true
			Overrides:
			show in class Window
		*/
	}//end start
	
	public static void main(String[] args) {
		launch(args);/*
		aunch
			public static void launch(String... args)
			Launch a standalone application. This method is typically called from the main method(). It must not be called more than once or an exception will be thrown. This is equivalent to launch(TheClass.class, args) where TheClass is the immediately enclosing class of the method that called launch. It must be a subclass of Application or a RuntimeException will be thrown.
			The launch method does not return until the application has exited, either via a call to Platform.exit or all of the application windows have been closed.
			
			Typical usage is:
			
			 public static void main(String[] args) {
			     Application.launch(args);
			 }
			 
			Parameters:
			args - the command line arguments passed to the application. An application may get these parameters using the getParameters() method.
			Throws:
			IllegalStateException - if this method is called more than once.
		*/
	}//end main
}//end class
