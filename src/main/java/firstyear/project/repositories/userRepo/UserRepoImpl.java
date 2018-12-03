package firstyear.project.repositories.userRepo;


import firstyear.project.models.User;
import firstyear.project.repositories.JdbcFix;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImpl extends JdbcFix implements UserRepo {

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int index) {
        return false;
    }

    @Override
    public boolean updateUser(int index, User user) {
        return false;
    }

    @Override
    public User getUser(int index) {
        return null;
    }

    @Override
    public List<User> getUser() {
        return null;
    }
}
