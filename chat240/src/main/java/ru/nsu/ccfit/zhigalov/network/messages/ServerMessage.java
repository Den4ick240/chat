package ru.nsu.ccfit.zhigalov.network.messages;

public class ServerMessage extends IMessage {
    public ServerMessage(String message, String senderName) {
        this.message = message;
        this.senderName = senderName;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    String message;
    String senderName;
}
