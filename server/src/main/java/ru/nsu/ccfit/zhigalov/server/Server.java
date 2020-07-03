package ru.nsu.ccfit.zhigalov.server;

import ru.nsu.ccfit.zhigalov.network.IMessageHandler;
import ru.nsu.ccfit.zhigalov.network.messages.IMessage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class Server extends IMessageHandler {
    private Selector selector;
    private InetSocketAddress serverAddres;
    private ArrayList<SocketChannel> connections;
    private ServerSocketChannel serverSocketChannel;

    public Server(String host, int port) {
        serverAddres = new InetSocketAddress(host, port);
        //connections = new ArrayList<>();
    }

    public void start() throws IOException {

        selector = Selector.open();

        serverSocketChannel = ServerSocketChannel.open();
        //serverSocketChannel.bind(serverAddres);

    }

    private void broadcast(IMessage msg) {
       // for ()
    }

    @Override
    protected void clientDisconnected(String userName) {
        //
    }

    @Override
    protected void clientMessage(int sessionId, String message) {

    }

    @Override
    protected void usersOnlineResponse(String[] users) {
//
    }

    @Override
    protected void usersOnlineRequest(int sessionId) {

    }

    @Override
    protected void serverMessage(String senderName, String message) {

    }

    @Override
    protected void messageListResponse(ArrayList<javafx.util.Pair<String, String>> messages) {

    }

    @Override
    protected void loginResponse(int sessionId) {

    }

    @Override
    protected void disconnect() {

    }

    @Override
    protected void serverError(String reason) {

    }

    @Override
    protected void serverSuccess() {

    }

    @Override
    protected void loginRequest(String userName) {

    }

    @Override
    protected void clientConnected(String userName) {

    }

    @Override
    protected void exception(Exception e) {

    }
}
