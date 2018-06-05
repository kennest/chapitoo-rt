package com.capsule.chapitoolab.Services;

import com.capsule.chapitoolab.models.User;

public interface UserService {

     User findUserByEmail(String email);

     void saveUser(User user);
}
