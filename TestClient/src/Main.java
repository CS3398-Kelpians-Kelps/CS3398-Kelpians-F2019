import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws UnknownHostException,
            IOException, ClassNotFoundException {
        System.out.println("Welcome client");
        Socket socket = new Socket("localhost", 4444);
        System.out.println("Client connected");
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Ok");
        String test = "sending from client";
        os.writeObject(test);
        System.out.println("Waiting for info from server ...");

        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        String returnMessage = (String) is.readObject();
        System.out.println(returnMessage);
        socket.close();
    }
}
