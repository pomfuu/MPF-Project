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

public class Register extends Application {
	
	BorderPane borderContainer;
	GridPane gridContainer;
	Scene registerScene;
	HBox buttonBox;
	
	String errorMsg;
	Label title, usernameLbl, passwordLbl, confirmPassLbl;
	TextField usernameTF;
	PasswordField passwordTF, confirmPassTF;
	Button loginBT, registerBT;
	
	public void initRegister() {
		
		gridContainer = new GridPane();
		borderContainer = new BorderPane();
		buttonBox = new HBox();
		
		registerScene = new Scene(borderContainer,700,400);
		
		title = new Label("Register");
		title.setFont(Font.font(24));
		title.setStyle("-fx-font-weight: bold");
		
		usernameLbl = new Label("Email");
		passwordLbl = new Label("Password");
		confirmPassLbl = new Label("Confirm Password");
		usernameTF = new TextField();
		passwordTF = new PasswordField();
		confirmPassTF = new PasswordField();

		loginBT = new Button("Login");
		registerBT = new Button("Register");
		registerBT.setStyle("-fx-background-color: #52525b; -fx-text-fill: white;");
		loginBT.setStyle("-fx-background-color: #52525b; -fx-text-fill: white;");
		registerBT.setPrefWidth(100);
		loginBT.setPrefWidth(100);
		buttonBox.getChildren().addAll(loginBT, registerBT);
	
	}
	
	public void addComponentRegister() {
		
		gridContainer.addRow(0, title);
	    GridPane.setColumnSpan(title, GridPane.REMAINING);
		gridContainer.addRow( 1, usernameLbl, usernameTF);
		gridContainer.addRow( 2, passwordLbl, passwordTF);
		gridContainer.addRow( 3, confirmPassLbl, confirmPassTF);
		gridContainer.add(buttonBox, 1, 4);
		
		title.setPadding(new Insets(10));
		GridPane.setHalignment(title, HPos.CENTER);
		gridContainer.setHgap(10);
		gridContainer.setVgap(5);
		buttonBox.setSpacing(5);
		gridContainer.setAlignment(Pos.CENTER);
		borderContainer.setCenter(gridContainer);
	}
	
	public void registerValidation() {
		loginBT.setOnAction(e -> {
			String email = usernameTF.getText();
			String pword = passwordTF.getText();
			String confirmPword = confirmPassTF.getText();
			
			if( email.isEmpty()) {
				Alert em = new Alert(AlertType.ERROR);
				em.setContentText("Email must not be empty");
				em.showAndWait();
			}
			else if( !email.endsWith("@email.com")) {
				Alert em = new Alert(AlertType.ERROR);
				em.setContentText("Email must end with @email.com");
				em.showAndWait();
			}
			else if( email.indexOf("@") != email.lastIndexOf("@")) {
				Alert em = new Alert(AlertType.ERROR);
				em.setContentText("Email must only contains one @");
				em.showAndWait();
			}
			else if( email.charAt(0) == '@' ) {
				Alert em = new Alert(AlertType.ERROR);
				em.setContentText("Email must must no starts with @");
				em.showAndWait();
			}
			else if( email.contains(" ")) {
				Alert em = new Alert(AlertType.ERROR);
				em.setContentText("Email must not contains white space");
				em.showAndWait();
			}
			else if( pword.isEmpty()) {
				Alert pw = new Alert(AlertType.ERROR);
				pw.setContentText("Password must not be empty");
				pw.showAndWait();
			}
			else if( confirmPword.isEmpty()) {
				Alert cpw = new Alert(AlertType.ERROR);
				cpw.setContentText("Confirm Password must not be empty");
				cpw.showAndWait();
			}
			else if( !confirmPword.contains(pword)) {
				Alert cpw = new Alert(AlertType.ERROR);
				cpw.setContentText("Confirm Password must match the password");
				cpw.showAndWait();
			}

		});
	}

	public static void main(String[] app) {
		launch(app);
	}


	@Override
	public void start(Stage stage) throws Exception {
		initRegister();
		addComponentRegister();
		registerValidation();
		stage.setTitle("Register");
		stage.setScene(registerScene);
		stage.show();
		
		loginBT.setOnAction( e -> {
			
			stage.show();
		});
	}
}
