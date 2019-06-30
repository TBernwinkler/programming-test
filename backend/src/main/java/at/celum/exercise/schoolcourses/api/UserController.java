package at.celum.exercise.schoolcourses.api;

import at.celum.exercise.schoolcourses.model.User;
import at.celum.exercise.schoolcourses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("api/celum/user")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "register")
    public int register(@Valid @NotNull @RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping(path = "login")
    public User login(@Valid @NotNull @RequestBody User user) {
        return userService.login(user);
    }


}
