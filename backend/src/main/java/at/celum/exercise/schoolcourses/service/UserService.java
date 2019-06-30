package at.celum.exercise.schoolcourses.service;

import at.celum.exercise.schoolcourses.dao.UserDao;
import at.celum.exercise.schoolcourses.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(@Qualifier("user-mongo") UserDao userDao) {
        this.userDao = userDao;
    }

    public int register(final User user) {
        return this.userDao.register(user);
    }

    public User login(final User user) {
        return this.userDao.login(user);
    }

    public boolean isAdmin(final String email) {
        return this.userDao.isAdmin(email);
    }
}
