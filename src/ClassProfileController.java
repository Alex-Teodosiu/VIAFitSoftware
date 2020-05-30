import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class ClassProfileController extends VIAFitSystem
{
  @FXML
  private TextField classProfileName;
  @FXML
  private ComboBox<Instructor> classProfileInstructor;
  @FXML
  private TextField classProfileMemberLimit;
  @FXML
  private TextField classProfileMemberSize;
  @FXML
  private TableView<Member> classProfileMemberTable = new TableView<>();
  @FXML
  private TableColumn<Member, String> classProfileMemberColumn = new TableColumn<>();
  @FXML
  private TableView<Date> classProfileLessonTable = new TableView<>();
  @FXML
  private TableColumn<Date, String> classProfileDateColumn = new TableColumn<>();
  @FXML
  private TableColumn<Date, String> classProfileTimeColumn = new TableColumn<>();
  @FXML
  private ComboBox<Member> classProfilePremiumMembers;
  @FXML
  private Button classProfileSaveChanges;
  @FXML
  private DatePicker classProfileDatePicker;
  @FXML
  private ComboBox<String> classProfileTimeInterval = new ComboBox<>();

  public DataSharing dataSharing = new DataSharing();

  @FXML
  ObservableList<Member> classTableMemberList = FXCollections.observableArrayList(super.getClassList().
      getClass(dataSharing.getClassIndex()).getMembers());
  @FXML
  ObservableList<Date> dateObservableList = FXCollections.observableArrayList(super.getClassList().
      getClass(dataSharing.getClassIndex()).getLessons());
  @FXML
  ObservableList<Member> memberObservableList = FXCollections.observableArrayList(super.getMemberList().getPremiumMembers());
  @FXML
  ObservableList<Instructor> instructorObservableList = FXCollections.observableArrayList(super.getInstructorList().instructors);

  ArrayList<String> timeIntervals = new ArrayList<>(Arrays.asList("8:00 - 10:00", "10:00 - 12:00", "12:00 - 14:00",
      "14:00 - 16:00", "16:00 - 18:00", "18:00 - 20:00"));
  @FXML
  ObservableList<String> observableTimeIntervals = FXCollections.observableArrayList(timeIntervals);

  public void initialize(){
    classProfileName.setText(dataSharing.getSelectedClass().getClassName());
    classProfileMemberLimit.setText(dataSharing.getSelectedClass().getMaxNumberOfMembers()+"");
    classProfileMemberSize.setText(dataSharing.getSelectedClass().getMembers().size()+"");

    classProfilePremiumMembers.setItems(memberObservableList);
    classProfileInstructor.setItems(instructorObservableList);
    classProfileInstructor.getSelectionModel().select(dataSharing.getSelectedClass().getInstructor());

    classProfileMemberColumn.setCellValueFactory(new PropertyValueFactory<Member,String>("name"));
    classProfileMemberTable.setItems(classTableMemberList);

    classProfileDateColumn.setCellValueFactory(new PropertyValueFactory<Date, String>("date"));
    classProfileTimeColumn.setCellValueFactory(new PropertyValueFactory<Date,String>("timeInterval"));
    classProfileLessonTable.setItems(dateObservableList);

    classProfileTimeInterval.setItems(observableTimeIntervals);
  }


  public void homeButtonClick(javafx.event.ActionEvent actionEvent) throws
      IOException
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
  public void setSelectedMember()
  {
    dataSharing.setMember(classProfilePremiumMembers.getSelectionModel().getSelectedItem());
  }

  public void signUpListener()
  {
    if (dataSharing.getMember() != null && classProfilePremiumMembers.getSelectionModel().getSelectedItem() != null){
      if (dataSharing.getSelectedClass().getMembers().size() >= dataSharing.getSelectedClass().getMaxNumberOfMembers()){
        JOptionPane.showMessageDialog(null, "Can not sign up new member because the member list is full");
      }
      else{
        for (int i = 0; i < super.getClassList().classes.size(); i++){
          if (super.getClassList().getClass(dataSharing.getClassIndex()).equals(super.getClassList().getClass(i))){
            super.getClassList().signUpMember(i, dataSharing.getMember());
            break;
          }
        }
        JOptionPane.showMessageDialog(null, "The member has been registered: "+dataSharing.getMember());
      }
    }
  }

  public void removeMemberListener(){
    if (classProfileMemberTable.getSelectionModel().getSelectedItem() != null)
    {
      super.getClassList().removeMember(dataSharing.getClassIndex(),classProfileMemberTable.getSelectionModel().getSelectedItem());
      JOptionPane.showMessageDialog(null, "The selected member has been removed from the class");
    }

  }

  public void addLessonListener(){
    if (classProfileDatePicker.getValue() == null || classProfileTimeInterval.getSelectionModel().getSelectedItem() == null){
      JOptionPane.showMessageDialog(null, "For creating a lesson, a date and a time interval must be selected");
    }
    else{
      LocalDate localDate = classProfileDatePicker.getValue();
      Date date = new Date(localDate.getDayOfMonth(),localDate.getMonthValue(),localDate.getYear(),
          classProfileTimeInterval.getSelectionModel().getSelectedItem());
      super.getClassList().addLesson(dataSharing.getClassIndex(),date);
      JOptionPane.showMessageDialog(null, "The lesson has been created successfully.");
    }
  }

  public void removeLessonListener(){
    if (classProfileLessonTable.getSelectionModel().getSelectedItem() != null){
      super.getClassList().removeLesson(dataSharing.getClassIndex(),classProfileLessonTable.getSelectionModel().getSelectedItem());
      JOptionPane.showMessageDialog(null, "The lesson has been removed.");
    }
  }

  public void saveClassChangesListener(javafx.event.ActionEvent actionEvent){
    if (classProfileName.getText().isEmpty() || classProfileInstructor.getSelectionModel().isEmpty() || classProfileMemberLimit.getText().isEmpty())
    {
      JOptionPane.showMessageDialog(null, "Please fill out all fields");
    }
    else
    {
      try
      {
        int memberLimit = Integer.parseInt(classProfileMemberLimit.getText());
        String name = classProfileName.getText();
        dataSharing.setClassInstructorIndex(classProfileInstructor.getSelectionModel().getSelectedIndex());
        Class newClass = new Class(name, super.getInstructorList().getInstructor(dataSharing.getClassInstructorIndex()), memberLimit);
        newClass.setMembers(dataSharing.getSelectedClass().getMembers());
        newClass.setLessons(dataSharing.getSelectedClass().getLessons());
        super.getClassList().setClass(newClass, dataSharing.getClassIndex());
        JOptionPane.showMessageDialog(null, "The changes has been saved");
        classButtonClick(actionEvent);
      }
      catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Please enter an integer for member limit");
      }
      catch (IOException e){
        e.printStackTrace();
      }
    }
  }
  public void editClassListener(javafx.event.ActionEvent actionEvent){
    classProfileName.setDisable(false);
    classProfileInstructor.setDisable(false);
    classProfileMemberLimit.setDisable(false);
    classProfileSaveChanges.setDisable(false);
  }
  public void deleteProfileClassListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
      super.getClassList().removeClass(dataSharing.getSelectedClass());
      JOptionPane.showMessageDialog(null, "The class has been deleted");
      classButtonClick(actionEvent);
    }
  }

