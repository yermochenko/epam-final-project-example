package by.vsu.epam.service;

import java.util.List;

import by.vsu.epam.domain.User;
import by.vsu.epam.service.exception.ServiceException;

public interface UserService {
    User findById(Long id) throws ServiceException;

    List<User> findAll() throws ServiceException;

    void save(User user) throws ServiceException;
}
