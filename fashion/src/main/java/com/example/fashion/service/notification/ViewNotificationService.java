package com.example.fashion.service.notification;

import com.example.fashion.model.notification.ViewNotification;
import com.example.fashion.repository.notificationRepository.IViewNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewNotificationService implements IViewNotificationService{
    @Autowired
    private IViewNotificationRepository viewNotificationRepository;
    @Override
    public List<ViewNotification> getNotificationIsView(Long accountId) {
        return viewNotificationRepository.getNotificationIsView(accountId);
    }

    @Override
    public void saveViewNotification(Long accountId, Integer id) {
        viewNotificationRepository.saveViewNotification(accountId,id);
    }
}
