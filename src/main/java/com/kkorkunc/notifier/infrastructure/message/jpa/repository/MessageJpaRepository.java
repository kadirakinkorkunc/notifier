package com.kkorkunc.notifier.infrastructure.message.jpa.repository;

import com.kkorkunc.notifier.infrastructure.message.jpa.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageJpaRepository extends JpaRepository<MessageEntity, Long> {

    @Query(value = "SELECT m FROM message m WHERE m.status = ?1 ORDER BY m.id DESC LIMIT ?2")
    List<MessageEntity> getXMessageWithStatus(MessageEntity.Status status, int count);

    List<MessageEntity> findAllByStatus(MessageEntity.Status status);
}
