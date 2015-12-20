package sample;

import com.tp.user.dao.HibernateUserDao;
import com.tp.user.entity.Role;
import com.tp.user.entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Set;

public class LoginController {

    private HibernateUserDao userDao = new HibernateUserDao();

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Text messageText;

    @FXML
    public void login() throws IOException {
        System.out.println("Login");
        String login = usernameTextField.getText();
        String password = passwordTextField.getText();
        System.out.println(usernameTextField.getText());
        System.out.println(passwordTextField.getText());
        User user = userDao.getUserByName(login);
        if (user == null) {
            messageText.setText("Incorrect username");
            return;
        }

        if (!user.getPassword().equals(password)) {
            messageText.setText("Incorrect password");
            return;
        }

        Set<Role> roleSet = user.getRoleSet();
        String role = roleSet.iterator().next().getRole();
        messageText.setText(role);

        if (role.equals("ROLE_STUDENT")) {
            Stage stage = (Stage) messageText.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("studentScene.fxml"));
            stage.setScene(new Scene(root, 800, 400));
            return;
        } else if (role.equals("ROLE_PROFESSOR")) {
            Stage stage = (Stage) messageText.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("professorScene.fxml"));
            stage.setScene(new Scene(root, 800, 400));
            return;
        }


    }
}
