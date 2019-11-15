import java.net.*;
import java.util.*;
import java.io.*;

public class ServerSideClient implements IClient, Runnable{ //Server-side client instance, handles IP and thread
	private IServer server;
	private boolean running;
	private BufferedReader in;
	private PrintWriter out;
	private Socket clientSocket;
	private String IP;

	//Constructor, assigns neccessary values and prepared input and output streams
	public ServerSideClient(IServer server, Socket socket){
		try{
			this.server = server;
			clientSocket = socket;
			IP = clientSocket.getRemoteSocketAddress().toString();
			running = true;
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream(),true);
		}catch(Exception e){System.out.println("ServerSideClient | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	//Uses PrintWriter to write to the socket
	public void send(String data){
		out.println(data);
	}

	//The main function of the ServerSideClient. Constantly reads from socket and processes data.
	public void run(){
		while(running){
			try{
				process(in.readLine());
			}catch(Exception e){System.out.println("ServerSideClient.run | Socket closed!"); stop();}
		}
	}

	//Halt case, closes server connections and terminates instance
	public void stop(){
		try{
			running = false;
			in.close();
			out.close();
			clientSocket.close();
		}catch(Exception e){System.out.println("ServerSideClient.stop | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	//Returns IP
	public String getIP(){
		return IP;
	}

	//Calls broadcast function
	public void process(String data){
		server.broadcast(data);
	}
}
