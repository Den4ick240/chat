package ru.nsu.ccfit.zhigalov;

import javafx.util.Pair;

import java.util.ArrayList;

public interface UiController {
    void userConnected(String name);
    void userDisconnected(String name);
    void updateUserList(String[] users);
    void updateMessageList(ArrayList<Pair<String, String>> messages);
    void newMessage(String senderName, String message);
    void loginResponse(int sessionId);
    void disconnect();
    void serverError(String reason);
}
