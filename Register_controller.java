package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import  java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Register_controller implements Initializable {
	@FXML
	private ImageView sheildImageView;
	@FXML
	private Label registrationMessageLabel;
	@FXML
	private Button closeButton;
	@FXML
	private PasswordField setPasswordField;
	@FXML
	private PasswordField confirmPasswordLabel;
	@FXML
	private TextField firstnameTextField;
	@FXML
	private TextField lastnameTextField;
	@FXML
	private TextField usernameTextField;
	
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// TODO Auto-generated method stub
		
		File sheildFile = new File("Images/Bahriauniversitylogo/branding.png");
		Image sheildImage = new Image(sheildFile.toURI().toString());
		sheildImageView.setImage(sheildImage);
	}

	public void registerButtonOnAction(ActionEvent event) {
		if (setPasswordField.getText().equals(confirmPasswordLabel.getText())) {
			confirmPasswordLabel.setText("Password Matched");
			registrationMessageLabel.setText("You have been registered successfully");

		} else {
			confirmPasswordLabel.setText("Password does not match");
		}
		registerUser();
	}

	public void closeButttonOnAction(ActionEvent event) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
		Platform.exit();
	}
	public void registerUser() {
		DataBaseConnection connectNow = new DataBaseConnection();
		Connection connectDB = connectNow.getConnection();
		String firstname = firstnameTextField.getText();
		String lastname = lastnameTextField.getText();
		String username = usernameTextField.getText();
		String password = setPasswordField.getText();
		String insertFields = "";
		String insertValues = "";
		String insertToRegister = insertValues + insertFields;
	}
}
