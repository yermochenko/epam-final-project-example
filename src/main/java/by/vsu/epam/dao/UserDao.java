package by.vsu.epam.dao;

import java.util.List;

import by.vsu.epam.domain.User;

public interface UserDao extends Dao<User> {
    List<User> readAll() throws DaoException;

    User readByLogin(String login) throws DaoException;

    User readByLoginAndPassword(String login, String password) throws DaoException;

    boolean isUserInitiatesTransfers(Long id) throws DaoException;
}
