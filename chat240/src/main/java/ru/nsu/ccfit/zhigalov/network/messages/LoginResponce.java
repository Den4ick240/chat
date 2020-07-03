package ru.nsu.ccfit.zhigalov.network.messages;

public class LoginResponce extends IMessage {
    public LoginResponce(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    private int sessionId;
}
