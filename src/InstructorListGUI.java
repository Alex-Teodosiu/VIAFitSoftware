import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InstructorListGUI extends Application
{
  public void start(Stage window) throws IOException
  {
    window.setTitle("VIAFit");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("FxmlInstructorList.fxml"));
    Scene scene = new Scene(loader.load());
    window.setScene(scene);
    window.show();
  }
}
