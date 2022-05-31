package com.samsung.itschool.repository;


import com.samsung.itschool.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByNumber(String number);
}
