package at.celum.exercise.schoolcourses.dao;

import at.celum.exercise.schoolcourses.model.Course;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseDao {

    int insertCourse(final Course course);

    List<Course> selectAllCourses();

    Optional<Course> selectCourseById(final UUID id);

    int deleteCourseById(final UUID id);

    int updateCourseById(final UUID id, final Course course);
}
