public interface IClient{

	//Send to server
	public void send(String data, String dest);

	//Runs the client
	public void run();

	//Stops the client
	public void stop();

}
