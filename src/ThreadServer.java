import java.io.IOException;
import java.net.ServerSocket;

public class ThreadServer {
    public ThreadServer() {

    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(8091, 2);
            System.out.println("oczekuje na połączenie");
            while(true) {
                new AppServer(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
