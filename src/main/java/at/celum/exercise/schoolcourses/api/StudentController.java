package at.celum.exercise.schoolcourses.api;

import at.celum.exercise.schoolcourses.model.Student;
import at.celum.exercise.schoolcourses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/celum/student")
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@Valid @NotNull @RequestBody Student student) {
        this.studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable("id") UUID id) {
        return this.studentService.getStudentById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudentById(@PathVariable("id") UUID id) {
        this.studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Student studentToUpdate) {
        this.studentService.updateStudent(id, studentToUpdate);
    }

}
