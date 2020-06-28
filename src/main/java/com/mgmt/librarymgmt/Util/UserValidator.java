package com.mgmt.librarymgmt.Util;

import com.mgmt.librarymgmt.DataAccessLayer.User;
import org.springframework.util.StringUtils;

public class UserValidator {
    public boolean isUserValid(User user) {
        return !StringUtils.isEmpty(user.getEmail());
    }
}
