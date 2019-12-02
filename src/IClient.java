public interface IClient{

	//Send to client from server
	public void send(Object data);

	//Runs the client
	public void run();

	//Stops the client
	public void stop();

	//Processes data
	public void process(Object data);
}
