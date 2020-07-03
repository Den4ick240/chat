package ru.nsu.ccfit.zhigalov.network.messages;

public class ClientMessage extends IMessage {
    public ClientMessage(String message, int sessionId) {
        this.message = message;
        this.sessionId = sessionId;
    }

    public String getMessage() {
        return message;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    String message;
    int sessionId;
}
