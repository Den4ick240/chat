package ru.nsu.ccfit.zhigalov;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Pair;
import ru.nsu.ccfit.zhigalov.network.TCPConnection;
import ru.nsu.ccfit.zhigalov.network.messages.ClientMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainWindowController {
    String SEPARATOR_FOR_USERS_ONLINE_LIST = "\n";
    private int usersNum = 0;
    int sessionId;

    public void setConnection(TCPConnection connection) {
        this.connection = connection;
    }

    TCPConnection connection;

    @FXML
    private ScrollPane usersOnlinePane;

    @FXML
    private TextFlow usersOnlineTextFlow;

    @FXML
    private Button sendButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label usersNumLabel;

    @FXML
    private Label messageLabel;

    @FXML
    private TextArea messageTextField;

    @FXML
    void exitButtonAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void sendButtonAction(ActionEvent event) {
        connection.sendMessage(new ClientMessage(messageTextField.getText(), sessionId));
    }

    private final Map<String, Text> usersOnlineList = new HashMap<>();

    public void updateMessageList(ArrayList<Pair<String, String>> messages) {

    }

    public void newMessage(String senderName, String message) {

    }

    public void loginResponse(int sessionId) {
        this.sessionId = sessionId;
    }

    public void updateUserList(String[] users) {
        usersNum = users.length;
        usersOnlineTextFlow.getChildren().clear();
        for (var user : users) {
            userConnected(user);
        }
    }

    public void userConnected(String user) {
        if (usersOnlineList.containsKey(user)) return;
        var text = new Text(user + SEPARATOR_FOR_USERS_ONLINE_LIST);
        usersOnlineList.put(user, text);
        usersOnlineTextFlow.getChildren().add(text);
    }

    public void userDisconnected(String user) {
        if (!usersOnlineList.containsKey(user)) {
            return;//TODO::SDFSDLFISJDFLISd
        }
        var text = usersOnlineList.get(user);
        usersOnlineTextFlow.getChildren().remove(text);
    }
}
