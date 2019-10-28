import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args){
		try{
			int port = 12345;
			//Server server = new Server(port);
			//Thread s = new Thread(server);
			//s.start();
			Connector con = new Connector();
			//loginHandler lH = new loginHandler(con);
			con.delete("users", "Uname", "highlow");
			con.insert("users", "Uname", "Highlow");
			//System.out.println(con.query("Uname", "users"));
		}catch(Exception e){System.out.println("main.main | ERR: " + e.getStackTrace()[1]);}
	}
}
