package at.celum.exercise.schoolcourses.service;

import at.celum.exercise.schoolcourses.dao.CourseDao;
import at.celum.exercise.schoolcourses.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseService(@Qualifier("course-mongo") CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public int addCourse(final Course course) {
        return courseDao.insertCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseDao.selectAllCourses();
    }

    public Optional<Course> getCourseById(final UUID id) {
        return courseDao.selectCourseById(id);
    }

    public int deleteCourse(final UUID id) {
        return courseDao.deleteCourseById(id);
    }

    public int updateCourse(final UUID id, final Course newCourse) {
        return courseDao.updateCourseById(id, newCourse);
    }
}
