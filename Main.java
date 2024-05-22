package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
     Parent root = FXMLLoader.load(getClass().getResource("Log_in.fxml"));
     primaryStage.initStyle(StageStyle.UNDECORATED);
     primaryStage.setScene(new Scene(root, 600, 400));
     primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
