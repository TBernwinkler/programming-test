package at.celum.exercise.schoolcourses.service;

import at.celum.exercise.schoolcourses.dao.TrackingDao;
import at.celum.exercise.schoolcourses.dao.UserDao;
import at.celum.exercise.schoolcourses.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CRUDLogger {

    private UserDao userDao;

    @Autowired
    public UserService(@Qualifier("crud-mongo") TrackingDao logger,
                       @Qualifier("user-mongo") UserDao userDao) {
        super(logger);
        this.userDao = userDao;
    }

    public int register(final User user) {
        super.logOperation(CRUD_OPERATION.CREATE, "ADMIN", OBJECT_TYPE.USER, user.getEmail());
        return this.userDao.register(user);
    }

    public User login(final User user) {
        super.logOperation(CRUD_OPERATION.READ, user.getEmail(), OBJECT_TYPE.USER, "logging in");
        return this.userDao.login(user);
    }

    public boolean isAdmin(final String email) {
        super.logOperation(CRUD_OPERATION.READ, email, OBJECT_TYPE.USER, "checking if admin");
        return this.userDao.isAdmin(email);
    }
}
