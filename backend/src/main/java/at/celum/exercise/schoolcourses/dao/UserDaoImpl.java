package at.celum.exercise.schoolcourses.dao;

import at.celum.exercise.schoolcourses.config.SpringMongoConfig;
import at.celum.exercise.schoolcourses.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("user-mongo")
public class UserDaoImpl implements UserDao {

    private MongoOperations connector;

    public UserDaoImpl() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        connector = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    @Override
    public int register(User user) {
        connector.save(user);
        return 1;
    }

    @Override
    public User login(User user) {
        List<User> dbUser = getDbUsersByEmail(user.getEmail());
        for (User u : dbUser) {
            if (StringUtils.equals(u.getPassword(), user.getPassword())) {
                return u;
            }
        }
        return null;
    }

    @Override
    public boolean isAdmin(String email) {
        List<User> dbUser = getDbUsersByEmail(email);
        if (dbUser != null && !dbUser.isEmpty()) {
            return dbUser.get(0).isAdmin();
        }
        return false;
    }

    private List<User> getDbUsersByEmail(final String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return connector.find(query, User.class);
    }
}
