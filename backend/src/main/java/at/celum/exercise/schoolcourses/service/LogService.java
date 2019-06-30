package at.celum.exercise.schoolcourses.service;

import at.celum.exercise.schoolcourses.dao.TrackingDao;
import at.celum.exercise.schoolcourses.model.CrudLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService extends CRUDLogger {


    public LogService(TrackingDao logger) {
        super(logger);
    }

    public List<CrudLog> getLogs() {
        return logger.getLogs();
    }
}
