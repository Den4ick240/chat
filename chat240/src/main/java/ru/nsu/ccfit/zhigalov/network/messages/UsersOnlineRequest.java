package ru.nsu.ccfit.zhigalov.network.messages;

public class UsersOnlineRequest extends IMessage {
    public UsersOnlineRequest(int sessionId) {
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
