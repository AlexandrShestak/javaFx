package sample;

import com.tp.course.dao.HibernateCourseDao;
import com.tp.course.entity.Course;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by shestakam on 20.12.2015.
 */
public class ProfessorController {

    private HibernateCourseDao hibernateCourseDao = new HibernateCourseDao();

    @FXML
    private Button selectCourseToTeach;


    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
     /*   ObservableList<StringProperty> allCoursesData = FXCollections.observableArrayList();
        for (Course course : hibernateCourseDao.getAll()) {
            StringProperty property = new SimpleStringProperty("tralala");
            property.setValue(course.getName());
            allCoursesData.add(property);
        }
        coursesTableColumn.setCellValueFactory(cellData -> cellData.getValue());
        professorCoursesTableColumn.setCellValueFactory(cellData -> cellData.getValue());
        coursesTable.setItems(allCoursesData);
        coursesTable.refresh();*/
    }


    public void selectCourseToTeach() throws IOException {
        Stage stage = (Stage) selectCourseToTeach.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("chooseCourse.fxml"));
        stage.setScene(new Scene(root, 800, 400));

        ObservableList<StringProperty> allCoursesData = FXCollections.observableArrayList();
        for (Course course : hibernateCourseDao.getAll()) {
            StringProperty property = new SimpleStringProperty("tralala");
            property.setValue(course.getName());
            allCoursesData.add(property);
        }
      /*  coursesTableColumn.setCellValueFactory(cellData -> cellData.getValue());
        professorCoursesTableColumn.setCellValueFactory(cellData -> cellData.getValue());
        coursesTable.setItems(allCoursesData);
        coursesTable.refresh();*/
        return;
    }


}
