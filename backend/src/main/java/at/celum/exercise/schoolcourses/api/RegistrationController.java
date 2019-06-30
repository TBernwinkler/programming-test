package at.celum.exercise.schoolcourses.api;

import at.celum.exercise.schoolcourses.model.Registration;
import at.celum.exercise.schoolcourses.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/celum/registration")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public void addRegistration(@Valid @NotNull @RequestBody Registration registration) {
        this.registrationService.addRegistration(registration);
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return this.registrationService.getAllRegistrations();
    }

    @GetMapping(path = "studentId={id}")
    public List<Registration> getRegistrationsByStudentId(@PathVariable("id")UUID id) {
        return this.registrationService.getRegistrationsByStudentId(id);
    }

    @GetMapping(path = "courseId={id}")
    public List<Registration> getRegistrationsByCourseId(@PathVariable("id")UUID id) {
        return this.registrationService.getRegistrationsByCourseId(id);
    }

    @DeleteMapping(path = "studentId={student-id}&courseId={course-id}")
    public int deleteRegistrationById(@PathVariable("student-id") UUID studentId,
                                      @PathVariable("course-id") UUID courseId) {
        final Registration registration = new Registration(studentId.toString(), courseId.toString());
        return this.registrationService.deleteRegistration(registration);
    }

    @DeleteMapping(path = "studentId={id}")
    public int deleteRegistrationByStudentId(@PathVariable("id") UUID id) {
        return this.registrationService.deleteRegistrationsByStudentId(id);
    }

    @DeleteMapping(path = "courseId={id}")
    public int deleteRegistrationsByCourseId(@PathVariable("id") UUID id) {
        return this.registrationService.deleteRegistrationsByCourseId(id);
    }



}
