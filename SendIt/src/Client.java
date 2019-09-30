/**
 *
 * Template client found on https://www.geeksforgeeks.org/socket-programming-in-java/
 * Using this for now
 */
// A Java program for a Client

import java.net.*;
import java.io.*;

public class Client
{
    // initialize socket and input output streams
    private Socket socket		 = null;
    private DataInputStream input = null;
    private DataOutputStream out	 = null;
    private String line = "";
    private GUI mainMenu = new GUI();

    // constructor to put ip address and port
    public Client(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
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
                        System.out.println("Put your message here.");
                        line = input.readLine();
                        out.writeUTF(line);
                        break;
                    }case "2": {
                        System.out.println("Currently not implemented");
                        break;
                    }case "3":
                        line = "Over";
                        out.writeUTF(line);
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
