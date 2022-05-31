package com.samsung.itschool.service;

import com.samsung.itschool.domain.Card;

import java.util.List;

public interface CardService {

    Card create(Card card);

    Card findById(Long id);

    List<Card> findAll();

    Card update(Card card);

    void deleteById(Long id);
}
