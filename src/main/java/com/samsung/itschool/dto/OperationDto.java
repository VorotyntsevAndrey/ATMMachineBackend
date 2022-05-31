package com.samsung.itschool.dto;

import com.samsung.itschool.domain.enums.OperationType;
import lombok.Data;

import java.sql.Date;

@Data
public class OperationDto {

    private Long id;

    private Date date;

    private OperationType operationType;

    private String operationInfo;

    private UserAccountDto userAccountDto;

    private CardDto cardDto;
}
