package com.samsung.itschool.mapper.impl;

import com.samsung.itschool.domain.Operation;
import com.samsung.itschool.dto.OperationDto;
import com.samsung.itschool.mapper.CardMapper;
import com.samsung.itschool.mapper.OperationMapper;
import com.samsung.itschool.mapper.UserAccountMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationMapperImpl implements OperationMapper {

    private UserAccountMapper userAccountMapper;
    private CardMapper cardMapper;

    public OperationMapperImpl(UserAccountMapper userAccountMapper, CardMapper cardMapper) {
        this.userAccountMapper = userAccountMapper;
        this.cardMapper = cardMapper;
    }

    @Override
    public Operation fromDto(OperationDto operationDto) {
        Operation operation = new Operation();
        operation.setId(operationDto.getId());
        operation.setDate(operationDto.getDate());
        operation.setOperationType(operationDto.getOperationType());
        operation.setOperationInfo(operationDto.getOperationInfo());
        operation.setUserAccount(userAccountMapper.fromDto(operationDto.getUserAccountDto()));
        operation.setCard(cardMapper.fromDto(operationDto.getCardDto()));
        return operation;
    }

    @Override
    public OperationDto toDto(Operation operation) {
        OperationDto operationDto = new OperationDto();
        operationDto.setId(operation.getId());
        operationDto.setDate(operation.getDate());
        operationDto.setOperationType(operation.getOperationType());
        operationDto.setOperationInfo(operation.getOperationInfo());
        operationDto.setUserAccountDto(userAccountMapper.toDto(operation.getUserAccount()));
        operationDto.setCardDto(cardMapper.toDto(operation.getCard()));
        return operationDto;
    }

    @Override
    public List<Operation> fromDtoList(List<OperationDto> operationDtoList) {
        List<Operation> operationList = new ArrayList<>();
        for (OperationDto operationDto :
                operationDtoList) {
            operationList.add(fromDto(operationDto));
        }
        return operationList;
    }

    @Override
    public List<OperationDto> toDtoList(List<Operation> operationList) {
        List<OperationDto> operationDtoList = new ArrayList<>();
        for (Operation operation :
                operationList) {
            operationDtoList.add(toDto(operation));
        }
        return operationDtoList;
    }
}
