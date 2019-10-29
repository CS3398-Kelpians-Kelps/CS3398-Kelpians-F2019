import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
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

        BufferedImage image = ImageIO.read(new File("C:\\Users\\jolly\\OneDrive\\Documents\\GitHub\\CS3398-Kelpians-F2019\\TestClient\\TestImage.PNG"));

        System.out.println("Ok");
        String test = "sending from client";
        os.writeObject(test);
        os.flush();
        ImageIO.write(image,"PNG",os);
        os.flush();
        System.out.println("Waiting for info from server ...");

        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        String returnMessage = (String) is.readObject();
        System.out.println(returnMessage);
        image = ImageIO.read(ImageIO.createImageInputStream(is));
        ImageIO.write(image, "PNG", new File("returnedFromServer.PNG"));
        socket.close();
    }
}
