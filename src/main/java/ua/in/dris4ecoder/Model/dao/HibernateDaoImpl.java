package ua.in.dris4ecoder.Model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.in.dris4ecoder.Model.buisnessObjects.CustomUser;

import java.util.List;

/**
 * Created by Alex Korneyko on 13.10.2016 12:28.
 */
public class HibernateDaoImpl implements Dao {

    private SessionFactory sessionFactory;

    @Override
    public CustomUser findUserByLogin(String login) {

        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.find(CustomUser.class, login);
    }

    @Override
    public List<CustomUser> findAllUsers() {
        return null;
    }

    @Override
    public void deleteUserByLogin(String login) {

    }

    @Override
    public void addUser(CustomUser user) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Override
    public void editUser(CustomUser user) {

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
