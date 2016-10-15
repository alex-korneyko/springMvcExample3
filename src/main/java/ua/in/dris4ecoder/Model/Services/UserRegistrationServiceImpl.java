package ua.in.dris4ecoder.Model.Services;

import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.Model.businessObjects.CustomUser;
import ua.in.dris4ecoder.Model.dao.Dao;

/**
 * Created by Alex Korneyko on 13.10.2016 12:14.
 */
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private Dao<CustomUser> dao;

    @Override
    @Transactional
    public boolean checkUserByLogin(String login) {

        return dao.findItemByName(login) != null;
    }

    @Override
    @Transactional
    public boolean checkPassword(String password) {
        return true;
    }

    @Override
    @Transactional
    public boolean registerUser(CustomUser user) {

        if (checkUserByLogin(user.getLogin()))
            return false;

        dao.addItem(user);

        return true;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
