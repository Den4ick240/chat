package ru.nsu.ccfit.zhigalov;

//import ru.nsu.ccfit.zhigalov.
//import ru.nsu.ccfit.zhigalov.network

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.util.Pair;
import ru.nsu.ccfit.zhigalov.network.IMessageHandler;
import ru.nsu.ccfit.zhigalov.network.messages.*;

import java.io.IOException;
import java.util.ArrayList;

public class ClientMessageHandler extends IMessageHandler {
    public ClientMessageHandler(MainWindowController controller, LoginWindowController loginController) {
        this.controller = controller;
        this.loginController = loginController;
    }

    MainWindowController controller;
    LoginWindowController loginController;

    private void unexpectedMessage() {
        System.out.println("Unexpected message");
    }

    @Override
    protected void clientDisconnected(String userName) {
        controller.userDisconnected(userName);
    }

    @Override
    protected void clientMessage(int sessionId, String message) {
        unexpectedMessage();
    }

    @Override
    protected void usersOnlineResponse(String[] users) {
        controller.updateUserList(users);
    }

    @Override
    protected void usersOnlineRequest(int sessionId) {
        unexpectedMessage();
    }

    @Override
    protected void serverMessage(String senderName, String message) {
        controller.newMessage(senderName, message);
    }

    @Override
    protected void messageListResponse(ArrayList<Pair<String, String>> messages) {
        controller.updateMessageList(messages);
    }

    @Override
    protected void loginResponse(int sessionId) {
        controller.loginResponse(sessionId);
    }

    @Override
    protected void disconnect() {

    }

    @Override
    protected void serverError(String reason) {
        try {
            App.setRoot(App.loginFXMLName);
            loginController.setMessage(reason);
        } catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    @Override
    protected void serverSuccess() {

    }

    @Override
    protected void loginRequest(String userName) {
        unexpectedMessage();
    }

    @Override
    protected void clientConnected(String userName) {
        controller.userConnected(userName);
    }

    @Override
    protected void exception(Exception e) {

    }
}
