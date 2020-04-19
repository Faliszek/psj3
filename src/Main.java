
public class Main {
    public static void main(String args[]) {
        System.out.println("Hello");
//        AppServer s = new AppServer();
//        s.start();

//        AppClient client = new AppClient();
//        client.start("debian-server", 8091);

        ThreadServer ts = new ThreadServer();
        ts.start();

    }
}
