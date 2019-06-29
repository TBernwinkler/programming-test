package at.celum.exercise.schoolcourses.dao;

import at.celum.exercise.schoolcourses.config.SpringMongoConfig;
import at.celum.exercise.schoolcourses.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("course-mongo")
public class CourseMongoDbDao implements CourseDao {

    private MongoOperations connector;

    @Autowired
    public CourseMongoDbDao() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        connector = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    @Override
    public int insertCourse(Course course) {
        connector.save(course);
        return 1;
    }

    @Override
    public List<Course> selectAllCourses() {
        return connector.findAll(Course.class);
    }

    @Override
    public Optional<Course> selectCourseById(UUID id) {
        return Optional.ofNullable(connector.findById(id.toString(), Course.class));
    }

    @Override
    public int deleteCourseById(UUID id) {
        Optional<Course> course = selectCourseById(id);
        if (course.isPresent()) {
            connector.remove(course.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateCourseById(UUID id, Course course) {
        Optional<Course> previous = selectCourseById(id);
        if(previous.isPresent()) {
            Course updated = new Course(id.toString(), course.getName(), course.getDate());
            connector.save(updated);
            return 1;
        }
        return 0;
    }
}
