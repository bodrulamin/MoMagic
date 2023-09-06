package com.bodrul.momagic.repository;

import com.bodrul.momagic.model.OutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutboxEntityRepository extends JpaRepository<OutboxEntity, Long> {
}
