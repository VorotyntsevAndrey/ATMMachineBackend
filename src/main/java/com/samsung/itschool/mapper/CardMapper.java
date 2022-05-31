package com.samsung.itschool.mapper;

import com.samsung.itschool.domain.Card;
import com.samsung.itschool.dto.CardDto;

import java.util.List;

public interface CardMapper {

    Card fromDto(CardDto cardDto);

    CardDto toDto(Card card);

    List<Card> fromDtoList(List<CardDto> cardDtoList);

    List<CardDto> toDtoList(List<Card> cardList);
}

