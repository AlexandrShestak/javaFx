package sample;

import com.tp.course.dao.HibernateCourseDao;
import com.tp.course.entity.Course;
import com.tp.user.entity.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/**
 * Created by shestakam on 20.12.2015.
 */
public class ProfessorController {

    private HibernateCourseDao hibernateCourseDao = new HibernateCourseDao();

    @FXML
    private TableView coursesTable;

    @FXML
    private TableView professorCoursesTable;

    @FXML
    private TableColumn<StringProperty, String> coursesTableColumn;
    @FXML
    private TableColumn<StringProperty, String> professorCoursesTableColumn;

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        ObservableList<StringProperty> allCoursesData = FXCollections.observableArrayList();
        for (Course course : hibernateCourseDao.getAll()) {
            StringProperty property = new SimpleStringProperty("tralala");
            property.setValue(course.getName());
            allCoursesData.add(property);
        }
        coursesTableColumn.setCellValueFactory(cellData -> cellData.getValue());
        professorCoursesTableColumn.setCellValueFactory(cellData -> cellData.getValue());
        coursesTable.setItems(allCoursesData);
        coursesTable.refresh();
    }


    public void selectCourseToTeach() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Add course dialog");
        dialog.setHeaderText("Add course dialog");
        dialog.setContentText("Please enter course name");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            System.out.println("Your name: " + result.get());
        }

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> System.out.println("Your name: " + name));

        ObservableList items = professorCoursesTable.getItems();
        items.add(new SimpleStringProperty(result.get()));
    }
}
