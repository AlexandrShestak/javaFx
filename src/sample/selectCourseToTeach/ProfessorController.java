package sample.selectCourseToTeach;


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

    @FXML
    private Button selectCourseToTeach;

    @FXML
    private void initialize() {
    }

    public void selectCourseToTeach() throws IOException {
        Stage stage = (Stage) selectCourseToTeach.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("chooseCourse.fxml"));
        stage.setScene(new Scene(root, 800, 400));
        return;
    }
}
