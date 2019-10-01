
public interface IServer{

	//Send to all machines
	public void broadcast(String data);

	//Send to one machine
	public void send(String data, String dest);

	//Main loop for server
	public void run();

	//Stops server
	public void stop();
}
