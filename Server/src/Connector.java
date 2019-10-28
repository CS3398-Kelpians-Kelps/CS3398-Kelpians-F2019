import java.sql.*;
import java.util.*;

class Connector {
  private static final String dbUrl = "jdbc:mysql://localhost:3306/login";
  private static final String username = "root";
  private static final String password = "kelpians";
  Connection myConnection;
  Statement myStatement;

  public Connector() {
    try {
      //get connection
      Class.forName("com.mysql.jdbc.Driver");
      myConnection = DriverManager.getConnection(dbUrl, username, password);
      //create statement obj
      myStatement = myConnection.createStatement();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  //Modified to allow Login
  public String query(String field, String table) {
    try {
      //create sql statement
      String sql = "Select " + field + " from " + table;
      //execute query
      ResultSet myResultSet=myStatement.executeQuery(sql);
      //output result
      String results = "";
      while(myResultSet.next()) {
        results += myResultSet.getString(field) + "~";
      }
      return results;
    } catch(Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  public void update(String table, String row, String id, String newValue) {
    try {
      //create sql Statement
      String sql = "update " + table + " set " + row + " = " + newValue + " where id = " + id;
      //countUpdated is number of rows updated
      int countUpdated = myStatement.executeUpdate(sql);
      System.out.println(countUpdated + " records affected.");
      query("*", "fake_data");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void delete(String table, String field, String key) {
    try {
      String sqlDelete = "delete from " + table + " where "+field+" = " + key;
      int countDeleted = myStatement.executeUpdate(sqlDelete);
      //System.out.println(countDeleted + " records deleted.");
      //query("*", "fake_data");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void insert(String table, String field, String values) {
    try {
      String sqlInsert = "insert into " + table + " (" + field+ ") values ("+values+")";
      //System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
      int countInserted = myStatement.executeUpdate(sqlInsert);
      //System.out.println(countInserted + " records inserted.\n");
      //query("*", "fake_data");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

/**
  public void driver(Connector connection) {
    Scanner scan = new Scanner(System.in);

    boolean run = true;
    while (run) {
      System.out.println("Enter 1 for Query\nEnter 2 for update\nEnter 3 for insert\nEnter 4 for delete\n5 to exit");
      int choice = scan.nextInt();
      scan.nextLine();
      switch(choice) {
        case 1:
          System.out.println("Enter field(s) to query");
          String queryField = scan.nextLine();
          connection.query(queryField, "fake_data");
          break;
        case 2:
          System.out.println("Enter field(s) to update");
          String updateField = scan.nextLine();
          System.out.println("Enter new value");
          String updateValue = scan.nextLine();
          System.out.println("Enter id ");
          String updateID = scan.nextLine();
          connection.update("fake_data", updateField, updateID, updateValue);
          break;
        case 3:
          //connection.insert("fake_data", "'name'");
          break;
        case 4:
          //connection.delete("fake_data", "2");
          break;
        case 5:
          run = false;
          break;
        default:
          System.out.println("Choose a better option next time");
          break;
      }
    }
  }
  **/
}
