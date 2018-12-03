package firstyear.project.models;

public class User {


    private int user_id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String clearance;





    public User() {
    }

    public User(int user_id, String username, String password, String email, String name, String clearance) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.clearance = clearance;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = email;
    }

    public String getClearance() {
        return clearance;
    }

    public void setClearance(String username) {
        this.clearance = clearance;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = name;
    }




    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", clearance='" + clearance + '\'' +
                '}';
    }
}