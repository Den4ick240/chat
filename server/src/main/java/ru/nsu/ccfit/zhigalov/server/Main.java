package ru.nsu.ccfit.zhigalov.server;

import javafx.util.Pair;
import ru.nsu.ccfit.zhigalov.network.IMessageHandler;
import ru.nsu.ccfit.zhigalov.network.TCPConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main extends IMessageHandler {
    private static int serverPort;
    private final static String CONFIG_FILE_NAME = "/config.ini";
    private final static String CONFIG_READING_ERROR = "Error, couldn't read config file";
    private final static Integer SCHEDULER_CORE_SZIE = 8;
    private final static int EXIT_FAILURE = 1;
    static ArrayList<TCPConnection> connections;
//    private final ArrayList<>
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

    public static void main(String[] arguments) {
        System.out.println("Server started...");
        Properties props = new Properties();
        try {
            props.load(ru.nsu.ccfit.zhigalov.server.Main.class.getResourceAsStream(CONFIG_FILE_NAME));
            serverPort = Integer.parseInt(props.getProperty("serverPort"));
        } catch (IOException | NumberFormatException e) {
            System.out.println(CONFIG_READING_ERROR);
            System.out.print(e);
            System.exit(EXIT_FAILURE);

        }
        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            while(true) {
                byte[] bytes = new byte[4];
                Socket socket = serverSocket.accept();
                System.out.println("new");
                connections.add(new TCPConnection((IMessageHandler) new Main(),
                        (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(SCHEDULER_CORE_SZIE), socket));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(serverPort);
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
    protected void messageListResponse(ArrayList<Pair<String, String>> messages) {

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
