package com.example.fashion.service.notification;

import com.example.fashion.dto.notificationDto.NotificationDTO;
import com.example.fashion.model.notification.Notification;
import com.example.fashion.model.notification.ViewNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INotificationService {
    Page<Notification> findAllEmployee(Pageable pageable);
    Page<Notification> findAllWarehouse(Pageable pageable);

    void createNotification( Notification notification);

    Notification findById(Integer id);

    void readNotifi(Integer id);

    int countNotification();

    void addDeatailNotification( Long roleId);
    List<Notification> getNotificationByAccountId(Long accountId);
    void createNotification(NotificationDTO notificationDTO);
    List<Notification> getNotificationNotViewByAccountId(Long accountId);
}
