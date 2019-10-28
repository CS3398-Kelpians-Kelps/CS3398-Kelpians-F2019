import java.util.*;

public class Report{
	String handle;
	int connections;
	ArrayList<String> IPS;
	ArrayList<String> history;
	User user;
	public Report(User user){
		this.user = user;
		IPS = user.getIPs();
		handle = user.getHandle();
		history = user.getHist();
	}

	public String getIPs(){
		return IPS.toString();
	}

	public String getHandle(){
		return handle;
	}

	public String getHist(){
		return history.toString();
	}
}
