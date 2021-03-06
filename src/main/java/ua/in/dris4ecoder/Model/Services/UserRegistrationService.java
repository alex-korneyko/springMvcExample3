package ua.in.dris4ecoder.Model.Services;

import ua.in.dris4ecoder.Model.businessObjects.CustomUser;
import ua.in.dris4ecoder.Model.dao.Dao;

/**
 * Created by Alex Korneyko on 13.10.2016 12:16.
 */
public interface UserRegistrationService {

    boolean checkUserByLogin(String login);

    boolean checkPassword(String password);

    boolean registerUser(CustomUser user);

    void setDao(Dao dao);
}
