import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException {

        String host = "netology.homework";
        int port = 8089;

        System.out.println("Client started");
        System.out.println("--------------");
        try (Socket clientSocket = new Socket(host, port);


             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String inStr = in.readLine();
            System.out.println("Server: " + inStr);
            out.println("Aleksey");

            String inYouChildStr = in.readLine();
            System.out.println("Server: " + inYouChildStr);
            out.println("no"); // yes
            out.flush();

            String accessByYearsStr = in.readLine();
            System.out.println("Server: " + accessByYearsStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
