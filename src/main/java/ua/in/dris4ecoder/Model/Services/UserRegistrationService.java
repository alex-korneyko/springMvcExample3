package ua.in.dris4ecoder.Model.Services;

import ua.in.dris4ecoder.Model.buisnessObjects.CustomUser;

/**
 * Created by Alex Korneyko on 13.10.2016 12:16.
 */
public interface UserRegistrationService {

    boolean checkUserByLogin(String login);

    boolean checkPassword(String password);

    boolean registerUser(CustomUser user);
}
