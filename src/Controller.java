import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Controller
{
  @FXML private Button homeButton;
  @FXML private Button membersButton;



  public void homeButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
      Parent homeView = FXMLLoader.load(getClass().getResource(
          "FxmlHomeGUI.fxml"));
      Scene homeScene = new Scene(homeView);

      Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

      window.setScene(homeScene);
      window.show();

  }

  public void memberButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlMemberList.fxml"));
    Scene homeScene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(homeScene);
    window.show();
  }

  public void instructorButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlInstructorList.fxml"));
    Scene homeScene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(homeScene);
    window.show();
  }

  public void classButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlClassList.fxml"));
    Scene homeScene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(homeScene);
    window.show();
  }

  public void specificMembersButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlSpecificMemberGUI.fxml"));
    Scene scene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(scene);
    window.show();

  }

  public void specificInstructorButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlSpecificInstructorGUI.fxml"));
    Scene scene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(scene);
    window.show();

  }

  public void specificClassButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlSpecificClass.fxml"));
    Scene scene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(scene);
    window.show();

  }
}
