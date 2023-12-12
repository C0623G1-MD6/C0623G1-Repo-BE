package com.example.fashion.service.notification;

import com.example.fashion.model.notification.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INotificationService {
    Page<Notification> findAllEmployee(Pageable pageable);
    Page<Notification> findAllWarehouse(Pageable pageable);

    void createNotification(Notification notification);
}
