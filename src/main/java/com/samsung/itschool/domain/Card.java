package com.samsung.itschool.domain;

import com.samsung.itschool.domain.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "valid_thru")
    private String validThru;

    @Column(name = "card_security_code")
    private Integer cardSecurityCode;

    @Column(name = "card_type")
    @Enumerated(value = EnumType.STRING)
    private CardType cardType;
}
