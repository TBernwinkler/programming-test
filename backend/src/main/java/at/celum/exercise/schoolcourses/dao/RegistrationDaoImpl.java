package at.celum.exercise.schoolcourses.dao;

import at.celum.exercise.schoolcourses.config.SpringMongoConfig;
import at.celum.exercise.schoolcourses.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("reg-mongo")
public class RegistrationDaoImpl implements RegistrationDao {

    private MongoOperations connector;

    @Autowired
    public RegistrationDaoImpl() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        connector = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    @Override
    public int addRegistration(Registration registration) {
        connector.save(registration);
        return 1;
    }

    @Override
    public List<Registration> selectAllRegistrations() {
        return connector.findAll(Registration.class);
    }

    @Override
    public List<Registration> selectReigstrationsByStudentId(UUID studentId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("studentId").is(studentId.toString()));
        return connector.find(query, Registration.class);
    }

    @Override
    public List<Registration> selectRegistrationsByCourse(UUID courseId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("courseId").is(courseId.toString()));
        return connector.find(query, Registration.class);
    }

    @Override
    public int deleteSpecificRegistration(Registration registration) {
        Query query = new Query();
        query.addCriteria(Criteria
                .where("studentId").is(registration.getStudentId())
                .and("courseId").is(registration.getCourseId()));
        List<Registration> registrations = connector.find(query, Registration.class);
        if (!registrations.isEmpty()) {
            for (Registration r : registrations) {
                connector.remove(r);
            }
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteRegistrationByStudentId(UUID studentId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("studentId").is(studentId.toString()));
        connector.remove(query, Registration.class);
        return 1;
    }

    @Override
    public int deleteRegistrationByCourseId(UUID courseId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("courseId").is(courseId.toString()));
        connector.remove(query, Registration.class);
        return 1;
    }
}
