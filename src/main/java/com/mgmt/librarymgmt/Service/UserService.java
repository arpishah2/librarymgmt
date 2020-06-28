package com.mgmt.librarymgmt.Service;

import com.mgmt.librarymgmt.DataAccessLayer.User;
import com.mgmt.librarymgmt.DataAccessLayer.UserRepository;
import com.mgmt.librarymgmt.Exception.UserNotFoundException;
import com.mgmt.librarymgmt.Util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    UserRepository userRepository;
    UserValidator userValidator = new UserValidator();

    public List<User> getAllUsers() throws UserNotFoundException {
        List<User> users = userRepository.findAll();
        if (users.size() == 0) {
            LOGGER.severe("No users found");
            throw new UserNotFoundException();
        }
        return users;
    }

    public User addUser(User user) {
        if (userValidator.isUserValid(user)) {
            return userRepository.save(user);
        } else {
            LOGGER.severe("User not valid" + user);
            return null;
        }
    }

    public User getUserById(int id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}