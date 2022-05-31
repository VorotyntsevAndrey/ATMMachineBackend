package com.samsung.itschool.service.impl;

import com.samsung.itschool.domain.Card;
import com.samsung.itschool.repository.CardRepository;
import com.samsung.itschool.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card create(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card findById(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        return card.isPresent() ? card.get() : null;
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card update(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }
}
