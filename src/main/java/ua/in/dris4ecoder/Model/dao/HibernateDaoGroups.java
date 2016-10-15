package ua.in.dris4ecoder.Model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.in.dris4ecoder.Model.businessObjects.UserGroup;

import java.util.List;

/**
 * Created by Alex Korneyko on 15.10.2016 15:15.
 */
public class HibernateDaoGroups implements Dao<UserGroup> {

    private SessionFactory sessionFactory;

    @Override
    public UserGroup findItemByName(String name) {

        Session currentSession = sessionFactory.getCurrentSession();

        @SuppressWarnings("JpaQlInspection")
        Query<UserGroup> query = currentSession.createQuery("select g from UserGroup g where g.groupName = :name");
        query.setParameter("name", name);
        return query.uniqueResult();

    }

    @Override
    public List<UserGroup> findAllItems() {
        return null;
    }

    @Override
    public void deleteItemByName(String name) {

    }

    @Override
    public void addItem(UserGroup name) {

    }

    @Override
    public void editItem(UserGroup item) {

    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {

    }

    @Override
    public void setDaoGroups(Dao<UserGroup> daoGroups) {

    }
}
