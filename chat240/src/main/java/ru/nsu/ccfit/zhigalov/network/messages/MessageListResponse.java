package ru.nsu.ccfit.zhigalov.network.messages;

import javafx.util.Pair;

import java.util.ArrayList;

public class MessageListResponse extends IMessage {
    public MessageListResponse(ArrayList<Pair<String, String>> messages) {
        this.messages = messages;
    }

    public ArrayList<Pair<String, String>> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Pair<String, String>> messages) {
        this.messages = messages;
    }

    ArrayList<Pair<String, String>> messages;
}
