package at.celum.exercise.schoolcourses.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Document(collection = "courses")
public class Course {

    @Id
    private final String id;
    @NotBlank
    private final String name;
    @NotBlank
    private final Date date;

    public Course(@JsonProperty("id") String id,
                  @JsonProperty("name") String name,
                  @JsonProperty("date") Date date) {
        this.id = id == null ? UUID.randomUUID().toString() : id;
        this.name = name;
        this.date = date;
    }

    public UUID getId() {
        return UUID.fromString(id);
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}
