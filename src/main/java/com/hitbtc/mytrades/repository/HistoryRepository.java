package com.hitbtc.mytrades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hitbtc.mytrades.model.enums.Currency;
import com.hitbtc.mytrades.model.jpa.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Currency> {

}
