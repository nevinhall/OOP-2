package application;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Name;
import model.Person;
import model.RunDB;
import model.Student;
import model.Teacher;
import model.retrieveFromDB.RetreiveTeacherDB;
import view.view;

public class Main extends Application{
	 final int teacherPrimaryKey = 0;
	public static void main(String[] args) {
	
		RunDB launchDB = new RunDB();
		try {
			RetreiveTeacherDB getTeachers = new RetreiveTeacherDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Name name = new Name("Nevin", "Hall");	
		Person Nevin = new Person("nevinhall@mycit.ie",998754, name);
		System.out.println(Nevin);

		Name TeacherName = new Name("Kevin", "Nevin", "wall");
		Teacher kevin = new Teacher("KevinWall@mycit.ie", 0, TeacherName, "SoftwareDev");
		kevin.setDegree("web dev");
		System.out.println(kevin);

//		ModuleGrade NoSql = new ModuleGrade();
//		NoSql.setModuleGrade(100);
//		NoSql.setModuleName("NoSql");
//
//		ModuleGrade NonLinear = new ModuleGrade();
//		NonLinear.setModuleGrade(80);
//		NonLinear.setModuleName("NonLinear");

		Student NevinHall = new Student("test@mycit.ie", 5457375, name, 6111998);
		//NevinHall.getList().AddModule(NonLinear);
		//System.out.println(NevinHall.getList());
		Application.launch(args);
		
	
		
		//ClassGroupArrayList testClassGroupArrayList = new ClassGroupArrayList();
		//testClassGroupArrayList.addStudentToGroup(NevinHall);
		//System.out.println(testClassGroupArrayList.classGroup.getGroup().get(0));
		
		
		//testClassGroupArrayList.removeStudentFromClassGroup("Nevin", "Hall");
		//System.out.println(testClassGroupArrayList.classGroup.getGroup().size());
		
	//	testClassGroupArrayList.classGroup.setClassGroupName("Aclass");
		//testClassGroupArrayList.removeClassGroup("Aclass");
		
	
		
	
		


	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 800, 500, Color.WHITE);



		VBox addRemoveVbox = new VBox();
		HBox listAllStudentsHbox = new HBox();
		VBox listAllTeacherVbox = new VBox();
		HBox addRemoveButtonContainer = new HBox();


		view view = new view(addRemoveVbox,listAllStudentsHbox,listAllTeacherVbox,addRemoveButtonContainer );
		//CarView carView = new CarView(CarCreate, RemoveCarHBox, carListOptions);


		BorderPane MainBorder = new BorderPane();
		MainBorder.prefHeightProperty().bind(scene.heightProperty());
		MainBorder.prefWidthProperty().bind(scene.widthProperty());

		//MainBorder.setTop(addRemoveButtonContainer);
		MainBorder.setLeft(addRemoveVbox);
		MainBorder.setCenter(listAllStudentsHbox);
		MainBorder.setRight(listAllTeacherVbox);
		MainBorder.setStyle("-fx-background-color: grey");
		



		root.getChildren().add(MainBorder);

		primaryStage.setScene(scene);
		primaryStage.show(); 


	}

}
