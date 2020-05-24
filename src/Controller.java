import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller extends VIAFitSystem
{
  @FXML private Button homeButton;
  @FXML private Button membersButton;
  @FXML
  private TextField memberName;

  @FXML
  private TextField memberAddress;

  @FXML
  private TextField memberPhone;

  @FXML
  private TextField memberMail;

  @FXML
  private CheckBox memberMembership;

  @FXML
  private Button memberSave;

  @FXML
  private TextField instructorName;

  @FXML
  private TextField instructorAddress;

  @FXML
  private TextField instructorPhone;

  @FXML
  private TextField instructorMail;

  @FXML
  private Button saveInstructor;

  @FXML
  private ComboBox<?> instructorsComboBox;

  @FXML
  private ListView<String> instructorList;

  @FXML
  private TextField className;

  @FXML
  private TextField classMemberLimit;

  @FXML
  private void initialize(){
    instructorList = new ListView<>();
    instructorList.getItems().add("Option");
  }
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

  public void saveMemberListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    String name = memberName.getText();
    String address = memberAddress.getText();
    String phone = memberPhone.getText();
    String mail = memberMail.getText();
    boolean membership = memberMembership.isSelected();

    super.getMemberList().addMember(new Member(name,address,phone,mail,membership));
    memberButtonClick(actionEvent);
  }

  public void saveInstructorListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    String name = instructorName.getText();
    String address = instructorAddress.getText();
    String phone = instructorPhone.getText();
    String mail = instructorMail.getText();

    super.getInstructorList().addInstructor(new Instructor(name,address,phone,mail));
    instructorButtonClick(actionEvent);
  }

  public void saveClassListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    String name = className.getText();
    int memberLimit = Integer.parseInt(classMemberLimit.getText());
  }

}
