package firstyear.project.services;

import firstyear.project.models.User;
import firstyear.project.repositories.userRepo.UserRepo;
import firstyear.project.repositories.userRepo.UserRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserRepo {

    @Autowired
    UserRepoImpl userRepo;

    @Override
    public boolean createUser(User user) {
        userRepo.createUser(user);
        return false;
    }

    @Override
    public boolean deleteUser(int index) {
        userRepo.deleteUser(index);
        return true;
    }

    @Override
    public boolean updateUser(int index, User user) {
        userRepo.updateUser(index, user);
        return true;
    }

    @Override
    public User getUser(int index) {

        return userRepo.getUser(index);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.getUsers();
    }
}
