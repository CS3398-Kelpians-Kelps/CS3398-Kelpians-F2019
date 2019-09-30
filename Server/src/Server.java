import java.net.*;
import java.io.*;

public class Server
{
    //initialize socket and input stream 
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
    private DataOutputStream out     =  null;
    private String line = "";
    private String history = "";

    // constructor with port 
    public Server(int port)
    {
        // starts server and waits for a connection 
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket 
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream( new BufferedOutputStream(socket.getOutputStream()));
            // reads message from client until "Over" is sent 
            while (!line.equals("Over"))
            {

                try
                {
                    line = in.readUTF();
                    switch (line) {
                        case "1":
                            line = in.readUTF();
                            System.out.println(line);
                            history += line;
                            break;
                        case "2":
                            /**out.writeUTF(history);*/
                            /**OutputStream os = socket.getOutputStream();
                            OutputStreamWriter osw = new OutputStreamWriter(os);
                            BufferedWriter bw = new BufferedWriter(osw);
                            bw.write(history);
                            System.out.println("Message sent to the client is "+history);
                            bw.flush();*/
                            out.writeUTF(history);

                            //System.out.println("Not implemented yet");
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
            System.out.println("Closing connection");

            // close connection 
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
} 