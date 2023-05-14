package mainPackage;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	BorderPane borderContainer;
	GridPane gridContainer;
	Scene loginScene;
	HBox buttonBox;
	
	String errorMsg;
	Label title, usernameLbl, passwordLbl;
	TextField usernameTF;
	PasswordField passwordTF;
	Button loginBT, registerBT;
	
	public void initLogin() {
		
		gridContainer = new GridPane();
		borderContainer = new BorderPane();
		buttonBox = new HBox();
		
		loginScene = new Scene(borderContainer,700,400);
		
		title = new Label("Jee Keyboard Store");
		title.setFont(Font.font(24));
		title.setStyle("-fx-font-weight: bold");
		
		usernameLbl = new Label("Email");
		passwordLbl = new Label("Password");
		usernameTF = new TextField();
		passwordTF = new PasswordField();

		registerBT = new Button("Register");
		loginBT = new Button("Login");
		registerBT.setStyle("-fx-background-color: #52525b; -fx-text-fill: white;");
		loginBT.setStyle("-fx-background-color: #52525b; -fx-text-fill: white;");
		registerBT.setPrefWidth(100);
		loginBT.setPrefWidth(100);
		buttonBox.getChildren().addAll(registerBT, loginBT);
	
	}
	
	public void addComponentLogin() {
		
		gridContainer.addRow(0, title);
	    GridPane.setColumnSpan(title, GridPane.REMAINING);
		gridContainer.addRow( 1, usernameLbl, usernameTF);
		gridContainer.addRow( 2, passwordLbl, passwordTF);
		gridContainer.add(buttonBox, 1, 3);
		
		title.setPadding(new Insets(10));
		GridPane.setHalignment(title, HPos.CENTER);
		gridContainer.setHgap(10);
		gridContainer.setVgap(5);
		buttonBox.setSpacing(5);
		gridContainer.setAlignment(Pos.CENTER);
		borderContainer.setCenter(gridContainer);
	}
	
	public void loginValidation() {
		loginBT.setOnAction(e -> {
			String uname = usernameTF.getText();
			String pword = passwordTF.getText();
			
			if( uname.isEmpty()) {
				Alert un = new Alert(AlertType.ERROR);
				un.setContentText("Email must not be empty");
				un.showAndWait();
			}
			else if( pword.isEmpty()) {
				Alert pw = new Alert(AlertType.ERROR);
				pw.setContentText("Password must not be empty");
				pw.showAndWait();
			}
		});
	}

	public static void main(String[] app) {
		launch(app);
	}

	@Override
	public void start(Stage stage) throws Exception {
		initLogin();
		addComponentLogin();
		loginValidation();
		stage.setTitle("Login");
		stage.setScene(loginScene);
		stage.show();
	}

	public Scene getScene() {
		return loginScene;
	}
	
}
