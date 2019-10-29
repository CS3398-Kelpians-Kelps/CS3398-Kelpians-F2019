import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final int port = 4444;
    private ServerSocket ss = null;

    public void  runServer() throws IOException, ClassNotFoundException{
        ss = new ServerSocket(port);
        System.out.println("Listening for connections...");
        Socket socket = ss.accept();
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());


        String m = (String) is.readObject();
        System.out.println(m);
        BufferedImage image = ImageIO.read(ImageIO.createImageInputStream(is));
        ImageIO.write(image, "PNG", new File("test.PNG"));
        m = "sending back to client";
        os.writeObject(m);
        socket.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        new Main().runServer();
    }
}
