import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args){
		try{
			int port = 1337;
			Server server = new Server(port);
			Thread s = new Thread(server);
			s.start();
		}catch(Exception e){System.out.println("main.main | ERR: " + e.getStackTrace()[1]);}
	}
}
