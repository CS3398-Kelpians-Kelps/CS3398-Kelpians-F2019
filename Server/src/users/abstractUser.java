/* Abstract Class for Different User Types to Extend
   Provides email / password for login and a constructor to set them.
   Current User Roles: Normal = 0, Admin = 1;
*/

public abstract class AbstractUser {
  public String email;
  private String password;
  public Int role;

  User(String email, String password, String role) {
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public Bool isAdmin() {
    return role == 1;
  }
}
