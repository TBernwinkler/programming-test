package at.celum.exercise.schoolcourses.dao;

import at.celum.exercise.schoolcourses.config.SpringMongoConfig;
import at.celum.exercise.schoolcourses.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("student-mongo")
public class StudentMongoDbDao implements StudentDao {

    private MongoOperations connector;

    @Autowired
    public StudentMongoDbDao() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        connector = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    @Override
    public int insertStudent(final Student student) {
        connector.save(student);
        return 1;
    }

    @Override
    public List<Student> selectAllStudents() {
        return connector.findAll(Student.class);
    }

    @Override
    public Optional<Student> selectStudentById(final UUID id) {
        return Optional.ofNullable(connector.findById(id.toString(), Student.class));
    }

    @Override
    public int deleteStudentById(final UUID id) {
        Optional<Student> student = selectStudentById(id);
        if (student.isPresent()) {
            connector.remove(student.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateStudentById(final UUID id, final Student student) {
        Optional<Student> previous = selectStudentById(id);
        if (previous.isPresent()) {
            Student updated = new Student(id.toString(), student.getFirstName(),
                    student.getLastName(), student.getEmail(), student.getPhone());
            connector.save(updated);
            return 1;
        }
        return 0;
    }
}
