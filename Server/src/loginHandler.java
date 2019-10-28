import java.sql.*;
import java.util.*;
import java.io.*;

public class loginHandler{
	private Connector db;
	public loginHandler(Connector connector){
		db = connector;
	}
	//login
	public boolean login(String username){
		String qry = db.query("Uname", "users");
		String[] split = qry.split("~");
		for(String curr : split){
			if(username.equals(curr)){
				return true;
			}
		}
		return false;
	}
	//add new users
	public void newUser(String Uname){
		//db.insert("users", Uname);
	}
	//Snub for future dev
	public void removeUser(String Uname){}
}
