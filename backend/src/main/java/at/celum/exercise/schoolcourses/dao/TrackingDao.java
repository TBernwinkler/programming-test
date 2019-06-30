package at.celum.exercise.schoolcourses.dao;

import at.celum.exercise.schoolcourses.model.CrudLog;

import java.util.List;


public interface TrackingDao {

    public void saveOperation(final CrudLog log);

    public List<CrudLog> getLogs();

    public void clearLogs();

}
