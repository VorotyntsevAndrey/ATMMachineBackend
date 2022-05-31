package com.samsung.itschool.controller;

import com.samsung.itschool.domain.Card;
import com.samsung.itschool.dto.CardDto;
import com.samsung.itschool.mapper.CardMapper;
import com.samsung.itschool.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    private CardService cardService;
    private CardMapper cardMapper;

    public CardController(CardService cardService, CardMapper cardMapper) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
    }

    @PostMapping
    public CardDto create(@RequestBody CardDto cardDto) {
        Card card = cardMapper.fromDto(cardDto);
        Card createdCard = cardService.create(card);
        CardDto cardDtoResult = cardMapper.toDto(createdCard);
        return cardDtoResult;
    }

    @GetMapping("/{id}")
    public CardDto findById(@PathVariable("id") Long id) {
        Card card = cardService.findById(id);
        CardDto cardDto = cardMapper.toDto(card);
        return cardDto;
    }

    @GetMapping
    public List<CardDto> findAll() {
        List<Card> cards = cardService.findAll();
        List<CardDto> cardDtoList = cardMapper.toDtoList(cards);
        return cardDtoList;
    }

    @PutMapping
    public CardDto update(@RequestBody CardDto cardDto) {
        Card card = cardMapper.fromDto(cardDto);
        Card updatedCard = cardService.update(card);
        CardDto cardDtoResult = cardMapper.toDto(updatedCard);
        return cardDtoResult;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        cardService.deleteById(id);
    }
}
