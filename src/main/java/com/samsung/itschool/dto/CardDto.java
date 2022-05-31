package com.samsung.itschool.dto;

import com.samsung.itschool.domain.enums.CardType;
import lombok.Data;

@Data
public class CardDto {

    private Long id;

    private String number;

    private String validThru;

    private Integer cardSecurityCode;

    private CardType cardType;
}
