package by.vsu.epam.util;

import java.sql.Connection;

import by.vsu.epam.dao.UserDao;
import by.vsu.epam.service.Transaction;
import by.vsu.epam.service.UserService;

public interface ServiceFactory extends AutoCloseable {
    UserService getUserService() throws FactoryException;

    Transaction getTransaction() throws FactoryException;

    UserDao getUserDao() throws FactoryException;

    Connection getConnection() throws FactoryException;
}
