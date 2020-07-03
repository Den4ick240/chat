package ru.nsu.ccfit.zhigalov.network.messages;

public class UsersOnlineResponse extends IMessage {
    public UsersOnlineResponse(String[] users) {
        this.users = users;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }

    String[] users;
}
