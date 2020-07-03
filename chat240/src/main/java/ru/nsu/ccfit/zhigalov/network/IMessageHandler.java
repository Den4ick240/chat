package ru.nsu.ccfit.zhigalov.network;

import javafx.util.Pair;
import ru.nsu.ccfit.zhigalov.network.messages.*;

import java.util.ArrayList;

public abstract class IMessageHandler {
    void handle (IMessage msg) {
        var msgClass = msg.getClass();

        if (msgClass.equals(ClientConnected.class)) {
            clientConnected(((ClientConnected) msg).getUserName());
        }
        else if (msgClass.equals(ClientDisconnected.class)) {
            clientDisconnected(((ClientDisconnected) msg).getUserName());
        }
        else if (msgClass.equals(ClientMessage.class)) {
            ClientMessage clientMsg = (ClientMessage) msg;
            clientMessage(clientMsg.getSessionId(), clientMsg.getMessage());
        }
        else if (msgClass.equals(UsersOnlineResponse.class)) {
            usersOnlineResponse(((UsersOnlineResponse) msg).getUsers());
        }
        else if (msgClass.equals(UsersOnlineRequest.class)) {
            usersOnlineRequest(((UsersOnlineRequest) msg).getSessionId());
        }
        else if (msgClass.equals(ServerMessage.class)) {
            ServerMessage serverMsg = (ServerMessage) msg;
            serverMessage(serverMsg.getSenderName(), serverMsg.getMessage());
        }
        else if (msgClass.equals(MessageListResponse.class)) {
            messageListResponse(((MessageListResponse) msg).getMessages());
        }
        else if (msgClass.equals(LoginResponce.class)) {
            loginResponse(((LoginResponce) msg).getSessionId());
        }
        else if (msgClass.equals(Disconnect.class)) {
            disconnect();
        }
        else if (msgClass.equals(ServerError.class)) {
            serverError(((ServerError) msg).getReason());
        }
        else if (msgClass.equals(ServerSuccess.class)) {
            serverSuccess();
        }
        else if (msgClass.equals(LoginRequest.class)) {
            loginRequest(((LoginRequest) msg).getUserName());
        }
    }

    protected abstract void clientDisconnected(String userName);

    protected abstract void clientMessage(int sessionId, String message);

    protected abstract void usersOnlineResponse(String[] users);

    protected abstract void usersOnlineRequest(int sessionId);

    protected abstract void serverMessage(String senderName, String message);

    protected abstract void messageListResponse(ArrayList<Pair<String, String>> messages);

    protected abstract void loginResponse(int sessionId);

    protected abstract void disconnect();

    protected abstract void serverError(String reason);

    protected abstract void serverSuccess();

    protected abstract void loginRequest(String userName);

    protected abstract void clientConnected(String userName);

    protected abstract void exception(Exception e);

}
