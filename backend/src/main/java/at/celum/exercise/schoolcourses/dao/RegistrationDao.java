package at.celum.exercise.schoolcourses.dao;

import at.celum.exercise.schoolcourses.model.Registration;

import java.util.List;
import java.util.UUID;

public interface RegistrationDao {

    int addRegistration(final Registration registration);

    List<Registration> selectAllRegistrations();

    List<Registration> selectReigstrationsByStudentId(final UUID studentId);

    List<Registration> selectRegistrationsByCourse(final UUID courseId);

    int deleteSpecificRegistration(final Registration registration);

    int deleteRegistrationByStudentId(final UUID studentId);

    int deleteRegistrationByCourseId(final UUID courseId);
}
