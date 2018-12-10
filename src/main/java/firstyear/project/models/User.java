package firstyear.project.models;
import java.security.MessageDigest;



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
        this.password = this.hash_password(password);
        this.userEmail = userEmail;
        this.fullName = fullName;
        this.clearance = clearance;
    }

    public String hash_password(String password) {
        try {
            // We create a salt value to ensure nobody can bruteforce the database
            String salt = "thisIsAnAmazingSaltValueWhichMakesItSecure";
            // The salt is appended to the end of the password to make a new unique string only used on this website
            String saltedPassword = password.concat(salt);

            // We use one of the most secure hashing functions (SHA512)
            MessageDigest hasher = MessageDigest.getInstance("SHA-512");
            // The password is hashed through the update function
            hasher.update(saltedPassword.getBytes());

            // Finally the hashed password is converted into a string and returned
            String hashedPassword = new String(hasher.digest());
            return hashedPassword;
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // We should never get to this point unless we have specified a hash algorithm which does not exist
        return null;
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
        this.password = this.hash_password(password);
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