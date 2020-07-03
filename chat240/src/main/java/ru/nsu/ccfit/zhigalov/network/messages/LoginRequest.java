package ru.nsu.ccfit.zhigalov.network.messages;

public class LoginRequest extends IMessage {
    public LoginRequest(String userName) {
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
