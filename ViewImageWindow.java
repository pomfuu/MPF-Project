package mainPackage;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class ViewImageWindow extends Application{

	Scene scene;
	BorderPane borderContainer;
	Label title;
	Image image;
	ImageView imageView;
	int width = 400 , height = 200 ;
	Button zoomIn, zoomOut, rotateRight, rotateLeft;
	HBox buttonContainer;
		
	public void initComp() {
		borderContainer = new BorderPane();

		image = new Image("keyboard1.png");
		imageView = new ImageView(image);
		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		imageView.setPreserveRatio(true);
		borderContainer.setCenter(imageView);

		zoomIn = new Button("Zoom In");
		zoomOut = new Button("Zoom Out");
		rotateRight = new Button("Rotate Right");
		rotateLeft = new Button("Rotate Left");
		
		zoomIn.setPrefWidth(100);
		zoomOut.setPrefWidth(100);
		rotateRight.setPrefWidth(100);
		rotateLeft.setPrefWidth(100);
		
		buttonContainer = new HBox(zoomIn,zoomOut,rotateRight,rotateLeft);
		buttonContainer.setSpacing(5);
		borderContainer.setBottom(buttonContainer);
		buttonContainer.setAlignment(Pos.CENTER);
		
		scene = new Scene(borderContainer,500,500);
	}

	public static void main(String[] app) {
		launch(app);

	}
	
	public void actionButton() {
		
		rotateRight.setOnAction( e -> {
			Rotate rotate = new Rotate(90);
			rotate.setPivotX(imageView.getBoundsInLocal().getWidth()/2);
			rotate.setPivotY(imageView.getBoundsInLocal().getHeight()/2);
			imageView.getTransforms().add(rotate);
		});
		
		rotateLeft.setOnAction( e -> {
			Rotate rotate = new Rotate(-90);
			rotate.setPivotX(imageView.getBoundsInLocal().getWidth()/2);
			rotate.setPivotY(imageView.getBoundsInLocal().getHeight()/2);
			imageView.getTransforms().add(rotate);
		});
		
		zoomIn.setOnAction( e -> {
			Scale scale = new Scale();
			scale.setPivotX(imageView.getBoundsInLocal().getWidth()/2);
			scale.setPivotY(imageView.getBoundsInLocal().getHeight()/2);
			scale.setX(1.2);
			scale.setY(1.2);
			imageView.getTransforms().add(scale);
		});
		
		zoomOut.setOnAction( e -> {
			Scale scale = new Scale();
			scale.setPivotX(imageView.getBoundsInLocal().getWidth()/2);
			scale.setPivotY(imageView.getBoundsInLocal().getHeight()/2);
			scale.setX(0.8);
			scale.setY(0.8);
			imageView.getTransforms().add(scale);
		});
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		initComp();
		actionButton();
		stage.setTitle("View Image");
		stage.setScene(scene);
		stage.show();
	}

}
