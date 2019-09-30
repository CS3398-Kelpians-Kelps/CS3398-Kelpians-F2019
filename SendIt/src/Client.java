/**
 *
 * Template client found on https://www.geeksforgeeks.org/socket-programming-in-java/
 * Using this for now
 */
// A Java program for a Client

import javax.xml.crypto.Data;
import java.net.*;
import java.io.*;

public class Client
{
    // initialize socket and input output streams
    private Socket socket		 = null;
    private DataInputStream input = null;
    private DataOutputStream out	 = null;
    private String line = "";
    private DataInputStream in = null;
    private GUI mainMenu = new GUI();

    // constructor to put ip address and port
    public Client(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        // keep reading until "Over" is input
        while (!line.equals("Over"))
        {
            try
            {
                mainMenu.DisplayMenu();
                line = input.readLine();
                switch(line) {
                    case "1":{
                        out.writeUTF(line);
                        System.out.println("Put your message here.");
                        line = input.readLine();
                        out.writeUTF(line);
                        break;
                    }case "2": {
                        /**out.writeUTF(line);
                        line = in.readUTF();
                        System.out.println(line);*/
                        /**InputStream is = socket.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        String message = br.readLine();
                        System.out.println("Message received from the server : " +message);*/
                        line = in.readLine();
                        System.out.println(line);
                        break;
                    }case "3":
                        line = "Over";
                        out.writeUTF(line);
                        break;
                    default:
                        break;
                }

            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}
