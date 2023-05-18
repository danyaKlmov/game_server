import java.io.IOException;
import java.util.Scanner;

public class Client implements TCPConnectionListener{

    TCPConnection tcpConnection;
    public static void main(String[] args) throws IOException {
        new Client();
    }

    public Client() throws IOException {
        Scanner scanner = new Scanner(System.in);
        tcpConnection = new TCPConnection(this, "127.0.0.1", 8085);
        String msg = "";
        while (true){
            msg = scanner.nextLine();
            tcpConnection.sendString(msg);
        }

    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {

    }

    @Override
    public void onDisconnect(TCPConnection TCPConnection) {
        tcpConnection.disconnect();
    }

    @Override
    public void onMessageReceived(TCPConnection tcpConnection, String str) {
        System.out.println("Сообщение:" + str);
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception ex) {

    }
}
