import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
/*** This controller has the listener methods
 * @author Tamás Péter, Michal Pupák, Alexandru Mihail Teodosiu
 * @version 1.0
 * */
public class Controller extends VIAFitSystem
{
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
  private TextField instructorName;
  @FXML
  private TextField instructorAddress;
  @FXML
  private TextField instructorPhone;
  @FXML
  private TextField instructorMail;

  @FXML
  private TextField className;
  @FXML
  private TextField classMemberLimit;

  @FXML
  ObservableList<Member> members = FXCollections.observableArrayList(super.getMemberList().members);
  @FXML
  ObservableList<Instructor> instructorObservableList = FXCollections.observableArrayList(super.getInstructorList().instructors);
  @FXML
  ObservableList<Class> classObservableList = FXCollections.observableArrayList(super.getClassList().classes);

  @FXML
  private ComboBox<Instructor> comboBoxInstructors = new ComboBox<>();

  @FXML
  private TableView<Member> memberTable = new TableView<>();
  @FXML
  private TableColumn<Member, String> nameColumn = new TableColumn<>();
  @FXML
  private TableColumn<Member, String> addressColumn = new TableColumn<>();
  @FXML
  private TableColumn<Member, String> phoneColumn = new TableColumn<>();
  @FXML
  private TableColumn<Member, String> mailColumn = new TableColumn<>();
  @FXML
  private TableColumn<Member, String> membershipColumn = new TableColumn<>();

  @FXML
  private TextField memberProfileName = new TextField();
  @FXML
  private TextField memberProfileAddress = new TextField();
  @FXML
  private TextField memberProfilePhone = new TextField();
  @FXML
  private TextField memberProfileMail = new TextField();
  @FXML
  private CheckBox memberProfileMembership = new CheckBox();

  @FXML
  private TextField instructorProfileName = new TextField();
  @FXML
  private TextField instructorProfileAddress = new TextField();
  @FXML
  private TextField instructorProfilePhone = new TextField();
  @FXML
  private TextField instructorProfileMail = new TextField();
  @FXML
  private TextField instructorProfileClasses = new TextField();


  @FXML
  private TableView<Instructor> instructorTable = new TableView<>();
  @FXML
  private TableColumn<Instructor, String> instructorColumnName = new TableColumn<>();
  @FXML
  private TableColumn<Instructor, String> instructorColumnAddress = new TableColumn<>();
  @FXML
  private TableColumn<Instructor, String> instructorColumnPhone = new TableColumn<>();
  @FXML
  private TableColumn<Instructor, String> instructorColumnMail = new TableColumn<>();
  @FXML
  private TableColumn<Instructor, String> instructorColumnClasses = new TableColumn<>();

  @FXML
  private TableView<Class> classTable = new TableView<>();

  @FXML
  private TableColumn<Class, String> classColumnName = new TableColumn<>();

  @FXML
  private TableColumn<Class, String> classColumnInstructor = new TableColumn<>();

  @FXML
  private TableColumn<Class, String> classColumnMemberLimit = new TableColumn<>();

  @FXML
  private int index;

  @FXML
  private Button memberSaveChanges;
  @FXML
  private Button instructorSaveChanges;

  @FXML
  private TableColumn<Member, String> classProfileMemberColumn = new TableColumn<>();
  @FXML
  private TableColumn<Class, String> classListSignedMembers = new TableColumn<>();

  DataSharing dataSharing = new DataSharing();

