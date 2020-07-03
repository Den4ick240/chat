package ru.nsu.ccfit.zhigalov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.ccfit.zhigalov.network.TCPConnection;
import ru.nsu.ccfit.zhigalov.network.messages.MessageListResponse;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class App extends Application {

    private static final Integer SCHEDULER_CORE_SIZE = 1;
    private static Scene scene;
    public final static String mainFXMLName = "mainwindow.fxml";
    public final static String loginFXMLName = "loginwindow.fxml";
    public final static String loadingFXMLName = "loading.fxml";
    public final static String host = "127.0.0.1";
    public final static Integer port = 24000;
    private static User user;
    private ClientMessageHandler messageHandler;
    private TCPConnection tcpconnection;


    public static String setUserNickname(String nickname) {
        user = new User(nickname);
        return null;
    }

    @Override
    public void start(Stage stage) {
        try {
            MainWindowController controller = (new FXMLLoader(ru.nsu.ccfit.zhigalov.App.class.getResource(mainFXMLName))).getController();
            LoginWindowController loginController = (new FXMLLoader(ru.nsu.ccfit.zhigalov.App.class.getResource(loginFXMLName))).getController();

            messageHandler = new ClientMessageHandler(controller, loginController);
            tcpconnection = new TCPConnection(messageHandler,
                    (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(SCHEDULER_CORE_SIZE),
                    host, port);
            controller.setConnection(tcpconnection);
            loginController.setConnection(tcpconnection);





        } catch (IOException e) {
            e.printStackTrace();
        }


        //scene = new Scene(loadFXML(loginFXMLName));
        //stage.setScene(scene);
        //stage.show();
    }


    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ru.nsu.ccfit.zhigalov.App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}