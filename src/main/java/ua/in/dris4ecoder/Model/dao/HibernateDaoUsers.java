package ua.in.dris4ecoder.Model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.in.dris4ecoder.Model.businessObjects.CustomUser;
import ua.in.dris4ecoder.Model.businessObjects.UserGroup;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex Korneyko on 13.10.2016 12:28.
 */
public class HibernateDaoUsers implements Dao<CustomUser> {

    private SessionFactory sessionFactory;
    private BCryptPasswordEncoder passwordEncoder;
    private Dao<UserGroup> daoGroups;

    @Override
    public CustomUser findItemByName(String login) {

        Session currentSession = sessionFactory.getCurrentSession();

        @SuppressWarnings("JpaQlInspection")
        Query<CustomUser> query = currentSession.createQuery("select u from CustomUser u where u.login = :login");
        query.setParameter("login", login);

        return query.uniqueResult();
    }

    @Override
    public List<CustomUser> findAllItems() {
        return null;
    }

    @Override
    public void deleteItemByName(String name) {

    }

    @Override
    public void addItem(CustomUser user) {

        Session currentSession = sessionFactory.getCurrentSession();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserGroup userGroup = daoGroups.findItemByName("Users");
        user.setUserGroups(Arrays.asList(userGroup));
        currentSession.save(user);
    }

    @Override
    public void editItem(CustomUser user) {

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void setDaoGroups(Dao<UserGroup> daoGroups) {
        this.daoGroups = daoGroups;
    }


}
