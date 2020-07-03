package ru.nsu.ccfit.zhigalov.network;

import ru.nsu.ccfit.zhigalov.UiController;
import ru.nsu.ccfit.zhigalov.network.messages.IMessage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.*;

public class TCPConnection {
    private final IMessageHandler messageHandler;
    Socket socket;
    ObjectInputStream inputStream;
    final ObjectOutputStream outputStream;
    InputStream socketInputStream;
    static ScheduledThreadPoolExecutor threadPool;
    static final Integer SCHEDULE_PERIOD = 800;
    static final TimeUnit SCHEDULE_TIMEUNIT = TimeUnit.MILLISECONDS;
    static final Integer SCHEDULE_INITIAL_DELAY = 0;
    private Runnable task;

    private void startListening() {
        task = new Runnable() {
            @Override
            public void run() {
                try {
                    if (socketInputStream.available() < 1) return;
                    IMessage msg = (IMessage) inputStream.readObject();
                    messageHandler.handle(msg);
                } catch (Exception e) {
                    messageHandler.exception(e);
                }
            }
        };
        threadPool.scheduleAtFixedRate(task, SCHEDULE_INITIAL_DELAY, SCHEDULE_PERIOD, SCHEDULE_TIMEUNIT);
    }
    public TCPConnection(IMessageHandler messageHandler, ScheduledThreadPoolExecutor threadPool, String serverHost, int port) throws IOException {

        this(messageHandler, threadPool, new Socket(serverHost, port));
    }


    public TCPConnection(IMessageHandler messageHandler, ScheduledThreadPoolExecutor threadPool, Socket socket) throws IOException {
        this.messageHandler = messageHandler;
        this.threadPool = threadPool;
        this.socket = socket;
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        socketInputStream = socket.getInputStream();
        inputStream = new ObjectInputStream(socketInputStream);
    }

    public void sendMessage(IMessage msg) {
        synchronized (outputStream) {
            try {
                outputStream.writeObject(msg);
                outputStream.flush();
            } catch (IOException e) {
                messageHandler.exception(e);
            }
        }
    }

    public void disconnect() {
        threadPool.remove(task);
        try {
            socket.close();
        } catch (IOException e) {
            messageHandler.exception(e);
        }
    }
}
