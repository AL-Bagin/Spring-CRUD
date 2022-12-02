package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        List<User> allUsers = entityManager.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(int id, User user) {
        User updateUser = entityManager.find(User.class, id);
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setEmail(user.getEmail());
    }

    @Override
    public void delete(int id) {
        User removeUser = entityManager.find(User.class, id);
        entityManager.remove(removeUser);
    }


}
