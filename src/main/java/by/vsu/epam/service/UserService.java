package by.vsu.epam.service;

import java.util.List;

import by.vsu.epam.domain.User;
import by.vsu.epam.service.exception.ServiceException;

public interface UserService {
    List<User> findAll() throws ServiceException;
}
