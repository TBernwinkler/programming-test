package at.celum.exercise.schoolcourses.dao;

import at.celum.exercise.schoolcourses.config.SpringMongoConfig;
import at.celum.exercise.schoolcourses.model.CrudLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("crud-mongo")
public class TrackingDaoImpl implements TrackingDao {

    private MongoOperations connector;

    @Autowired
    public TrackingDaoImpl() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        connector = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    @Override
    public void saveOperation(CrudLog log) {
        connector.save(log);
    }

    @Override
    public List<CrudLog> getLogs() {
        return connector.findAll(CrudLog.class);
    }

    @Override
    public void clearLogs() {
        connector.remove(CrudLog.class);
    }
}
