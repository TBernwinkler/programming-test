package at.celum.exercise.schoolcourses.api;

import at.celum.exercise.schoolcourses.model.CrudLog;
import at.celum.exercise.schoolcourses.service.LogService;
import at.celum.exercise.schoolcourses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/celum/logs")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LogController {

    private UserService userService;
    private LogService logService;

    @Autowired
    public LogController(UserService userService, LogService logService) {
        this.userService = userService;
        this.logService = logService;
    }

    // FOR TESTING PURPOSES WITHOUT ID, EMAIL etc.
    @GetMapping
    public List<CrudLog> getLogs() {
//        if (userService.isAdmin(email)) {
            return logService.getLogs();
//        }
//        return null;
    }
}
