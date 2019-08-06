package com.itek.oa.dao;

import com.itek.oa.domain.User;

public interface UserDao {
    int insertUser(User user);

    User checkLogin(User user);
}
