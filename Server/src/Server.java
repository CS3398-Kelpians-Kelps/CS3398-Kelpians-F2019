import java.net.*;
import java.io.*;

public class Server
{
    //initialize socket and input stream 
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private BufferedReader in       =  null;
    private PrintWriter out     =  null;
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
            in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter( socket.getOutputStream(),true);
            // reads message from client until "Over" is sent 
            while (!line.equals("Over"))
            {

                try
                {
                    line = in.readLine();
                    switch (line) {
                        case "1":
                            line = in.readLine();
                            System.out.println(line);
                            history = history + "\n" + line;
                            break;
                        case "2":
                            /**out.writeUTF(history);*/
                            /**OutputStream os = socket.getOutputStream();
                            OutputStreamWriter osw = new OutputStreamWriter(os);
                            BufferedWriter bw = new BufferedWriter(osw);
                            bw.write(history);
                            System.out.println("Message sent to the client is "+history);
                            bw.flush();*/
                            System.out.println(line);
                            out.println(history);
                            out.flush();

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
        Server server = new Server(1337);
    }
} 