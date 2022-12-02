package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> index() {
        return userDao.index();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

}
