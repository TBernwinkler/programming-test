package at.celum.exercise.schoolcourses.api;

import at.celum.exercise.schoolcourses.model.Course;
import at.celum.exercise.schoolcourses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/celum/course")
@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void addStudent(@Valid @NotNull @RequestBody Course course) {
        this.courseService.addCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return this.courseService.getAllCourses();
    }

    @GetMapping(path = "{id}")
    public Course getCourseById(@PathVariable("id")UUID id) {
        return this.courseService.getCourseById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourseById(@PathVariable("id") UUID id) {
        this.courseService.deleteCourse(id);
    }

    @PutMapping(path = "{id}")
    public void updateCourse(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Course courseToUpdate) {
        this.courseService.updateCourse(id, courseToUpdate);
    }
}
