package by.vsu.epam.service.logic;

import java.util.List;

import by.vsu.epam.dao.DaoException;
import by.vsu.epam.dao.UserDao;
import by.vsu.epam.domain.User;
import by.vsu.epam.service.UserService;
import by.vsu.epam.service.exception.ServiceException;

public class UserServiceImpl extends BaseService implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(Long id) throws ServiceException {
        try {
            return userDao.read(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findAll() throws ServiceException {
        try {
            return userDao.readAll();
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }
}
