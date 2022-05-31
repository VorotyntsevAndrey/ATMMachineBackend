package com.samsung.itschool.mapper;

import com.samsung.itschool.domain.UserAccount;
import com.samsung.itschool.dto.UserAccountDto;

import java.util.List;

public interface UserAccountMapper {

    UserAccount fromDto(UserAccountDto userAccountDto);

    UserAccountDto toDto(UserAccount userAccount);

    List<UserAccount> fromDtoList(List<UserAccountDto> userAccountDtoList);

    List<UserAccountDto> toDtoList(List<UserAccount> userAccountList);
}

