package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import  java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Log_in_controller implements Initializable {
	@FXML
	private ImageView brandingImageView;
	@FXML
	private Label loginMessageLabel;
	@FXML
	private Button cancelButton;
	@FXML
	private PasswordField enterPasswordField;
	@FXML
	private PasswordField confirmPasswordLabel;
	@FXML
	private ImageView lockImageView;
	@FXML
	private TextField lastnameTextField;
	@FXML
	private TextField usernameTextField;
	
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// TODO Auto-generated method stub
		
		File brandingFile = new File("Images/Bahriauniversitylogo/branding.png");
		Image brandingImage = new Image(brandingFile.toURI().toString());
		brandingImageView.setImage(brandingImage);
		
		File lockFile = new File("Images/Bahriauniversitylogo/lock.png");
		Image lockImage = new Image(lockFile.toURI().toString());
		lockImageView.setImage(lockImage);
	}

	public void loginButtonOnAction(ActionEvent event) {
		if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false){
			validateLogin();

		} else {
			loginMessageLabel.setText("Password does not match");
		}
	}

	public void cancelButtonOnAction(ActionEvent event) {
	  Stage stage = (Stage) cancelButton.getScene().getWindow();
	  stage.close();
	}

	public void validateLogin() {
		DataBaseConnection connectNow = new DataBaseConnection();
		Connection connectDB = connectNow.getConnection();

		String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + usernameTextField.getText()
				+ "' AND password = '" + enterPasswordField.getText() + "'";

		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);
			while (queryResult.next()) {
				if (queryResult.getInt(1) == 1) {
					loginMessageLabel.setText("Congratulations!");
					createAccountForm();
				} else {
					loginMessageLabel.setText("Invalid login. Please try again.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	public void createAccountForm() {
     try {
    	 Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
    	 Stage registerStage = new Stage();
    	 registerStage.initStyle(StageStyle.UNDECORATED);
    	 registerStage.setScene(new Scene(root, 600, 400));
    	 registerStage.show();
    	         } catch (Exception e) {
    	        	 e.printStackTrace();
    	        	 e.getCause();
     }
	}
	
}