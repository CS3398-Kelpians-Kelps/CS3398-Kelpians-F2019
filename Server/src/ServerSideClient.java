import java.net.*;
import java.util.*;

public class ServerSideClient implements IClient, {
	private IServer server;
	private boolean running;
	private BufferedReader in;
	private PrintWriter out;
	private Socket clientSocket;
	private String IP;

	public ServerSideClient(IServer server, Socket socket){
		this.server = server;
		clientSocket = socket;
		IP = clientSocket.getRemoteSocketAddress().toString();
		running = true;
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out = new PrintWriter(clientSocket.getOutputStream());
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
		running = false;
	}

	public String getIP(){
		return IP;
	}

}
