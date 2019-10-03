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

	public ServerSideClient(IServer server, Socket socket){
		try{
			this.server = server;
			clientSocket = socket;
			IP = clientSocket.getRemoteSocketAddress().toString();
			running = true;
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream());
		}catch(Exception e){System.out.println("ServerSideClient | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	public void send(String data){
		out.println(data);
		out.flush();
	}

	public void run(){
		try{
			server.process(in.readLine());
		}catch(Exception e){System.out.println("ServerSideClient.run | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	public void stop(){
		try{
			running = false;
			in.close();
			out.close();
			clientSocket.close();
		}catch(Exception e){System.out.println("ServerSideClient.stop | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	public String getIP(){
		return IP;
	}

}
