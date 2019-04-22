package application;

import javax.swing.Painter;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.canvas.GraphicsContext;


public class Main extends Application {
	protected BorderPane bpMainMenu = new BorderPane();
	protected HBox hbxTitle = new HBox(10);
	protected VBox vbxMenu = new VBox(10);
	protected VBox vbxGames = new VBox(10);
	protected StackPane spCanvas = new StackPane();
	protected Label lbTitle = new Label("Game Center");
	protected Button pickAGame = new Button("Game Selection");
	protected Button options = new Button("Options");
	protected Button exitWindow = new Button("Exit Window");
	protected Scene scene;
	protected Scene scene2;
	protected int width = 684;
	protected int height = 436;
	protected Canvas games = new Canvas(width, height);
	protected Grid g;
	protected GraphicsContext gc = games.getGraphicsContext2D();
	protected Snake s = new Snake();

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = buildMainFrame("main");
			scene = new Scene(root, 684, 436);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Game Center");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pane buildMainFrame(String word) {
		if(word.equals("main")) {
			bpMainMenu.setId("MainFrame");

			bpMainMenu.setTop(buildTop());
			bpMainMenu.setCenter(buildCenter());
		}
		if(word.equals("games")) {
			bpMainMenu.setCenter(games());
		}
		if(word.equals("canvas")) {
			bpMainMenu.setCenter(gameCanvas());
		}
		return bpMainMenu;
	}
	
	public HBox buildTop() {
		hbxTitle.setId("HBoxTitle");
		
		hbxTitle.managedProperty().bind(hbxTitle.visibleProperty());
		
		lbTitle.setId("StartLabel");
		hbxTitle.getChildren().add(lbTitle);
		
		return hbxTitle;
	}
	
	public VBox buildCenter() {
		vbxMenu.setId("VBoxFrame");
		
		vbxMenu.managedProperty().bind(vbxMenu.visibleProperty());
		
		vbxMenu.getChildren().add(pickAGameButtonBuilder());
		vbxMenu.getChildren().add(optionsBuilder());
		vbxMenu.getChildren().add(exitWindowBuilder());
		
		return vbxMenu;
	}
	
	public VBox games() {
		hbxTitle.setVisible(false);
		vbxMenu.setVisible(false);
		
		ToggleButton snake = new ToggleButton("Snake");
		snake.setId("SnakeHyperlink");
		
		SnakeEventHandler snakeEventHandler = new SnakeEventHandler();
		snake.setOnAction(snakeEventHandler);
		
		vbxGames.getChildren().add(snake);
		vbxGames.setId("VBoxFrame");
		
		return vbxGames;
	}
	
	public StackPane gameCanvas(){
		vbxGames.setVisible(false);
		
		spCanvas.getChildren().add(games);
		spCanvas.setId("GameCanvas");
		
		try {
			
			snake();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Stuff and things arose in the animation error");
		}
		
		return spCanvas;
	}
	public void snake() throws Exception {
		
		new AnimationTimer(){
			@Override
			public void handle(long now) {
				s.update();
				s.show(gc);
				
			}
		}.start();
		
		stop();
	}
/*	
	public void snakeReset() {
		g = new Grid(width, height);
		//g.paint(gc);
		
	}*/
	
	
	public Button pickAGameButtonBuilder() {
		pickAGame.setId("MainButtons");
		
		PickAGameEventHandler pickAGameEventHandler = new PickAGameEventHandler();
		
		pickAGame.setOnAction(pickAGameEventHandler);
		
		return pickAGame;
	}

	public Button optionsBuilder() {
		options.setId("MainButtons");
		
		OptionsEventHandler optionsEventHandler = new OptionsEventHandler();
		
		options.setOnAction(optionsEventHandler);
		
		return options;
	}
	
	public Button exitWindowBuilder() {
		exitWindow.setId("MainButtons");
		
		ExitGameEventHandler exitWindowEventHandler = new ExitGameEventHandler();
		
		exitWindow.setOnAction(exitWindowEventHandler);
		
		return exitWindow;
	}
	
	
	private class PickAGameEventHandler implements EventHandler <ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			System.out.println("pickAGame button has been triggered");

			buildMainFrame("games");
		}
	}
	
	private class OptionsEventHandler implements EventHandler <ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			System.out.println("Options has been triggered");
		}
	}
	
	private class ExitGameEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			System.out.println("ExitWindow has been triggered");
		}
	}
	
	private class SnakeEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			System.out.println("Snake has been pressed");
			
			buildMainFrame("canvas");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
