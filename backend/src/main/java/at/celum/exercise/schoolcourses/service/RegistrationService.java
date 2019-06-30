package at.celum.exercise.schoolcourses.service;

import at.celum.exercise.schoolcourses.dao.RegistrationDao;
import at.celum.exercise.schoolcourses.dao.TrackingDao;
import at.celum.exercise.schoolcourses.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.List;
import java.util.UUID;

@Service
public class RegistrationService extends CRUDLogger {

    private final RegistrationDao registrationDao;

    @Autowired
    public RegistrationService(@Qualifier("crud-mongo") TrackingDao logger,
                               @Qualifier("reg-mongo") RegistrationDao registrationDao) {
        super(logger);
        this.registrationDao = registrationDao;
    }

    public int addRegistration(final Registration registration) {
        super.logOperation(CRUD_OPERATION.CREATE, registration.getStudentId().toString(), OBJECT_TYPE.REGISTRATION, registration.getCourseId());
        return this.registrationDao.addRegistration(registration);
    }

    public List<Registration> getAllRegistrations() {
        super.logOperation(CRUD_OPERATION.READ, null, OBJECT_TYPE.REGISTRATION, "all registrations");
        return registrationDao.selectAllRegistrations();
    }

    public List<Registration> getRegistrationsByStudentId(UUID id) {
        super.logOperation(CRUD_OPERATION.READ, id.toString(), OBJECT_TYPE.REGISTRATION, "all from student");
        return registrationDao.selectReigstrationsByStudentId(id);
    }

    public List<Registration> getRegistrationsByCourseId(UUID id) {
        super.logOperation(CRUD_OPERATION.READ, null, OBJECT_TYPE.REGISTRATION, id.toString());
        return registrationDao.selectRegistrationsByCourse(id);
    }

    public int deleteRegistration(Registration registration) {
        super.logOperation(CRUD_OPERATION.DELETE, registration.getStudentId(), OBJECT_TYPE.REGISTRATION, registration.getCourseId());
        return registrationDao.deleteSpecificRegistration(registration);
    }

    public int deleteRegistrationsByStudentId(UUID id) {
        super.logOperation(CRUD_OPERATION.DELETE, id.toString(), OBJECT_TYPE.REGISTRATION, "all from student");
        return registrationDao.deleteRegistrationByStudentId(id);
    }

    public int deleteRegistrationsByCourseId(UUID id) {
        super.logOperation(CRUD_OPERATION.DELETE, null, OBJECT_TYPE.REGISTRATION, id.toString());
        return registrationDao.deleteRegistrationByCourseId(id);
    }

}
