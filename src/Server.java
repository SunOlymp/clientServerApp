import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final Integer localhost = 15476;

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(localhost); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
        Socket clientSocket = serverSocket.accept(); // ждем подключения
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("New connection accepted");
        final String name = in.readLine();
        out.println(String.format("Привет %s, твой порт %d", name, clientSocket.getPort()));
    }
}
