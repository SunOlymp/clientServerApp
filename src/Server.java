import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final Integer localhost = 15476;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(localhost)) { //Порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            System.out.println("Сервер стартовал");
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("New connection accepted");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }
}

