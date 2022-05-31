package com.samsung.itschool.repository;


import com.samsung.itschool.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findByLogin(String login);
}