  /**
   * Constructor of the controller class. This initializes all of the pages
   */
  public void initialize(){
    nameColumn.setCellValueFactory(new PropertyValueFactory<Member,String>("name"));
    addressColumn.setCellValueFactory(new PropertyValueFactory<Member,String>("address"));
    phoneColumn.setCellValueFactory(new PropertyValueFactory<Member,String>("phoneNumber"));
    mailColumn.setCellValueFactory(new PropertyValueFactory<Member,String>("email"));
    membershipColumn.setCellValueFactory(new PropertyValueFactory<Member,String>("stringMembership"));

    memberTable.setItems(members);

    memberTable.setOnMouseClicked(new EventHandler<MouseEvent>()
    {
      @Override public void handle(MouseEvent mouseEvent)
      {
        try
        {

          if (mouseEvent.getClickCount() == 2){
            if (memberTable.getSelectionModel().getSelectedItem() != null)
            {
              Parent view = FXMLLoader.load(getClass().getResource(
                  "FxmlMemberProfile.fxml"));
              Scene scene = new Scene(view);

              Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

              Member member = memberTable.getSelectionModel().getSelectedItem();
              index = memberTable.getSelectionModel().getSelectedIndex();

              window.setScene(scene);
              window.show();

              TextField m = (TextField)view.lookup("#memberProfileName");
              m.setText(member.getName());
              m = (TextField)view.lookup("#memberProfileAddress");
              m.setText(member.getAddress());
              m = (TextField)view.lookup("#memberProfileMail");
              m.setText(member.getEmail());
              m = (TextField)view.lookup("#memberProfilePhone");
              m.setText(member.getPhoneNumber());
              CheckBox ch = (CheckBox)view.lookup("#memberProfileMembership");

              if (member.isPremiumMember())
              {
                ch.setSelected(true);
              }
              else
              {
                ch.setSelected(false);
              }
            }

          }
        }
        catch (Exception e){
          e.printStackTrace();
        }
      }
    });

    instructorColumnName.setCellValueFactory(new PropertyValueFactory<Instructor, String>("name"));
    instructorColumnAddress.setCellValueFactory(new PropertyValueFactory<Instructor, String>("address"));
    instructorColumnPhone.setCellValueFactory(new PropertyValueFactory<Instructor, String>("phoneNumber"));
    instructorColumnMail.setCellValueFactory(new PropertyValueFactory<Instructor, String>("email"));

    instructorTable.setItems(instructorObservableList);

    instructorTable.setOnMouseClicked(new EventHandler<MouseEvent>()
    {
      @Override public void handle(MouseEvent mouseEvent)
      {
        try
        {

          if (mouseEvent.getClickCount() == 2){
            if (instructorTable.getSelectionModel().getSelectedItem() != null)
            {
              Parent view = FXMLLoader.load(getClass().getResource("FxmlInstructorProfile.fxml"));
              Scene scene = new Scene(view);

              Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

              Instructor instructor = instructorTable.getSelectionModel().getSelectedItem();
              index = instructorTable.getSelectionModel().getSelectedIndex();

              window.setScene(scene);
              window.show();

              TextField m = (TextField) view.lookup("#instructorProfileName");
              m.setText(instructor.getName());
              m = (TextField) view.lookup("#instructorProfileAddress");
              m.setText(instructor.getAddress());
              m = (TextField) view.lookup("#instructorProfileMail");
              m.setText(instructor.getEmail());
              m = (TextField) view.lookup("#instructorProfilePhone");
              m.setText(instructor.getPhoneNumber());
              m = (TextField) view.lookup("#instructorProfileClasses");
            }
          }
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });

    classColumnName.setCellValueFactory(new PropertyValueFactory<Class, String>("className"));
    classColumnInstructor.setCellValueFactory(new PropertyValueFactory<Class, String>("instructor"));
    classColumnMemberLimit.setCellValueFactory(new PropertyValueFactory<Class, String>("maxNumberOfMembers"));
    classListSignedMembers.setCellValueFactory(new PropertyValueFactory<Class, String>("numberOfMembers"));

    classTable.setItems(classObservableList);

    classProfileMemberColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));

    classTable.setOnMouseClicked(new EventHandler<MouseEvent>()
    {
      @Override public void handle(MouseEvent mouseEvent)
      {
        try
        {
          if (mouseEvent.getClickCount() == 2){
            if (classTable.getSelectionModel().getSelectedItem() != null)
            {

              dataSharing.setSelectedClass(classTable.getSelectionModel().getSelectedItem());
              dataSharing.setClassIndex(classTable.getSelectionModel().getSelectedIndex());

              Parent view = FXMLLoader.load(getClass().getResource("FxmlClassProfile.fxml"));
              Scene scene = new Scene(view);
              Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

              index = classTable.getSelectionModel().getSelectedIndex();

              window.setScene(scene);
              window.show();
            }
          }
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Takes the user to the home page
   * @param actionEvent
   * @throws IOException
   */
  public void homeButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
      Parent homeView = FXMLLoader.load(getClass().getResource(
          "FxmlHomeGUI.fxml"));
      Scene homeScene = new Scene(homeView);

      Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      window.setScene(homeScene);
      window.show();

  }

  /**
   * Takes the user to the member list page
   * @param actionEvent
   * @throws IOException
   */
  public void memberButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlMemberList.fxml"));
    Scene homeScene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(homeScene);
    window.show();
  }

  /**
   * Takes the user to the instructor list page
   * @param actionEvent
   * @throws IOException
   */
  public void instructorButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlInstructorList.fxml"));
    Scene homeScene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(homeScene);
    window.show();
  }

  /**
   * Takes the user to the class list page
   * @param actionEvent
   * @throws IOException
   */
  public void classButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlClassList.fxml"));
    Scene homeScene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(homeScene);
    window.show();
  }

  /**
   * Takes the user to the specific member page
   * @param actionEvent
   * @throws IOException
   */
  public void specificMembersButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlSpecificMemberGUI.fxml"));
    Scene scene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(scene);
    window.show();

  }

