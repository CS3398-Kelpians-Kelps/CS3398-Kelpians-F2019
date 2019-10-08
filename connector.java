import java.sql.*;
import java.util.Scanner;

class Connector {
  private static final String dbUrl = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  private static final String username = "root";
  private static final String password = "kelpians";
  Connection myConnection;
  Statement myStatement;

  public Connector() {
    try {
      //get connection
      this.myConnection = DriverManager.getConnection(dbUrl, username, password);
      //create statement obj
      this.myStatement = myConnection.createStatement();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void query(String field, String table) {
    try {
      //create sql statement
      String sql = "Select " + field + " from " + table;
      //execute query
      ResultSet myResultSet=myStatement.executeQuery(sql);
      //output result
      while(myResultSet.next()) {
        System.out.println("ID: " + myResultSet.getInt("id"));
        System.out.println("Name: " + myResultSet.getString("name"));
      }
      System.out.println("");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void update(String table, String row, String id, String newValue) {
    try {
      //create sql Statement
      String sql = "update " + table + " set " + row + " = " + newValue + " where id = " + id;
      //countUpdated is number of rows updated
      int countUpdated = myStatement.executeUpdate(sql);
      System.out.println(countUpdated + " records affected.");
      query("*", "user");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void delete(String table, String id) {
    try {
      String sqlDelete = "delete from " + table + " where id = " + id;
      int countDeleted = myStatement.executeUpdate(sqlDelete);
      System.out.println(countDeleted + " records deleted.");
      query("*", "user");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void insert(String table, String values) {
    try {
      String sqlInsert = "insert into " + table + " values (NULL, " + values + ")";
      System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
      int countInserted = myStatement.executeUpdate(sqlInsert);
      System.out.println(countInserted + " records inserted.\n");
      query("*", "user");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

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
          connection.query(queryField, "user");
          break;
        case 2:
          System.out.println("Enter field(s) to update");
          String updateField = scan.nextLine();
          System.out.println("Enter new value");
          String updateValue = scan.nextLine();
          System.out.println("Enter id ");
          String updateID = scan.nextLine();
          connection.update("user", updateField, updateID, updateValue);
          break;
        case 3:
          //connection.insert("user", "'name'");
          break;
        case 4:
          //connection.delete("user", "2");
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

  public static void main(String[] args) {
    try {
      Connector connection = new Connector();
      connection.driver(connection);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
