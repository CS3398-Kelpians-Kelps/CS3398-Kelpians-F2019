import java.sql.*;
import java.util.*;
import java.io.*;

public class AdminData {
	private Connector db;
	public AdminData(Connector connector){
		db = connector;
	}

	public Int logUsers(){
		try {
			Int userCount = 0;
      //create sql statement
      String sql = "Select Uname from users"
      //execute query
      ResultSet myResultSet=myStatement.executeQuery(sql);
      //output result
      while(myResultSet.next()) {
        userCount++;
				System.out.println("Uname: " + myResultSet.getString("Uname"));
      }
      System.out.println("");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

		return userCount;
	}


}
