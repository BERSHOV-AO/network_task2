import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        int port = 8089;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started");
            System.out.println("--------------");

            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    out.println("Write your name?");

                    final String nameStr = in.readLine();
                    System.out.println("Client: " + nameStr);

                    out.println("Are you child?");
                    out.flush();

                    final String youChildStr = in.readLine();
                    System.out.println("Client: " + youChildStr);
                    if (youChildStr.equals("yes")) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", nameStr));
                        out.flush();
                    }
                    if (youChildStr.equals("no")) {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, " +
                                "or a good working day!", nameStr));
                        out.flush();
                    }
                }
            }
        }
    }
}
