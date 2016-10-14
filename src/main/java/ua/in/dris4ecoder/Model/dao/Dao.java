package ua.in.dris4ecoder.Model.dao;

import org.hibernate.SessionFactory;
import ua.in.dris4ecoder.Model.businessObjects.CustomUserImpl;

import java.util.List;

/**
 * Created by Alex Korneyko on 13.10.2016 12:24.
 */
public interface Dao {

    CustomUserImpl findUserByLogin (String login);

    List<CustomUserImpl> findAllUsers();

    void deleteUserByLogin (String login);

    void addUser (CustomUserImpl user);

    void editUser(CustomUserImpl user);

    void setSessionFactory(SessionFactory sessionFactory);
}