  /**
   * Takes the user to the specific instructor page
   * @param actionEvent
   * @throws IOException
   */
  public void specificInstructorButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlSpecificInstructorGUI.fxml"));
    Scene scene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(scene);
    window.show();

  }

  /**
   * Takes the user to the specific class page
   * @param actionEvent
   * @throws IOException
   */
  public void specificClassButtonClick(javafx.event.ActionEvent actionEvent) throws IOException
  {
    Parent view = FXMLLoader.load(getClass().getResource(
        "FxmlSpecificClass.fxml"));
    Scene scene = new Scene(view);

    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    window.setScene(scene);
    window.show();

    ComboBox comboBox = (ComboBox)view.lookup("#comboBoxInstructors");
    comboBox.setItems(instructorObservableList);
  }

  /**
   *Saves the member to the member list
   * @param actionEvent
   * @throws Exception
   */
  public void saveMemberListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    if (memberName.getText().isEmpty()||memberAddress.getText().isEmpty()||memberPhone.getText().isEmpty()||memberMail.getText().isEmpty()){
      JOptionPane.showMessageDialog(null, "Please, fill out all text fields");
    }
    else {
      String name = memberName.getText();
      String address = memberAddress.getText();
      String phone = memberPhone.getText();
      String mail = memberMail.getText();
      boolean membership = memberMembership.isSelected();
      super.getMemberList().addMember(new Member(name,address,phone,mail,membership));
      JOptionPane.showMessageDialog(null, "The member was successfully saved.");
      memberButtonClick(actionEvent);
    } }

  /**
   * Saves the edited information of the member
   * @param actionEvent
   * @throws Exception
   */
  public void memberSaveChangesListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    if (memberProfileName.getText().isEmpty()||memberProfileAddress.getText().isEmpty()||memberProfilePhone.getText().isEmpty()||memberProfileMail.getText().isEmpty())
    {
      JOptionPane.showMessageDialog(null, "Please, fill out all text fields");
    }
    else {
      Member member = new Member(memberProfileName.getText(),
          memberProfileAddress.getText(), memberProfilePhone.getText(),memberProfileMail.getText(),memberProfileMembership.isSelected());

      super.getMemberList().setMember(member, index);
      JOptionPane.showMessageDialog(null,"Changes have been saved.");
      memberButtonClick(actionEvent);
    }
  }

  /**
   * Sets the fields editable
   * @param actionEvent
   * @throws Exception
   */
  public void editInformationListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    memberProfileName.setEditable(true);
    memberProfileAddress.setEditable(true);
    memberProfilePhone.setEditable(true);
    memberProfileMail.setEditable(true);
    memberProfileMembership.setDisable(false);
    memberSaveChanges.setDisable(false);

    Member member = new Member(memberProfileName.getText(),
        memberProfileAddress.getText(), memberProfilePhone.getText(),memberProfileMail.getText(),memberProfileMembership.isSelected());

    for (int i = 0; i < super.getMemberList().members.size(); i++){
      if (super.getMemberList().members.get(i).equals(member)){
        index = i;
      }
    }
  }

  /**
   * Deletes the member
   * @param actionEvent
   * @throws Exception
   */
  public void memberDeleteListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    Member member = new Member(memberProfileName.getText(),
        memberProfileAddress.getText(), memberProfilePhone.getText(),memberProfileMail.getText(),memberProfileMembership.isSelected());

    for (int i = 0; i < super.getMemberList().members.size(); i++){
      if (super.getMemberList().members.get(i).equals(member)){
        index = i;
      }
    }
    super.getMemberList().removeMember(index);
    JOptionPane.showMessageDialog(null, "The member was deleted");
    memberButtonClick(actionEvent);
  }

  /**
   * Saves the instructor to the instructor list
   * @param actionEvent
   * @throws Exception
   */
  public void saveInstructorListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    if (instructorName.getText().isEmpty()||instructorAddress.getText().isEmpty()||instructorPhone.getText().isEmpty()||instructorMail.getText().isEmpty()){
      JOptionPane.showMessageDialog(null, "Please, fill out all text fields");
    }
    else {
      String name = instructorName.getText();
      String address = instructorAddress.getText();
      String phone = instructorPhone.getText();
      String mail = instructorMail.getText();
      super.getInstructorList().addInstructor(new Instructor(name,address,phone,mail));
      JOptionPane.showMessageDialog(null, "The instructor was successfully saved.");
      instructorButtonClick(actionEvent);
    }
  }

  /**
   * Sets the fields editable
   * @param actionEvent
   * @throws Exception
   */
  public void editInstructorInformationListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    instructorProfileName.setEditable(true);
    instructorProfileAddress.setEditable(true);
    instructorProfilePhone.setEditable(true);
    instructorProfileMail.setEditable(true);
    instructorSaveChanges.setDisable(false);

    Instructor instructor = new Instructor(instructorProfileName.getText(),
        instructorProfileAddress.getText(), instructorProfilePhone.getText(),instructorProfileMail.getText());

    for (int i = 0; i < super.getInstructorList().instructors.size(); i++){
      if (super.getInstructorList().instructors.get(i).equals(instructor)){
        index = i;
      }
    }
  }

  /**
   * Saves the edited information of an instructor
   * @param actionEvent
   * @throws Exception
   */
  public void instructorSaveChangesListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    if (instructorProfileName.getText().isEmpty()||instructorProfileAddress.getText().isEmpty()||instructorProfilePhone.getText().isEmpty()
        ||instructorProfileMail.getText().isEmpty())
    {
      JOptionPane.showMessageDialog(null, "Please, fill out all text fields");
    }
    else {
      Instructor instructor = new Instructor(instructorProfileName.getText(),
          instructorProfileAddress.getText(), instructorProfilePhone.getText(),instructorProfileMail.getText());

      super.getInstructorList().setInstructor(instructor, index);
      JOptionPane.showMessageDialog(null,"Changes have been saved.");
      instructorButtonClick(actionEvent);
    }
  }

  /**
   * Deletes the member
   * @param actionEvent
   * @throws Exception
   */
  public void instructorDeleteListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    Instructor instructor = new Instructor(instructorProfileName.getText(),
        instructorProfileAddress.getText(), instructorProfilePhone.getText(),instructorProfileMail.getText());

    for (int i = 0; i < super.getInstructorList().instructors.size(); i++){
      if (super.getInstructorList().instructors.get(i).equals(instructor)){
        index = i;
      }
    }
    super.getInstructorList().removeInstructor(index);
    JOptionPane.showMessageDialog(null, "The instructor was deleted");
    instructorButtonClick(actionEvent);
  }

  /**
   * Saves the class to the class list
   * @param actionEvent
   * @throws Exception
   */
  public void saveClassListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    if (className.getText().isEmpty() || comboBoxInstructors.getSelectionModel().isEmpty() || classMemberLimit.getText().isEmpty())
  {
    JOptionPane.showMessageDialog(null, "Please fill out all fields");
  }
    else{
      try
      {
        int memberLimit = Integer.parseInt(classMemberLimit.getText());
        String name = className.getText();
        int selectedInstructor = comboBoxInstructors.getSelectionModel().getSelectedIndex();

        Class aClass = new Class(name, super.getInstructorList().getInstructor(selectedInstructor), memberLimit);
        aClass.setInstructor(super.getInstructorList().getInstructor(selectedInstructor));
        super.getInstructorList().instructors.get(selectedInstructor).addClass(aClass);

       super.getClassList().addClass(aClass);

       JOptionPane.showMessageDialog(null, "The has been registered to the system");
       classButtonClick(actionEvent);
      }
      catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Please enter an integer for member limit");
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
  }

  /**
   * Deletes the class
   * @param actionEvent
   * @throws Exception
   */
  public void deleteClassListener(javafx.event.ActionEvent actionEvent) throws Exception{
    if (classTable.getSelectionModel().getSelectedItem() != null){
      super.getClassList().removeClass(classTable.getSelectionModel().getSelectedItem());
      JOptionPane.showMessageDialog(null, "The class has been deleted");
      classButtonClick(actionEvent);
    }
  }

  /**
   * Deletes the selected member from the member list
   * @param actionEvent
   * @throws Exception
   */
  public void deleteSelectedMemberListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    if (memberTable.getSelectionModel().getSelectedItem() != null){
      super.getMemberList().removeMember(memberTable.getSelectionModel().getSelectedIndex());
      memberButtonClick(actionEvent);
    }
  }


  /**
   * Deletes the selected instructor from the instructor list
   * @param actionEvent
   * @throws Exception
   */
  public void deleteSelectedInstructorListener(javafx.event.ActionEvent actionEvent) throws Exception
  {
    if (instructorTable.getSelectionModel().getSelectedItem() != null){
      super.getInstructorList().removeInstructor(instructorTable.getSelectionModel().getSelectedIndex());
      instructorButtonClick(actionEvent);
    }
  }

  /**
   * Regenerates the xml file for the schedule
   */
  public void updateCalendar(){
    XmlGenerator xmlGenerator = new XmlGenerator();
    ArrayList<Class[][]> allOfTheWeeks;
    allOfTheWeeks = xmlGenerator.generate3DArray(xmlGenerator.getClassList());

    xmlGenerator.generateXml(allOfTheWeeks);
    JOptionPane.showMessageDialog(null, "The calendar has been updated.");
  }
  }
