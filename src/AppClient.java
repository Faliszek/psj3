import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class AppClient {
    public AppClient() {}

    public void start(String hostname, int port) {
        try {
            Socket socket = new Socket("debian-server", 8091);

            OutputStream out  = socket.getOutputStream();
            PrintWriter writer  = new PrintWriter(out, true);

            InputStream in = socket.getInputStream();
            BufferedReader buffR = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            Scanner input = new Scanner(System.in);
            String line;
            while ((line = input.nextLine()) != null) {
                writer.println(line);
                System.out.println(buffR.readLine());

                if(line.equals("exit")) {
                    break;
                }
             }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
