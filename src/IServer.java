public interface IServer{

	//Send to all machines
	public void broadcast(Object data);

	//Main loop for server
	public void run();

	//Stops server
	public void stop();

	public void login(User user, ServerSideClient ssc);
}
