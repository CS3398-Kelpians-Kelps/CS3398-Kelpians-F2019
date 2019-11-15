import java.net.*;
import java.util.*;

public class Server implements IServer, Runnable{

	private int port;
	private boolean running;
	private ServerSocket listener;
	private ArrayList<ServerSideClient> clients;

	//Constructor, configures server for use.
	public Server(int port){
		this.port = port;
		running = true;
		clients = new ArrayList<ServerSideClient>();
	}

	//Sends data to all connected peers
	public void broadcast(String data){
		for(ServerSideClient ssc : clients)
			ssc.send(data);
	}

	//Runs main function of the server, waits for connection then assigns relevant data and creates new ServerSideClient instance and thread
	public void run(){
		try{
			listener = new ServerSocket(port);
			while(running){
				Socket clientSocket = listener.accept();
				ServerSideClient serverSideClient = new ServerSideClient(this, clientSocket);
				clients.add(serverSideClient);
				Thread client = new Thread(serverSideClient);
				client.start();
			}
		}catch(Exception e){System.out.println("Server.run | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	//Shuts down server and closes all active connections
	public void stop(){
		try{
			for(ServerSideClient ssc : clients)
				ssc.stop();
			listener.close();
			running = false;
		}catch(Exception e){System.out.println("Server.stop | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}
}
