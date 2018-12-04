package firstyear.project.models;

public class User {


    private int userId;
    private String username;
    private String password;
    private String userEmail;
    private String fullName;
    private int clearance;





    public User() {
    }

    public User(int userId, String username, String password, String userEmail, String fullName, int clearance) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userEmail = userEmail;
        this.fullName = fullName;
        this.clearance = clearance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getClearance() {
        return clearance;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", fullName='" + fullName + '\'' +
                ", clearance='" + clearance + '\'' +
                '}';
    }
}