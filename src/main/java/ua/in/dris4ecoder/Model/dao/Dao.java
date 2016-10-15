package ua.in.dris4ecoder.Model.dao;

import org.hibernate.SessionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.in.dris4ecoder.Model.businessObjects.CustomUser;
import ua.in.dris4ecoder.Model.businessObjects.UserGroup;

import java.util.List;

/**
 * Created by Alex Korneyko on 13.10.2016 12:24.
 */
public interface Dao<T> {

    T findItemByName(String name);

    List<T> findAllItems();

    void deleteItemByName (String name);

    void addItem(T name);

    void editItem(T item);

    void setSessionFactory(SessionFactory sessionFactory);

    void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder);

    void setDaoGroups(Dao<UserGroup> daoGroups);
}
