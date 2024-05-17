package com.CashRichUser.CashRichUser.Repository;

import com.CashRichUser.CashRichUser.Entity.CoinDataResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<CoinDataResponse,Integer> {
}
