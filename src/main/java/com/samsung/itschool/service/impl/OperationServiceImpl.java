package com.samsung.itschool.service.impl;

import com.samsung.itschool.domain.Card;
import com.samsung.itschool.domain.Operation;
import com.samsung.itschool.domain.UserAccount;
import com.samsung.itschool.domain.enums.OperationType;
import com.samsung.itschool.repository.CardRepository;
import com.samsung.itschool.repository.OperationRepository;
import com.samsung.itschool.repository.UserAccountRepository;
import com.samsung.itschool.service.OperationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {

    private OperationRepository operationRepository;
    private CardRepository cardRepository;
    private UserAccountRepository userAccountRepository;

    public OperationServiceImpl(OperationRepository operationRepository, CardRepository cardRepository, UserAccountRepository userAccountRepository) {
        this.operationRepository = operationRepository;
        this.cardRepository = cardRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    @Transactional
    public Operation create(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public Operation create(String operationInfo, String cardNumber, String userAccountLogin) {

        Card card = cardRepository.findByNumber(cardNumber);

        UserAccount userAccount = userAccountRepository.findByLogin(userAccountLogin);

        Operation operation = Operation.builder()
                .date(Date.valueOf("2022-06-01"))
                .operationType(OperationType.BALANCE_CHECK)
                .operationInfo(operationInfo)
                .userAccount(userAccount)
                .card(card)
                .build();

        return operationRepository.save(operation);
    }

    @Override
    public Operation findById(Long id) {
        Optional<Operation> operation = operationRepository.findById(id);
        return operation.isPresent() ? operation.get() : null;
    }

    @Override
    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    @Override
    @Transactional
    public Operation update(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public Operation update(Long id, String newOperationInfo, String newCardNumber, String newUserAccountLogin) {
        Operation operation = Operation.builder()
                .id(id)
                .operationInfo(newOperationInfo)
                .operationType(OperationType.BALANCE_CHECK)
                .card(cardRepository.findByNumber(newCardNumber))
                .userAccount(userAccountRepository.findByLogin(newUserAccountLogin))
                .date(Date.valueOf("2022-06-01"))
                .build();
        return operationRepository.save(operation);
    }

    @Override
    public void deleteById(Long id) {
        operationRepository.deleteById(id);
    }

}
