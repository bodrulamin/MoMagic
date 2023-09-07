package com.bodrul.momagic.repository;

import com.bodrul.momagic.model.InboxEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InboxEntityRepository extends JpaRepository<InboxEntity, Long> {

    List<InboxEntity> findByStatusOrderById(String status, Pageable pageable);

}
