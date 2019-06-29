package at.celum.exercise.schoolcourses.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "registrations")
public class Registration {

    @NotBlank
    private final String studentId;
    @NotBlank
    private final String courseId;

    public Registration(@JsonProperty("studentId") String studentId,
                        @JsonProperty("courseId") String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }
}
