public interface IClient{
	//Send to client from server
	public void send(String data);

	//Runs the client
	public void run();

	//Stops the client
	public void stop();

}
