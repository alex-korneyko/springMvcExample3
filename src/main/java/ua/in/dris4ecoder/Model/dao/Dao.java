package ua.in.dris4ecoder.Model.dao;

import ua.in.dris4ecoder.Model.buisnessObjects.CustomUser;

import java.util.List;

/**
 * Created by Alex Korneyko on 13.10.2016 12:24.
 */
public interface Dao {

    CustomUser findUserByLogin (String login);

    List<CustomUser> findAllUsers();

    void deleteUserByLogin (String login);

    void addUser (CustomUser user);

    void editUser(CustomUser user);
}
