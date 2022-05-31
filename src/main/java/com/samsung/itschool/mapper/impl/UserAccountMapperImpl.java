package com.samsung.itschool.mapper.impl;

import com.samsung.itschool.domain.UserAccount;
import com.samsung.itschool.dto.UserAccountDto;
import com.samsung.itschool.mapper.UserAccountMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAccountMapperImpl implements UserAccountMapper {
    @Override
    public UserAccount fromDto(UserAccountDto userAccountDto) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(userAccountDto.getId());
        userAccount.setName(userAccountDto.getName());
        userAccount.setLogin(userAccountDto.getLogin());
        userAccount.setPassword(userAccountDto.getPassword());
        userAccount.setSecretWord(userAccountDto.getSecretWord());
        userAccount.setBirthDate(userAccountDto.getBirthDate());
        userAccount.setPassportInfo(userAccountDto.getPassportInfo());
        return userAccount;
    }

    @Override
    public UserAccountDto toDto(UserAccount userAccount) {
        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setId(userAccount.getId());
        userAccountDto.setName(userAccount.getName());
        userAccountDto.setLogin(userAccount.getLogin());
        userAccountDto.setPassword(userAccount.getPassword());
        userAccountDto.setSecretWord(userAccount.getSecretWord());
        userAccountDto.setBirthDate(userAccount.getBirthDate());
        userAccountDto.setPassportInfo(userAccount.getPassportInfo());
        return userAccountDto;
    }

    @Override
    public List<UserAccount> fromDtoList(List<UserAccountDto> userAccountDtoList) {
        List<UserAccount> userAccountList = new ArrayList<>();
        for (UserAccountDto userAccountDto :
                userAccountDtoList) {
            userAccountList.add(fromDto(userAccountDto));
        }
        return userAccountList;
    }

    @Override
    public List<UserAccountDto> toDtoList(List<UserAccount> userAccountList) {
        List<UserAccountDto> userAccountDtoList = new ArrayList<>();
        for (UserAccount userAccount :
                userAccountList) {
            userAccountDtoList.add(toDto(userAccount));
        }
        return userAccountDtoList;
    }
}
