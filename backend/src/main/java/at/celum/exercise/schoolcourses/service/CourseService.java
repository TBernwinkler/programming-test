package at.celum.exercise.schoolcourses.service;

import at.celum.exercise.schoolcourses.dao.CourseDao;
import at.celum.exercise.schoolcourses.dao.TrackingDao;
import at.celum.exercise.schoolcourses.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService extends CRUDLogger {

    private final CourseDao courseDao;

    @Autowired
    public CourseService(@Qualifier("crud-mongo") TrackingDao logger,
                         @Qualifier("course-mongo") CourseDao courseDao) {
        super(logger);
        this.courseDao = courseDao;
    }

    public int addCourse(final Course course) {
        super.logOperation(CRUD_OPERATION.CREATE, null, OBJECT_TYPE.COURSE, course.getId().toString());
        return courseDao.insertCourse(course);
    }

    public List<Course> getAllCourses() {
        super.logOperation(CRUD_OPERATION.READ, null, OBJECT_TYPE.COURSE, "all courses");
        return courseDao.selectAllCourses();
    }

    public Optional<Course> getCourseById(final UUID id) {
        super.logOperation(CRUD_OPERATION.READ, null, OBJECT_TYPE.COURSE, id.toString());
        return courseDao.selectCourseById(id);
    }

    public int deleteCourse(final UUID id) {
        super.logOperation(CRUD_OPERATION.DELETE, null, OBJECT_TYPE.COURSE, id.toString());
        return courseDao.deleteCourseById(id);
    }

    public int updateCourse(final UUID id, final Course newCourse) {
        super.logOperation(CRUD_OPERATION.UPDATE, null, OBJECT_TYPE.COURSE, id.toString());
        return courseDao.updateCourseById(id, newCourse);
    }
}
