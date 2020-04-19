import java.io.*;
import java.net.Socket;

public class AppServer extends Thread {
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader in;

    public AppServer(Socket socket) {
        System.out.println("Nawiazal połączenie");
        clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = clientSocket.getInputStream();
            BufferedReader buffR = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            OutputStream out = clientSocket.getOutputStream();


            writer = new PrintWriter(out, true);
            String line;
            String text = "Prosze wybrac opcje: \n" + "1) podaj czas serwera \n" +
                    "2) Wyślij pilk\n" + "exit) Zakonczenie pracy\n";

            writer.println(text);
            while((line = buffR.readLine()) != null) {
                System.out.println(line);

                switch(line) {
                    case "1":
                        this.ShowDataTime();
                        break;
                    case "2":
                        SendFileToServer();
                        break;
                    case "3":
                        getSocketInfo();
                }

                if(line.equals("exit")) {
                    writer.println("pa pa");
                    break;
                }
            }

            System.out.println("kończę połączenie");
            writer.close();
            buffR.close();
            clientSocket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowDataTime() {
        writer.println("Aktualna data i czas");
    }

    private void SendFileToServer() {
        writer.println("Przesylanie danych ");
    }

    private void getSocketInfo() {
        writer.println("Informacje o połaczeniu");
    }

//    public void start() {
//        try {
//            ServerSocket  sSocket = new ServerSocket(8091);
//            System.out.println("oczekuje na użytkowników");
//            while(true) {
//                Socket clientSocket = sSocket.accept();
//                InputStream in = clientSocket.getInputStream();
//                OutputStream out = clientSocket.getOutputStream();
//
//
//                BufferedReader buffR = new BufferedReader(new InputStreamReader((in)));
//                PrintWriter writer = new PrintWriter(out, true);
//                String line;
//
//                writer.println("Witaj nowy użytkowniku");
//
//                InetAddress tempInet = clientSocket.getInetAddress();
//                System.out.println(tempInet.getHostName());
//                System.out.println(clientSocket.getPort());
//
//
//                while((line = buffR.readLine()) != null) {
//                    System.out.println(line);
//                    writer.println("Dziękuje za komunikat");
//                    if(line.equals("exit")) {
//                        break;
//                    }
//                }
//                System.out.println("kończę połączenie");
//                clientSocket.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}

