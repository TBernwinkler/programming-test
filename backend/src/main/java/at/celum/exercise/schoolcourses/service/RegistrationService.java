package at.celum.exercise.schoolcourses.service;

import at.celum.exercise.schoolcourses.dao.RegistrationDao;
import at.celum.exercise.schoolcourses.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegistrationService {

    private final RegistrationDao registrationDao;

    @Autowired

    public RegistrationService(@Qualifier("reg-mongo") RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }

    public int addRegistration(final Registration registration) {
        return this.registrationDao.addRegistration(registration);
    }

    public List<Registration> getAllRegistrations() {
        return registrationDao.selectAllRegistrations();
    }

    public List<Registration> getRegistrationsByStudentId(UUID id) {
        return registrationDao.selectReigstrationsByStudentId(id);
    }

    public List<Registration> getRegistrationsByCourseId(UUID id) {
        return registrationDao.selectRegistrationsByCourse(id);
    }

    public int deleteRegistration(Registration registration) {
        return registrationDao.deleteSpecificRegistration(registration);
    }

    public int deleteRegistrationsByStudentId(UUID id) {
        return registrationDao.deleteRegistrationByStudentId(id);
    }

    public int deleteRegistrationsByCourseId(UUID id) {
        return registrationDao.deleteRegistrationByCourseId(id);
    }

}
