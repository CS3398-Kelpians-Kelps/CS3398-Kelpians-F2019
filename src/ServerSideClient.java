import java.net.*;
import java.lang.*;
import java.util.*;
import java.io.*;

public class ServerSideClient implements IClient, Runnable{ //Server-side client instance, handles IP and thread
	private IServer server;
	private boolean running;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Socket clientSocket;
	private String IP;

	//Constructor, assigns neccessary values and prepared input and output streams
	public ServerSideClient(IServer server, Socket socket){
		try{
			this.server = server;
			clientSocket = socket;
			IP = clientSocket.getRemoteSocketAddress().toString();
			running = true;
			in = new ObjectInputStream(clientSocket.getInputStream());
			out = new ObjectOutputStream(clientSocket.getOutputStream());
		}catch(Exception e){System.out.println("ServerSideClient | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	//Uses ObjectOutputStream to write to the socket
	public void send(Object data){
		try{
			out.writeObject(data);
		}catch(Exception e){System.out.println("SSC Send | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	//The main function of the ServerSideClient. Constantly reads from socket and processes data.
	public void run(){
		while(running){
			try{
				process(in.readObject());
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
	public void process(Object data){
		if(data instanceof User){
			server.login((User) data, this);
		}
		server.broadcast(data);
	}
}
