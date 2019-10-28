import java.net.*;
import java.util.*;
import java.io.*;

public class ServerSideClient implements IClient, Runnable{
	private IServer server;
	private boolean running;
	private BufferedReader in;
	private PrintWriter out;
	private Socket clientSocket;
	private String IP;
	
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public ServerSideClient(IServer server, Socket socket){
		try{
			this.server = server;
			clientSocket = socket;
			IP = clientSocket.getRemoteSocketAddress().toString();
			running = true;
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream(),true);
			
			oos = new ObjectOutputStream(clientSocket.getOutputStream());
			ois - new ObjectInputStream(clientSocket.getInputStream());
		}catch(Exception e){System.out.println("ServerSideClient | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	public void send(String data){
		System.out.println(data);
		out.println(data);
		oos.writeObject(data);
	}

	public void run(){
		while(running){
			try{
				process(in.readLine());
				process((String)ois.readObject());
			}catch(Exception e){System.out.println("ServerSideClient.run | Socket closed!"); stop();}
		}
	}

	public void stop(){
		try{
			running = false;
			in.close();
			out.close();
			oos.close();
			ois.close();
			clientSocket.close();
			System.out.println(getIP() +" has disconnected!");
		}catch(Exception e){System.out.println("ServerSideClient.stop | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	public String getIP(){
		return IP;
	}

	public void process(String data){
		server.broadcast(data);
		System.out.println(IP + ": " + data);

	}

}
