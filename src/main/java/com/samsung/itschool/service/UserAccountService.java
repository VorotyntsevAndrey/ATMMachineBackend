package com.samsung.itschool.service;

import com.samsung.itschool.domain.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount create(UserAccount userAccount);

    UserAccount findById(Long id);

    List<UserAccount> findAll();

    UserAccount update(UserAccount userAccount);

    void deleteById(Long id);
}
