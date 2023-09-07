package com.bodrul.momagic.repository;

import com.bodrul.momagic.model.ChargeConfEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChargeConfEntityRepository extends JpaRepository<ChargeConfEntity, Integer> {
    Optional<ChargeConfEntity> findByPrice(int price);
}
