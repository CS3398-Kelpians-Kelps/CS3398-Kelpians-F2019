/**
 *
 * Template client found on https://www.geeksforgeeks.org/socket-programming-in-java/
 * Using this for now
 */
// A Java program for a Client

import javax.xml.crypto.Data;
import java.util.*;
import java.net.*;
import java.io.*;

public class Client implements Runnable{
    // initialize socket and input output streams
    private Socket socket		 = null;
    private DataInputStream input = null;
    private PrintWriter out	 = null;
    private String line = "";
    private BufferedReader in = null;
    private boolean running;
    public ArrayList<String> buffer;

    // constructor to put ip address and port
    public Client(String address, int port) {
        // establish a connection
        buffer = new ArrayList<String>();
        try {
           running = true;
            socket = new Socket(address, port);
            //socket.setSoTimeout(3000);
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
    public void sendMessage(String s) throws IOException {
        //System.out.println(s);
        out.println(s);
        //out.flush();
        //System.out.println("Put your message here.");
        //line = input.readLine();
        //out.println(line);
    }
    public void process(String data){
        //out.println(line);
        //line = in.readLine();
        //System.out.println(data);
        buffer.add(data);
    }

    public String getMessage(){
      String ret = "";
      for(String str : buffer)
         ret = ret + str + '\n';
      return ret;
   }

    public void run(){
      while(running){
         //System.out.println("Running");
         try{
            process(in.readLine());
         }catch(Exception e){}
      }
   }

    public void stop(){
      try{
        running = false;
        input.close();
        out.close();
        socket.close();
        System.exit(0);
     }catch(Exception e){};
    }
    /**public void running() {

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
    }**/
}
