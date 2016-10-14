package ua.in.dris4ecoder.Model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.in.dris4ecoder.Model.businessObjects.CustomUserImpl;

import java.util.List;

/**
 * Created by Alex Korneyko on 13.10.2016 12:28.
 */
@SuppressWarnings("ALL")
public class HibernateDaoImpl implements Dao {

    private SessionFactory sessionFactory;

    @Override
    public CustomUserImpl findUserByLogin(String login) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<CustomUserImpl> query = currentSession.createQuery("select u from CustomUserImpl u where u.login = :login");
        query.setParameter("login", login);

        return query.uniqueResult();
    }

    @Override
    public List<CustomUserImpl> findAllUsers() {
        return null;
    }

    @Override
    public void deleteUserByLogin(String login) {

    }

    @Override
    public void addUser(CustomUserImpl user) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Override
    public void editUser(CustomUserImpl user) {

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
