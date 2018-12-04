package firstyear.project.repositories.userRepo;


import firstyear.project.models.User;
import firstyear.project.repositories.JdbcFix;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepoImpl extends JdbcFix implements UserRepo {

    @Override
    public boolean createUser(User user) {
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();

            String stringInsert = "INSERT INTO charlie.users VALUE (default, '" + user.getUsername() + "', '" + user.getPassword() + "', '"+ user.getUserEmail() +"','"+ user.getFullName()+"',"+ user.getClearance()+"); ";

            statement.execute(stringInsert);

            return true;
        }catch (Exception e){ e.printStackTrace();} finally {
            closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean deleteUser(int index) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringDelete = "DELETE FROM users WHERE userId =" + index + ";";
            statement.execute(stringDelete);


            return true;
        } catch (Exception e) { e.printStackTrace();} finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(int index, User user) {try {
        // SQL SKAL TJEKKES !!!!!!!!!!!!!!!!
        connection = getConnection();
        Statement statement = connection.createStatement();
        String stringUpdate = "UPDATE Users SET UserName='"+ user.getUsername() +"'" +
                ", userPassword='" + user.getPassword() +"'"+
                ", email='"+ user.getUserEmail()+ "'" +
                ",name='"+ user.getFullName()+"'" +
                ", clearance =" + user.getClearance() +"" + "" +
                " WHERE userId = "+ index +";";

        statement.execute(stringUpdate);

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        return false;
    }

    @Override
    public User getUser(int index) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.users WHERE userId ="+ index +";";

            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();
            result.next();

            User user = new User();

            user.setUserId(result.getInt("userId"));
            user.setUsername(result.getString("userName"));
            user.setPassword(result.getString("userPassword"));
            user.setUserEmail(result.getString("userEmail"));
            user.setFullName(result.getString("fullName"));
            user.setClearance(result.getInt("clearance"));

            return user;

        } catch (Exception e) {
            e.printStackTrace();
            return null;} finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            String stringGet = "SELECT * FROM charlie.users ";

            statement.executeQuery(stringGet);
            ResultSet result = statement.getResultSet();

            while (result.next()){
                User user = new User();
                user.setUserId(result.getInt("userId"));
                user.setUsername(result.getString("userName"));
                user.setPassword(result.getString("userPassword"));
                user.setUserEmail(result.getString("userEmail"));
                user.setFullName(result.getString("fullName"));
                user.setClearance(result.getInt("clearance"));
                users.add(user);
            }
            return users;

        } catch (Exception e) {
            e.printStackTrace();
            return null;} finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
