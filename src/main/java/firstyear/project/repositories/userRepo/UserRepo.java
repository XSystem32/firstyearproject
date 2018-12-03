package firstyear.project.repositories.userRepo;

import firstyear.project.models.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepo {

    boolean createUser(User user);
    boolean deleteUser(int index);
    boolean updateUser(int index, User user);
    User getUser(int index);
    List<User> getUsers();

}