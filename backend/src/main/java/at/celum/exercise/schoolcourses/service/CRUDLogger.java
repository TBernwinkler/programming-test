package at.celum.exercise.schoolcourses.service;

import at.celum.exercise.schoolcourses.dao.TrackingDao;
import at.celum.exercise.schoolcourses.model.CrudLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class CRUDLogger {

    protected TrackingDao logger;

    protected enum CRUD_OPERATION {
        CREATE,
        READ,
        UPDATE,
        DELETE
    }

    protected enum OBJECT_TYPE {
        STUDENT,
        COURSE,
        REGISTRATION,
        USER
    }

    @Autowired
    public CRUDLogger(@Qualifier("crud-mongo") TrackingDao logger) {
        this.logger = logger;
    }

    protected void logOperation(CRUD_OPERATION operation, final String actorId,
                                OBJECT_TYPE type, final String objectId) {
        String logMessage = actorId;
        switch (operation) {
            case CREATE:
                logMessage += " CREATED ";
                break;
            case READ:
                logMessage += " REQUESTED ";
                break;
            case UPDATE:
                logMessage += " UPDATED ";
                break;
            case DELETE:
                logMessage += " DELETED ";
                break;
        }

        switch (type) {
            case STUDENT:
                logMessage += "STUDENT with ID: ";
                break;
            case COURSE:
                logMessage += "COURSE with ID: ";
                break;
            case REGISTRATION:
                logMessage += "REGISTRATION with ID: ";
                break;
        }

        logMessage += objectId;
        logger.saveOperation(new CrudLog(System.currentTimeMillis(), logMessage));
    }

}
