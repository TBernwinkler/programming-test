package at.celum.exercise.schoolcourses.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "logs")
public class CrudLog {

    final private long timestamp;
    @NotBlank
    final private String logMessage;

    public CrudLog(long timestamp, @NotBlank String logMessage) {
        this.timestamp = timestamp;
        this.logMessage = logMessage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getLogMessage() {
        return logMessage;
    }
}
