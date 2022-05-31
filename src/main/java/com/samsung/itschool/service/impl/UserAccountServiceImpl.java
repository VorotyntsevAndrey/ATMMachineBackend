package com.samsung.itschool.service.impl;

import com.samsung.itschool.domain.UserAccount;
import com.samsung.itschool.repository.UserAccountRepository;
import com.samsung.itschool.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository staffRepository;

    public UserAccountServiceImpl(UserAccountRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public UserAccount create(UserAccount userAccount) {
        return staffRepository.save(userAccount);
    }

    @Override
    public UserAccount findById(Long id) {
        Optional<UserAccount> staff = staffRepository.findById(id);
        return staff.isPresent() ? staff.get() : null;
    }

    @Override
    public List<UserAccount> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        return staffRepository.save(userAccount);
    }

    @Override
    public void deleteById(Long id) {
        staffRepository.deleteById(id);
    }
}
