package com.example.fashion.service.notification;

import com.example.fashion.model.notification.ViewNotification;

import java.util.List;

public interface IViewNotificationService {
    List<ViewNotification> getNotificationIsView(Long accountId);

}
