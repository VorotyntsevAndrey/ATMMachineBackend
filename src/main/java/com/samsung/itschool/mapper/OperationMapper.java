package com.samsung.itschool.mapper;

import com.samsung.itschool.domain.Operation;
import com.samsung.itschool.dto.OperationDto;

import java.util.List;

public interface OperationMapper {

    Operation fromDto(OperationDto operationDto);

    OperationDto toDto(Operation operation);

    List<Operation> fromDtoList(List<OperationDto> operationDtoList);

    List<OperationDto> toDtoList(List<Operation> operationList);
}

