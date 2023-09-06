package com.bodrul.momagic.repository;

import com.bodrul.momagic.model.AppConfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppConfEntityRepository extends JpaRepository<AppConfEntity, Integer> {
}
