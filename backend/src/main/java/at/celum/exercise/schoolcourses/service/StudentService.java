package at.celum.exercise.schoolcourses.service;

import at.celum.exercise.schoolcourses.dao.StudentDao;
import at.celum.exercise.schoolcourses.dao.TrackingDao;
import at.celum.exercise.schoolcourses.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService extends CRUDLogger {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("crud-mongo") TrackingDao logger,
                          @Qualifier("student-mongo") StudentDao studentDao) {
        super(logger);
        this.studentDao = studentDao;
    }

    public int addStudent(final Student student) {
        super.logOperation(CRUD_OPERATION.CREATE, "ADMIN", OBJECT_TYPE.STUDENT, student.getId().toString());
        return studentDao.insertStudent(student);
    }

    public List<Student> getAllStudents() {
        super.logOperation(CRUD_OPERATION.READ, "ADMIN", OBJECT_TYPE.STUDENT, "all students");
        return studentDao.selectAllStudents();
    }

    public Optional<Student> getStudentById(final UUID id) {
        super.logOperation(CRUD_OPERATION.READ, null, OBJECT_TYPE.STUDENT, id.toString());
        return studentDao.selectStudentById(id);
    }

    public int deleteStudent(final UUID id) {
        super.logOperation(CRUD_OPERATION.DELETE, "ADMIN", OBJECT_TYPE.STUDENT, id.toString());
        return studentDao.deleteStudentById(id);
    }

    public int updateStudent(final UUID id, final Student newStudent) {
        super.logOperation(CRUD_OPERATION.DELETE, "ADMIN", OBJECT_TYPE.STUDENT, id.toString());
        return studentDao.updateStudentById(id, newStudent);
    }

}
