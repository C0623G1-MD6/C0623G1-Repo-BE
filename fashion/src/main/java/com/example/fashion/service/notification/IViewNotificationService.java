package com.example.fashion.service.notification;

import com.example.fashion.model.notification.ViewNotification;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IViewNotificationService {
    List<ViewNotification> getNotificationIsView(Long accountId);
    void saveViewNotification(Long accountId,Integer id);
}
