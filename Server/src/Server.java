import java.net.*;
import java.util.*;

public class Server implements IServer, Runnable{

	private int port;
	private running;
	private ServerSocket listener;

	public Server(int port){
		this.IP = IP;
		this.port = port;
		running = true;
	}

	public void broadcast(String data){

	}

	public void send(String data, String dest){

	}

	public void run(){
		try{
			System.out.println("Server is starting!");
			listener = new ServerSocket(port);

			while(running){
				Socket clientSocket = listener.accept();
				
			}
		}catch(Exception e){System.out.println("Server.run | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	public void stop(){

	}

}
