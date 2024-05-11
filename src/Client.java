import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try(Socket clientSocket = new Socket("localhost", Server.localhost);
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
        writer.println("Привет от Глеба");
            System.out.println(reader.readLine());
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }
}
