package com.samsung.itschool.service;

import com.samsung.itschool.domain.Operation;

import java.util.List;

public interface OperationService {

    Operation create(Operation operation);

    Operation create(String operationInfo, String cardNumber, String userAccountLogin);

    Operation findById(Long id);

    List<Operation> findAll();

    Operation update(Operation operation);

    Operation update(Long id, String newOperationInfo, String newCardNumber, String newUserAccountLogin);

    void deleteById(Long id);
}
