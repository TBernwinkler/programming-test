package at.celum.exercise.schoolcourses.dao;

import at.celum.exercise.schoolcourses.model.User;

public interface UserDao {

    public int register(final User user);

    public User login (final User user);

    public boolean isAdmin(final String email);
}
