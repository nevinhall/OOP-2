package view;

import java.sql.SQLException;

import controller.ControllerPopUp;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Name;
import model.Teacher;

public class ViewPopUp {
	Label AddNewTeacherLabel = new Label();
	Label editTeacherLabel = new Label();
	Label removeTeacherLabel = new Label();
	Label emptyLabel = new Label();
	Label emptyLabel2 = new Label();

	Button addTeacher = new Button();
	Button editTeacherDegreeButton = new Button();
	Button removeTeacher = new Button();
	Button addModuleButton = new Button();
	Button editModuleButton = new Button();

	TextField teacherfNameTextField  = new TextField();
	TextField teachermNameTextField  = new TextField();
	TextField teacherlNameTextField  = new TextField();

	TextField teacherphoneTextField  = new TextField();
	TextField teacheremailAddressTextField  = new TextField();
	TextField teacherdegreeTextField = new TextField();

	TextField editteacherdegreeTextField = new TextField();
	TextField editteacheremailAddressTextField = new TextField();

	TextField addModuleStudentEmailTextField = new TextField();
	TextField addModuleNameTextField = new TextField();
	TextField addModuleGradeTextField = new TextField();

	TextField editStudentModuleGradeTextField = new TextField();
	TextField editStudentModuleEmailTextField = new TextField();
	TextField  editStudentModuleNameTextField  = new TextField();

	TextField removeModuleStudentEmailTextField = new TextField();
	TextField removeModuleNameTextField = new TextField();

	TextField removeteacheremailAddressTextField = new TextField();


