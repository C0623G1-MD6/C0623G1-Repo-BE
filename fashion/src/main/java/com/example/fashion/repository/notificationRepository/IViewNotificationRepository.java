package com.example.fashion.repository.notificationRepository;

import com.example.fashion.model.notification.ViewNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IViewNotificationRepository extends JpaRepository<ViewNotification,Integer> {
    @Query(value = "SELECT vn.* FROM view_notification vn where vn.account_id = :accountId",nativeQuery = true)
    List<ViewNotification> getNotificationIsView(@Param("accountId") Long accountId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO view_notification(account_id,notification_id) VALUES (:accountId,:notificationId)",nativeQuery = true)
    void saveViewNotification(@Param("accountId") Long accountId, @Param("notificationId") Integer id);
}
