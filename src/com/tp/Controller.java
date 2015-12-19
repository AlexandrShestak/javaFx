package com.tp;

import com.tp.dao.HibernateUserDao;
import com.tp.entities.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    private HibernateUserDao userDao = new HibernateUserDao();

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Text messageText;

    public void login(){
        System.out.println("Login");
        String login = usernameTextField.getText();
        String password = passwordTextField.getText();
        System.out.println(usernameTextField.getText());
        System.out.println(passwordTextField.getText());
        User user = userDao.get(login);
        if (user == null) {
            messageText.setText("Incorrect username or password");
            return;
        }

    }
}
