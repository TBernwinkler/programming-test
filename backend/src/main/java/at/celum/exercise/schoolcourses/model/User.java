package at.celum.exercise.schoolcourses.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "users")
public class User {

    @NotBlank
    private final String email;
    @NotBlank
    private final String password;
    boolean admin;

    public User(@JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("amdin") boolean admin) {
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }
}
