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
    private PrintWriter out	 = null;
    private String line = "";
    private BufferedReader in = null;

    // constructor to put ip address and port
    public Client(String address, int port) {
        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new DataInputStream(System.in);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }


    }
    public void sendMessage() throws IOException {
        out.println(line);
        System.out.println("Put your message here.");
        line = input.readLine();
        out.println(line);
    }
    public void receiveMessage() throws IOException {
        out.println(line);
        line = in.readLine();
        System.out.println(line);
    }
    public void exit() throws IOException{
        input.close();
        out.close();
        socket.close();
        System.exit(0);
    }
    public void running() {

        // keep reading until "Over" is input
        try
        {
            line = input.readLine();
            switch(line) {
                case "1":{
                    sendMessage();
                    break;
                }case "2": {
                    receiveMessage();
                    break;
                }case "3":
                    line = "Over";
                    out.println(line);
                    break;
                default:
                    break;
            }

        }
        catch(IOException i)
        {
            System.out.println(i);
        }


        // close the connection
        try
        {
            if(line.equals("Over"))
                exit();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}
