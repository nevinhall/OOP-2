package view;

import java.sql.SQLException;

import controller.controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.Name;
import model.Student;

public class view extends Popup {
	Button addStudentGroupButton = new Button();
	Button removeStudentGroupButton = new Button();
	Button removeClassGroupButton = new Button();
	Button removeStudentfromClassGroupButton = new Button();

	Button 	viewStudentSideButton = new Button();
	Button  viewClassGroupSideButton = new Button();

	Button  EditTeacherButton = new Button();



	TextField searchClassGroup = new TextField();
	Label currentStudentsInClassGroup = new Label();

	Label currentTeacher = new Label();
	Label currentStudents = new Label();
	Label teacherlist = new Label();
	Label studentlist = new Label();

	TextField fNameTextField  = new TextField();
	TextField mNameTextField  = new TextField();
	TextField lNameTextField  = new TextField();

	TextField dobTextField  = new TextField();
	TextField emailAddressTextField  = new TextField();
	TextField phoneTextField = new TextField();

	TextField addclassGroupTextField = new TextField();
	boolean switchfunction = false;

	//break


	//break



	public view(VBox addRemoveVbox,HBox listAllStudentsHbox,VBox listAllTeacherVbox, HBox addRemoveButtonContainer ) throws SQLException{
		//Left side 
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		addStudentGroupButton.setEffect(ds);
		removeStudentGroupButton.setEffect(ds);
		removeClassGroupButton.setEffect(ds);
		removeStudentfromClassGroupButton.setEffect(ds);


		viewStudentSideButton.setEffect(ds);
		viewClassGroupSideButton.setEffect(ds);

		EditTeacherButton.setEffect(ds);

		searchClassGroup.setEffect(ds);
		currentStudentsInClassGroup.setEffect(ds);

		currentTeacher.setEffect(ds);
		currentStudents.setEffect(ds);
		teacherlist.setEffect(ds);
		studentlist.setEffect(ds);

		fNameTextField.setEffect(ds);
		//fNameTextField
		//fNameTextField.setStyle("");
		mNameTextField.setEffect(ds); 
		mNameTextField.setEffect(ds);
		lNameTextField.setEffect(ds); 

		dobTextField.setEffect(ds);
		dobTextField.setEffect(ds);
		emailAddressTextField.setEffect(ds);
		emailAddressTextField.setEffect(ds);
		phoneTextField.setEffect(ds);

		addclassGroupTextField.setEffect(ds);
		viewStudentSideButton.setEffect(ds);
		viewClassGroupSideButton.setEffect(ds);

		removeClassGroupButton.setEffect(ds);
		removeStudentGroupButton.setEffect(ds);
		removeStudentfromClassGroupButton.setEffect(ds);
		addStudentGroupButton.setEffect(ds);

		currentStudents.setEffect(ds);



		//breaak


		addStudentGroupButton.setFont(Font.font ("Verdana", FontWeight.BOLD, 15));
		removeStudentGroupButton.setFont(Font.font ("Verdana", FontWeight.BOLD,15));
		removeClassGroupButton.setFont(Font.font ("Verdana", FontWeight.BOLD, 15));
		removeStudentfromClassGroupButton.setFont(Font.font ("Verdana", FontWeight.BOLD, 15));

		viewStudentSideButton.setFont(Font.font ("Verdana", FontWeight.BOLD, 15));
		viewClassGroupSideButton.setFont(Font.font ("Verdana", FontWeight.BOLD, 15));

		EditTeacherButton.setFont(Font.font ("Verdana", FontWeight.BOLD, 15)); 

		searchClassGroup.setFont(Font.font ("Verdana", 15)); 
		currentStudentsInClassGroup.setFont(Font.font ("Verdana", 15));

		currentTeacher.setFont(Font.font ("Verdana", 15)); 
		currentStudents.setFont(Font.font ("Verdana", 15)); 
		teacherlist.setFont(Font.font ("Verdana", 15));
		studentlist.setFont(Font.font ("Verdana", 15));

		fNameTextField.setFont(Font.font ("Verdana", 15)); 
		//fNameTextField
		//fNameTextField.setStyle("");
		mNameTextField.setFont(Font.font ("Verdana", 15));  
		mNameTextField.setStyle("-fx-background-color: black; -fx-text-inner-color: white");
		lNameTextField.setFont(Font.font ("Verdana", 15));  

		dobTextField.setFont(Font.font ("Verdana", 15));
		dobTextField.setStyle("-fx-background-color: black; -fx-text-inner-color: white");
		emailAddressTextField.setFont(Font.font ("Verdana", 15));
		emailAddressTextField.setStyle("-fx-background-color: black; -fx-text-inner-color: white");
		phoneTextField.setFont(Font.font ("Verdana", 15)); 

		addclassGroupTextField.setFont(Font.font ("Verdana", 15)); 
		viewStudentSideButton.setText("Student");
		viewClassGroupSideButton.setText("Class Groups");

		removeClassGroupButton.setText("Remove Class Group");
		removeStudentGroupButton.setText("Remove Student");
		removeStudentfromClassGroupButton.setText("Remove Student From Class Group");
		addStudentGroupButton.setText("Add");

		currentStudents.setText("Current Students");


		addRemoveButtonContainer.getChildren().add(viewStudentSideButton);
		addRemoveButtonContainer.getChildren().add(viewClassGroupSideButton);

		addRemoveButtonContainer.getChildren().add(addStudentGroupButton);
		addRemoveButtonContainer.getChildren().add(removeStudentGroupButton);
		addRemoveButtonContainer.getChildren().add(removeClassGroupButton);	
		addRemoveButtonContainer.getChildren().add(removeStudentfromClassGroupButton);

		addRemoveVbox.getChildren().add(addRemoveButtonContainer);

		//Studentinfo
		fNameTextField.setText("Enter First Name");
		mNameTextField.setText("Enter Middle Name"); 
		lNameTextField.setText("Enter Last Name");
		dobTextField.setText("Enter d.o.b");
		emailAddressTextField.setText("Enter EmailAddress");  
		phoneTextField.setText("Enter Phone Number");

		//classGroup
		addclassGroupTextField.setText("Enter Class Group Name");
		addclassGroupTextField.setVisible(false);
		addRemoveVbox.getChildren().add(addclassGroupTextField);

		addRemoveVbox.getChildren().add(emailAddressTextField);
		addRemoveVbox.getChildren().add(fNameTextField);
		addRemoveVbox.getChildren().add(mNameTextField);
		addRemoveVbox.getChildren().add(lNameTextField);
		addRemoveVbox.getChildren().add(dobTextField);
		addRemoveVbox.getChildren().add(phoneTextField);
		addRemoveVbox.getChildren().add(currentStudents);




		//Center
		searchClassGroup.setText("Enter Class Group");
		listAllStudentsHbox.getChildren().add(searchClassGroup);
		listAllStudentsHbox.getChildren().add(currentStudentsInClassGroup);

		//Right
		currentTeacher.setText("Current Teachers");
		EditTeacherButton.setText("Edit");
		listAllTeacherVbox.getChildren().add(currentTeacher);
		listAllTeacherVbox.getChildren().add(EditTeacherButton);



		controller controller = new controller();
		
		
		


		listAllTeacherVbox.getChildren().add(teacherlist = controller.printTeacherController());
		addRemoveVbox.getChildren().add(studentlist);

		//DisplayFields accordingly
		viewClassGroupSideButton.setOnAction((event) -> {
			addclassGroupTextField.setVisible(true);

			fNameTextField.setVisible(false);
			mNameTextField.setVisible(false);
			lNameTextField.setVisible(false);
			dobTextField.setVisible(false);
			emailAddressTextField.setVisible(true);
			phoneTextField.setVisible(false);

		});


		viewStudentSideButton.setOnAction((event) -> {
			addclassGroupTextField.setVisible(false);
			switchfunction = true;
			fNameTextField.setVisible(true);
			mNameTextField.setVisible(true);
			lNameTextField.setVisible(true);
			dobTextField.setVisible(true);
			emailAddressTextField.setVisible(true);
			phoneTextField.setVisible(true);

		});



		EditTeacherButton.setOnAction((event) -> {



			VBox addTeacherVbox = new VBox();
			VBox RemoveTeacherVbox = new VBox();
			VBox setDegreeTeacherVbox = new VBox();


			VBox addStudentModuleVbox = new VBox();

			try {
				ViewPopUp popUpView = new   ViewPopUp(setDegreeTeacherVbox,RemoveTeacherVbox,addTeacherVbox,addStudentModuleVbox );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Label secondLabel = new Label("Hello");

			BorderPane secondaryLayout = new BorderPane ();

			secondaryLayout.setRight(addStudentModuleVbox);
			secondaryLayout.setLeft(addTeacherVbox);

			//			secondaryLayout.getChildren().add(secondLabel);
			secondaryLayout.getChildren().add(setDegreeTeacherVbox);
			secondaryLayout.getChildren().add(RemoveTeacherVbox);
			//secondaryLayout.getChildren().add(addTeacherVbox);
			//secondaryLayout.getChildren().add(addStudentModuleVbox);




			Scene secondScene = new Scene(secondaryLayout, 800, 500, Color.WHITE);

			Stage secondStage = new Stage();
			secondStage.setTitle("Second Stage");
			secondStage.setScene(secondScene);
			secondStage.show();




		});

		removeStudentfromClassGroupButton.setOnAction((event) -> {
			String emailAddress =  emailAddressTextField.getText();
			String  classGroupName = addclassGroupTextField.getText();

			try {
				controller.removeStudentClassGroupController(classGroupName, emailAddress);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		});


		//Add a Student


		String GroupName = "";

		addStudentGroupButton.setOnAction((event) -> {
			String classGroupName = "";
			//	GroupName = classGroupName;
			if(switchfunction == true) {
				addclassGroupTextField.setVisible(false);

				String fName = fNameTextField.getText();
				String mName = mNameTextField.getText();
				String lName =  lNameTextField.getText();
				String emailAddress =  emailAddressTextField.getText();

				int dob =  Integer.parseInt(dobTextField.getText());
				int phone = Integer.parseInt(phoneTextField.getText());

				if( mName == null || mName == "") {
					Name StudentName =  new Name(fName, lName);
					Student student = new Student(emailAddress, phone, StudentName, dob);
					try {
						controller.addStudentController(student);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//System.out.println(student);
				}else { 
					Name StudentNameFull =  new Name(fName, mName, lName);
					Student student = new Student(emailAddress, phone, StudentNameFull, dob);
					try {
						controller.addStudentController(student);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println(student);

				}
			}else {

				classGroupName = addclassGroupTextField.getText();
				controller.addClassGroupController(classGroupName);
				//System.out.println("IM TRYING TO REMOVE" +classGroupName );

			}


		});

		emailAddressTextField.setOnKeyPressed((event) -> {
			if(event.getCode().equals(
					KeyCode.ENTER) 
					) {
				String  classGroupName = addclassGroupTextField.getText();
				String emailAddress = emailAddressTextField.getText();
				System.out.println("PRINT CLASS GROUP NAME"+ classGroupName );
				try {
					controller.addStudentClassGroupController(classGroupName, emailAddress);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		




		removeStudentGroupButton.setOnAction((event) -> {
			String classGroupName = addclassGroupTextField.getText();
			System.out.println("SWITCH FUNCTION " +  switchfunction );

			String emailAddress =  emailAddressTextField.getText();
			controller.removeStudentController(emailAddress);


			//controller.removeClassGroupController(classGroupName);

			//			if(addclassGroupTextField.getText().equals(null) || addclassGroupTextField.getText().equals("") ) {
			//				String emailAddress = emailAddressTextField.getText();
			//			
			//				}
			//			}

		});

		//		searchClassGroup.setOnKeyPressed((event) -> {
		//
		//			if(event.getCode().equals(
		//					KeyCode.ENTER) 
		//					) {
		//				String name = searchClassGroup.getText();
		//				currentStudentsInClassGroup.setText(controller.returnClassGroupStudentsController(name));
		//				System.out.println("please work for");
		//				System.out.println("current students are " + controller.returnClassGroupStudentsController(name));
		//			}
		//		});

		searchClassGroup.setOnKeyPressed((event) -> {

			if(event.getCode().equals(
					KeyCode.ENTER) 
					) {
				String name = searchClassGroup.getText();
				currentStudentsInClassGroup.setText(controller.printStudentClassGroupController(name));
				System.out.println("please work for");
				System.out.println("current students are " + controller.returnClassGroupStudentsController(name));
			}
		});

		removeClassGroupButton.setOnAction((event) -> {
			String  classGroupName = addclassGroupTextField.getText();
			System.out.println("IM TRYING TO REMOVE" +classGroupName );
			controller.removeClassGroupController(classGroupName);

		});

		
		studentlist.setText(controller.printStudentController());


	}



}
