package com.bodrul.momagic.repository;

import com.bodrul.momagic.model.KeywordDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeywordDetailsEntityRepository extends JpaRepository<KeywordDetailsEntity, Integer> {
        Optional<KeywordDetailsEntity> findByKeyword(String keyword);
}
