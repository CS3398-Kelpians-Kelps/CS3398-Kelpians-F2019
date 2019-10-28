import java.net.*;
import java.util.*;

public class Server implements IServer, Runnable{

	private int port;
	private boolean running;
	private ServerSocket listener;
	private ArrayList<ServerSideClient> clients;
	private ArrayList<User> users;
	private long startTime;
	//private ArrayList<INetworkListener> listeners;

	public Server(int port){
		this.port = port;
		running = true;
		clients = new ArrayList<ServerSideClient>();
		//listeners.add(new TextListener());
	}

	public String getConnected(){
		String ret = "";
		for(ServerSideClient ssc : clients){
			ret += ssc.getIP() + "\n";
		}
		return ret;
	}

	public void broadcast(String data){
		for(ServerSideClient ssc : clients)
			ssc.send(data);
	}

	public long getUpTime(){
		return System.nanoTime() - startTime;
	}

	public ArrayList<Report> getReport(){
		ArrayList<Report> reports = new ArrayList<Report>();
		for(User u : users){
			reports.add(new Report(u));
		}
		return reports;
	}

	public Report getUserReport(User u){
		return new Report(u);
	}

	public void send(String data, String dest){
		for(ServerSideClient ssc : clients){
			if(ssc.getIP().equals(dest)){
				ssc.send(data);
			}
		}
	}

	/**public void process(String data, ServerSideClient ssc){
		System.out.println(ssc.getIP() + ": " + data);
		broadcast(data);
	}**/

	public void run(){
		try{
			System.out.println("Server is starting!");
			listener = new ServerSocket(port);
			startTime = System.nanoTime();

			while(running){
				Socket clientSocket = listener.accept();
				ServerSideClient serverSideClient = new ServerSideClient(this, clientSocket);
				System.out.println(serverSideClient.getIP() + " has connected!");
				clients.add(serverSideClient);
				Thread client = new Thread(serverSideClient);
				client.start();

			}
		}catch(Exception e){System.out.println("Server.run | ERR: " + e.getStackTrace()[1].getLineNumber());}
	}

	public void stop(){
		try{
			for(ServerSideClient ssc : clients)
				ssc.stop();
			listener.close();
			running = false;
		}catch(Exception e){System.out.println("Server.stop | ERR: " + e.getStackTrace()[1].getLineNumber());}

	}

}
