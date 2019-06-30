package at.celum.exercise.schoolcourses.dao;

import at.celum.exercise.schoolcourses.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {

    int insertStudent(final Student student);

    List<Student> selectAllStudents();

    Optional<Student> selectStudentById(final UUID id);

    int deleteStudentById(final UUID id);

    int updateStudentById(final UUID id, final Student student);

}
