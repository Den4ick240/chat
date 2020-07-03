package ru.nsu.ccfit.zhigalov.network.messages;

public class ClientDisconnected extends IMessage {
    public ClientDisconnected(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
}
