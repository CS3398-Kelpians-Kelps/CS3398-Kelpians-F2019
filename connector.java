import java.sql.*;

class Connector {
  String dbUrl;
  String username;
  String password;
  Connection myConnection;
  Statement myStatement;

  public Connector() {
    this.dbUrl = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    this.username = "root";
    this.password = "kelpians";
    try {
      //get connection
      this.myConnection = DriverManager.getConnection(dbUrl, username, password);
      //create statement obj
      this.myStatement = myConnection.createStatement();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  //TODO Add id / row selection
  public void query() {
    try {
      //Query
      ResultSet myResultSet=myStatement.executeQuery("Select * from fake_data");
      //output result
      while(myResultSet.next()) {
        System.out.println("Name: " + myResultSet.getString("name"));
      }
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  //TODO Add id / row selection
  public void update() {
    try {
      //
      String strUpdate = "update fake_data set name = 'new_name' where id = 1";
      //countUpdated is number of rows updated
      int countUpdated = myStatement.executeUpdate(strUpdate);
      System.out.println(countUpdated + " records affected.\n");
      query();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  //TODO Add id / row selection
  public void delete() {
    try {
      String sqlDelete = "delete from fake_data where id = 1";
      System.out.println("The SQL statement is: " + sqlDelete + "\n");  // Echo for debugging
      int countDeleted = myStatement.executeUpdate(sqlDelete);
      System.out.println(countDeleted + " records deleted.\n");
      query();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  //TODO Add id / row selection
  public void insert() {
    try {
      String sqlInsert = "insert into fake_data values (1, 'Name_inserted')";
      System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
      int countInserted = myStatement.executeUpdate(sqlInsert);
      System.out.println(countInserted + " records inserted.\n");
      query();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    try {
      Connector connection = new Connector();
      connection.query();
      connection.update();
      connection.insert();
      connection.delete();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
}