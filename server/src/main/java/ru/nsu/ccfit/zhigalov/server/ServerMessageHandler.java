package ru.nsu.ccfit.zhigalov.server;

import ru.nsu.ccfit.zhigalov.network.IMessageHandler;
import ru.nsu.ccfit.zhigalov.network.TCPConnection;

import java.util.ArrayList;

public class ServerMessageHandler extends IMessageHandler {


    @Override
    protected void clientDisconnected(String userName) {
        //
    }

    @Override
    protected void clientMessage(int sessionId, String message) {

    }

    @Override
    protected void usersOnlineResponse(String[] users) {
//
    }

    @Override
    protected void usersOnlineRequest(int sessionId) {

    }

    @Override
    protected void serverMessage(String senderName, String message) {

    }

    @Override
    protected void messageListResponse(ArrayList<javafx.util.Pair<String, String>> messages) {

    }

    @Override
    protected void loginResponse(int sessionId) {

    }

    @Override
    protected void disconnect() {

    }

    @Override
    protected void serverError(String reason) {

    }

    @Override
    protected void serverSuccess() {

    }

    @Override
    protected void loginRequest(String userName) {

    }

    @Override
    protected void clientConnected(String userName) {

    }

    @Override
    protected void exception(Exception e) {

    }
}
