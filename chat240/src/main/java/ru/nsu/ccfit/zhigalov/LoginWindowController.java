package ru.nsu.ccfit.zhigalov;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.nsu.ccfit.zhigalov.network.TCPConnection;
import ru.nsu.ccfit.zhigalov.network.messages.LoginRequest;

import java.io.IOException;

public class LoginWindowController {
    public void setConnection(TCPConnection connection) {
        this.connection = connection;
    }

    TCPConnection connection;

    @FXML
    private Label warningLable;

    @FXML
    private TextField nicknameField;

    @FXML
    private Button loginButton;

    @FXML
    private Button exitButton;

    @FXML
    void loginButtonAction(ActionEvent event) throws IOException {
        connection.sendMessage(new LoginRequest(nicknameField.getText()));
        App.setRoot(App.mainFXMLName);
    }

    @FXML
    void exitButtonAction(ActionEvent event) {
        Platform.exit();
    }

    public void setMessage(String text) {
        warningLable.setText(text);
    }

}
