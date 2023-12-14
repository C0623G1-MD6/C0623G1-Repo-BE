package com.example.fashion.service.notification;

import com.example.fashion.model.notification.Notification;
import com.example.fashion.repository.notificationRepository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService{
    @Autowired
    private INotificationRepository iNotificationRepository;

    @Override
    public Page<Notification> findAllEmployee(Pageable pageable) {
        return iNotificationRepository.findAllEmployee(pageable);
    }

    @Override
    public Page<Notification> findAllWarehouse(Pageable pageable) {
        return iNotificationRepository.findAllWarehouse(pageable);
    }

    @Override
    public void createNotification(Notification notification) {
        iNotificationRepository.createNotification(notification);
    }

}