	public ViewPopUp(VBox setDegreeTeacherVbox,VBox RemoveTeacher,VBox VboxaddTeacherVbox,VBox addStudentModuleVbox) throws SQLException{

		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		emptyLabel.setEffect(ds);
		//emptyLabel2.

		AddNewTeacherLabel.setEffect(ds);

		teacherfNameTextField .setEffect(ds); 

		teachermNameTextField.setEffect(ds);
		teacherlNameTextField.setEffect(ds);
		teacherphoneTextField.setEffect(ds);
		teacheremailAddressTextField.setEffect(ds);
		teacherdegreeTextField.setEffect(ds);
		addTeacher.setEffect(ds);

		editTeacherLabel.setEffect(ds);
		editteacherdegreeTextField.setEffect(ds);
		editteacheremailAddressTextField.setEffect(ds);
		editTeacherDegreeButton.setEffect(ds);

		removeTeacherLabel.setEffect(ds);
		removeteacheremailAddressTextField.setEffect(ds);
		removeTeacher.setEffect(ds);

		addModuleStudentEmailTextField.setEffect(ds);
		addModuleNameTextField .setEffect(ds);
		addModuleGradeTextField.setEffect(ds);
		addModuleButton.setEffect(ds);

		editStudentModuleGradeTextField.setEffect(ds);
		editStudentModuleEmailTextField.setEffect(ds);
		editModuleButton.setEffect(ds); 

		removeModuleStudentEmailTextField.setEffect(ds);
		removeModuleNameTextField.setEffect(ds);

		removeteacheremailAddressTextField.setEffect(ds); 

		//BREAK

		//		emptyLabel.
		//		emptyLabel2.
		AddNewTeacherLabel.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));

		teacherfNameTextField .setFont(Font.font ("Verdana", 14));

		teachermNameTextField.setFont(Font.font ("Verdana", 14));
		teacherlNameTextField.setFont(Font.font ("Verdana", 14));
		teacherphoneTextField.setFont(Font.font ("Verdana", 15));
		teacheremailAddressTextField.setFont(Font.font ("Verdana", 15));
		teacherdegreeTextField.setFont(Font.font ("Verdana", 15));
		addTeacher.setFont(Font.font ("Verdana", 15));

		editTeacherLabel.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
		editteacherdegreeTextField.setFont(Font.font ("Verdana", 15));
		editteacheremailAddressTextField.setFont(Font.font ("Verdana", 15));
		editTeacherDegreeButton .setFont(Font.font ("Verdana", 15));

		removeTeacherLabel.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
		removeteacheremailAddressTextField.setFont(Font.font ("Verdana", 15));
		removeTeacher.setFont(Font.font ("Verdana", 15));

		addModuleStudentEmailTextField.setFont(Font.font ("Verdana", 15));
		addModuleNameTextField .setFont(Font.font ("Verdana", 15));
		addModuleGradeTextField.setFont(Font.font ("Verdana", 15));

		editStudentModuleGradeTextField.setFont(Font.font ("Verdana", 15));
		editStudentModuleEmailTextField.setFont(Font.font ("Verdana", 15));
		editModuleButton .setFont(Font.font ("Verdana", 15));
		editStudentModuleNameTextField.setFont(Font.font ("Verdana", 15));

		removeModuleStudentEmailTextField.setFont(Font.font ("Verdana", 15));
		removeModuleNameTextField.setFont(Font.font ("Verdana", 15));

		removeteacheremailAddressTextField.setFont(Font.font ("Verdana", 15));


		//BREAK

		teacherfNameTextField.setEffect(ds);

		emptyLabel.setText("");
		emptyLabel2.setText("");
		AddNewTeacherLabel.setText("Add new Teacher");

		teacherfNameTextField .setText("Enter teacher first Name"); 

		teachermNameTextField.setText("Enter teacher middle Name"); 
		teacherlNameTextField.setText("Enter teacher last Name");
		teacherphoneTextField.setText("Enter phone");
		teacheremailAddressTextField.setText("Enter emailAddress");
		teacherdegreeTextField.setText("Enter Degree");
		addTeacher.setText("Add");

		editTeacherLabel.setText("Edit Teacher Degree");
		editteacherdegreeTextField.setText("Enter Degree");
		editteacheremailAddressTextField.setText("Enter emailAddress");
		editTeacherDegreeButton .setText("Edit");

		removeTeacherLabel.setText("Remove Teacher");
		removeteacheremailAddressTextField.setText("Enter emailAddress");
		removeTeacher.setText("Remove");

		addModuleStudentEmailTextField.setText("Enter emailAddress");
		addModuleNameTextField .setText("Enter Module Name"); 
		addModuleGradeTextField.setText("Edit Module Grade");
		addModuleButton.setText("Add");

		editStudentModuleGradeTextField.setText("Edit Module Grade");
		editStudentModuleNameTextField.setText("Enter Module Name");
		editStudentModuleEmailTextField.setText("Enter emailAddress");
		editModuleButton.setText("Edit");

		removeModuleStudentEmailTextField.setText("Enter emailAddress");  
		removeModuleNameTextField.setText("Enter Module Name");  

		removeteacheremailAddressTextField.setText("Enter emailAddress"); 





		VboxaddTeacherVbox.getChildren().add(AddNewTeacherLabel);
		VboxaddTeacherVbox.getChildren().add(teacherfNameTextField);
		VboxaddTeacherVbox.getChildren().add(teachermNameTextField );
		VboxaddTeacherVbox.getChildren().add(teacherlNameTextField );
		VboxaddTeacherVbox.getChildren().add(teacherphoneTextField  );
		VboxaddTeacherVbox.getChildren().add(teacheremailAddressTextField );
		VboxaddTeacherVbox.getChildren().add(teacherdegreeTextField ); 
		VboxaddTeacherVbox.getChildren().add(addTeacher); 

		VboxaddTeacherVbox.getChildren().add(emptyLabel);
		VboxaddTeacherVbox.getChildren().add(editTeacherLabel);
		VboxaddTeacherVbox.getChildren().add(editteacheremailAddressTextField);
		VboxaddTeacherVbox.getChildren().add(editteacherdegreeTextField);
		VboxaddTeacherVbox.getChildren().add(editTeacherDegreeButton);

		VboxaddTeacherVbox.getChildren().add(emptyLabel2);
		VboxaddTeacherVbox.getChildren().add(removeTeacherLabel);
		VboxaddTeacherVbox.getChildren().add(removeteacheremailAddressTextField);
		VboxaddTeacherVbox.getChildren().add(removeTeacher);

		addStudentModuleVbox.getChildren().add(addModuleStudentEmailTextField);
		addStudentModuleVbox.getChildren().add(addModuleNameTextField);
		addStudentModuleVbox.getChildren().add(addModuleGradeTextField);	
		addStudentModuleVbox.getChildren().add(addModuleButton);

		VBox editStudentGradeVbox = new VBox();
		addStudentModuleVbox.getChildren().add( editStudentGradeVbox);

		editStudentGradeVbox.getChildren().add(editStudentModuleNameTextField);
		editStudentGradeVbox.getChildren().add( editStudentModuleEmailTextField );
		editStudentGradeVbox.getChildren().add(editStudentModuleGradeTextField);
		editStudentGradeVbox.getChildren().add(editModuleButton);

		ControllerPopUp controllerPopUp = new ControllerPopUp();



		addTeacher.setOnAction((event) -> {

			String fName = teacherfNameTextField.getText();
			String mName = teachermNameTextField.getText();
			String lName =  teacherlNameTextField.getText();
			String emailAddress =  teacheremailAddressTextField.getText();
			String degree =  teacherdegreeTextField.getText();
			int phone = Integer.parseInt(teacherphoneTextField.getText());

			if( mName == null || mName == "") {
				Name teacherName =  new Name(fName, lName);
				Teacher teacher= new Teacher(emailAddress, phone, teacherName,degree);
				controllerPopUp.addteacherControllerPopUp(teacher);


			}
			else { 
				Name teacherNameFull =  new Name(fName, mName, lName);
				Teacher teacher = new Teacher(emailAddress, phone, teacherNameFull, degree);
				controllerPopUp.addteacherControllerPopUp(teacher);
			}
			//

		});


		editTeacherDegreeButton.setOnAction((event) -> {
			String email=  editteacheremailAddressTextField.getText();		
			String degree = editteacherdegreeTextField.getText(); 

			try {
				controllerPopUp.editTeacherDegree(email, degree);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				//

		});


		removeTeacher.setOnAction((event) -> {
			String email=  removeteacheremailAddressTextField.getText();		
			controllerPopUp.removeTeacherController(email);

		});


		addModuleButton.setOnAction((event) -> {
			String email=  addModuleStudentEmailTextField.getText();	
			int grade =Integer.parseInt(addModuleGradeTextField.getText());
			String module = 	addModuleNameTextField.getText();	
			controllerPopUp.addModulesController(module, grade, email);

		});


		editModuleButton.setOnAction((event) -> {
			String email=  editStudentModuleEmailTextField.getText();	
			int grade =Integer.parseInt(editStudentModuleGradeTextField.getText());
			String module = editStudentModuleNameTextField.getText();
			try {
				controllerPopUp.editModuleGradeController(email, grade,module);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});








	}


}


