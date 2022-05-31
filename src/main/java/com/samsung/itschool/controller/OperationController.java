package com.samsung.itschool.controller;

import com.samsung.itschool.domain.Operation;
import com.samsung.itschool.dto.OperationDto;
import com.samsung.itschool.mapper.OperationMapper;
import com.samsung.itschool.service.OperationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationController {

    private OperationService operationService;
    private OperationMapper operationMapper;

    public OperationController(OperationService operationService, OperationMapper operationMapper) {
        this.operationService = operationService;
        this.operationMapper = operationMapper;
    }

    @PostMapping
    public OperationDto create(@RequestParam String operationInfo,
                               @RequestParam String cardNumber,
                               @RequestParam String userAccountLogin) {

        Operation createdOperation = operationService.create(operationInfo, cardNumber, userAccountLogin);
        OperationDto operationDtoResult = operationMapper.toDto(createdOperation);
        return operationDtoResult;
    }

    @PostMapping("/{id}")
    public OperationDto updateOperationById(
            @PathVariable Long id,
            @RequestParam String newOperationInfo,
            @RequestParam String newCardNumber,
            @RequestParam String newUserAccountLogin
    ) {

        Operation updatedOperation = operationService.update(
                id,
                newOperationInfo,
                newCardNumber,
                newUserAccountLogin
        );

        OperationDto operationDtoResult = operationMapper.toDto(updatedOperation);
        return operationDtoResult;
    }

    @GetMapping("/{id}")
    public OperationDto findById(@PathVariable("id") Long id) {
        Operation operation = operationService.findById(id);
        OperationDto operationDto = operationMapper.toDto(operation);
        return operationDto;
    }

    @GetMapping
    public List<OperationDto> findAll() {
        List<Operation> operations = operationService.findAll();
        List<OperationDto> operationDtoList = operationMapper.toDtoList(operations);
        return operationDtoList;
    }

    @PutMapping
    public OperationDto update(@RequestBody OperationDto operationDto) {
        Operation operation = operationMapper.fromDto(operationDto);
        Operation updatedOperation = operationService.update(operation);
        OperationDto operationDtoResult = operationMapper.toDto(updatedOperation);
        return operationDtoResult;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        operationService.deleteById(id);
    }
}
