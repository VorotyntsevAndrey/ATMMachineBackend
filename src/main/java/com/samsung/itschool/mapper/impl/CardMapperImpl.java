package com.samsung.itschool.mapper.impl;

import com.samsung.itschool.domain.Card;
import com.samsung.itschool.dto.CardDto;
import com.samsung.itschool.mapper.CardMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardMapperImpl implements CardMapper {
    @Override
    public Card fromDto(CardDto cardDto) {
        Card card = new Card();
        card.setId(cardDto.getId());
        card.setNumber(cardDto.getNumber());
        card.setValidThru(cardDto.getValidThru());
        card.setCardSecurityCode(cardDto.getCardSecurityCode());
        card.setCardType(cardDto.getCardType());
        return card;
    }

    @Override
    public CardDto toDto(Card card) {
        CardDto cardDto = new CardDto();
        cardDto.setId(card.getId());
        cardDto.setNumber(card.getNumber());
        cardDto.setValidThru(card.getValidThru());
        cardDto.setCardSecurityCode(card.getCardSecurityCode());
        cardDto.setCardType(card.getCardType());
        return cardDto;
    }

    @Override
    public List<Card> fromDtoList(List<CardDto> cardDtoList) {
        List<Card> cardList = new ArrayList<>();
        for (CardDto cardDto :
                cardDtoList) {
            cardList.add(fromDto(cardDto));
        }
        return cardList;
    }

    @Override
    public List<CardDto> toDtoList(List<Card> cardList) {
        List<CardDto> cardDtoList = new ArrayList<>();
        for (Card card :
                cardList) {
            cardDtoList.add(toDto(card));
        }
        return cardDtoList;
    }
}
