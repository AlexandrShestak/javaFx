package sample;

import com.tp.course.dao.HibernateCourseDao;
import com.tp.course.entity.Course;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;

import java.io.*;
import java.util.Optional;

/**
 * Created by shestakam on 21.12.2015.
 */
public class ChooseCourseController {

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

        ObservableList<StringProperty> professorCoursesData = FXCollections.observableArrayList();
        try {
            FileReader fileReader =
                    new FileReader("professorCourses");
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            String line  = null;
            while((line = bufferedReader.readLine()) != null) {
                professorCoursesData.add(new SimpleStringProperty(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        coursesTableColumn.setCellValueFactory(cellData -> cellData.getValue());
        professorCoursesTableColumn.setCellValueFactory(cellData -> cellData.getValue());
        coursesTable.setItems(allCoursesData);
        coursesTable.refresh();
        professorCoursesTable.setItems(professorCoursesData);
        professorCoursesTable.refresh();


    }

    public void addCourse() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Add course dialog");
        dialog.setHeaderText("Add course dialog");
        dialog.setContentText("Please enter course name");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        ObservableList items = professorCoursesTable.getItems();
        items.add(new SimpleStringProperty(result.get()));
        professorCoursesTable.setItems(items);
        professorCoursesTable.refresh();
    }

    public void deleteCourse() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Delete course dialog");
        dialog.setHeaderText("Delete course dialog");
        dialog.setContentText("Please enter course name");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();

        ObservableList items = professorCoursesTable.getItems();
        items.remove(result.get());
        ObservableList<StringProperty> itemsAfterDelete = FXCollections.observableArrayList();
        for (Object item : items) {
            StringProperty temp = (StringProperty) item;
            if (!result.get().equals(temp.getValue())) {
                itemsAfterDelete.add(new SimpleStringProperty(((StringProperty) item).getValue()));
            }
        }

        professorCoursesTable.setItems(itemsAfterDelete);
        professorCoursesTable.refresh();
    }

    public void save() throws FileNotFoundException, UnsupportedEncodingException {
        ObservableList items = professorCoursesTable.getItems();
        PrintWriter writer = new PrintWriter("professorCourses", "UTF-8");
        for (Object item : items) {
            writer.println(((StringProperty) item).getValue());
        }
        writer.close();
    }
}
