
public interface INetworkListener{
	//Called when data is received by server
	public void process(String data, Server server);
}
