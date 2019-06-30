package at.celum.exercise.schoolcourses.service;

import at.celum.exercise.schoolcourses.dao.StudentDao;
import at.celum.exercise.schoolcourses.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("student-mongo") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addStudent(final Student student) {
        return studentDao.insertStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public Optional<Student> getStudentById(final UUID id) {
        return studentDao.selectStudentById(id);
    }

    public int deleteStudent(final UUID id) {
        return studentDao.deleteStudentById(id);
    }

    public int updateStudent(final UUID id, final Student newStudent) {
        return studentDao.updateStudentById(id, newStudent);
    }

}
