package ru.nsu.ccfit.zhigalov.network.messages;

public class ServerError extends IMessage {
    public ServerError(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    String reason;

}
