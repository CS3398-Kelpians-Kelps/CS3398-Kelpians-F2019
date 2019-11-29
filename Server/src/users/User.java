import java.util.*;
import java.io.*;

public class User extends AbstractUser{
	ArrayList<String> IPS;
	ArrayList<String> history;
	String Handle;
	int connections;

	public User(String handle,
              String email,
              String password){
    super(email, password, 0);
		Handle = handle;
	}

	public ArrayList<String> getIPs(){
		return IPS;
	}

	public void addIP(String IP){
		IPS.add(IP);
	}

	public String getHandle(){
		return Handle;
	}

	public ArrayList<String> getHist(){
		return history;
	}

	public void addHist(String hist){
		history.add(hist);
	}
}
