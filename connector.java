import java.sql.*;

class Connector {
  public static void main(String ... args) {
    try {
      String dbUrl="jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
      String username="root";
      String password="password";
      //get connection
      Connection myConnection=DriverManager.getConnection(dbUrl, username, password);
      //create statement object
      Statement myStatement=myConnection.createStatement();
      //Query
      ResultSet myResultSet=myStatement.executeQuery("Select * from fake_data");
      //process result
      while(myResultSet.next()) {
        System.out.println("Name: " + myResultSet.getString("name"));
      }
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
