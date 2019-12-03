public class TextListener implements INetworkListener{
	//TAG~DEST~STRING
	public void process(String data, Server server){
		String[] split = data.split("~");
		if(split[0].equals("TXT")){
			server.send(data, split[1]);
		}
	}
}
