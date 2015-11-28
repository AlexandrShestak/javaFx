package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    public void login(){
        System.out.println("Login");
        System.out.println(usernameTextField.getText());
        System.out.println(passwordTextField.getText());
    }
}
