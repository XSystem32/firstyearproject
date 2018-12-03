package firstyear.project.services;

import firstyear.project.models.User;
import firstyear.project.repositories.userRepo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserRepo {
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
