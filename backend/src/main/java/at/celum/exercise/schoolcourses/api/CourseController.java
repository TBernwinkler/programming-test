package at.celum.exercise.schoolcourses.api;

import at.celum.exercise.schoolcourses.model.Course;
import at.celum.exercise.schoolcourses.model.Registration;
import at.celum.exercise.schoolcourses.service.CourseService;
import at.celum.exercise.schoolcourses.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/celum/course")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private final CourseService courseService;
    private final RegistrationService registrationService;

    @Autowired
    public CourseController(CourseService courseService, RegistrationService registrationService) {
        this.courseService = courseService;
        this.registrationService = registrationService;
    }

    @PostMapping
    public void addCourse(@Valid @NotNull @RequestBody Course course) {
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

    @GetMapping(path = "student={id}")
    public List<Course> getCoursesByStudent(@PathVariable("id") UUID id) {
        List<Registration> registrations = this.registrationService.getRegistrationsByStudentId(id);
        List<Course> courses = new ArrayList<>();
        for (Registration r : registrations) {
            Optional<Course> c = this.courseService.getCourseById(UUID.fromString(r.getCourseId()));
            courses.add(c.orElse(null));
        }
        return courses;
    }
}
