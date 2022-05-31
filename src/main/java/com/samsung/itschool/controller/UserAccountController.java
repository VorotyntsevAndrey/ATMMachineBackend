package com.samsung.itschool.controller;

import com.samsung.itschool.domain.UserAccount;
import com.samsung.itschool.dto.UserAccountDto;
import com.samsung.itschool.mapper.UserAccountMapper;
import com.samsung.itschool.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/useraccounts")
public class UserAccountController {

    private UserAccountService userAccountService;
    private UserAccountMapper userAccountMapper;

    public UserAccountController(UserAccountService userAccountService, UserAccountMapper userAccountMapper) {
        this.userAccountService = userAccountService;
        this.userAccountMapper = userAccountMapper;
    }

    @PostMapping
    public UserAccountDto create(@RequestBody UserAccountDto userAccountDto) {
        UserAccount userAccount = userAccountMapper.fromDto(userAccountDto);
        UserAccount createdUserAccount = userAccountService.create(userAccount);
        UserAccountDto userAccountDtoResult = userAccountMapper.toDto(createdUserAccount);
        return userAccountDtoResult;
    }

    @GetMapping("/{id}")
    public UserAccountDto findById(@PathVariable("id") Long id) {
        UserAccount userAccount = userAccountService.findById(id);
        UserAccountDto userAccountDto = userAccountMapper.toDto(userAccount);
        return userAccountDto;
    }

    @GetMapping
    public List<UserAccountDto> findAll() {
        List<UserAccount> userAccounts = userAccountService.findAll();
        List<UserAccountDto> userAccountDtoList = userAccountMapper.toDtoList(userAccounts);
        return userAccountDtoList;
    }

    @PutMapping
    public UserAccountDto update(@RequestBody UserAccountDto userAccountDto) {
        UserAccount userAccount = userAccountMapper.fromDto(userAccountDto);
        UserAccount updatedUserAccount = userAccountService.update(userAccount);
        UserAccountDto userAccountDtoResult = userAccountMapper.toDto(updatedUserAccount);
        return userAccountDtoResult;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userAccountService.deleteById(id);
    }
}
