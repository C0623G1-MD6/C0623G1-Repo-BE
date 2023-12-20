package com.example.fashion.service.notification;

import com.example.fashion.dto.notificationDto.NotificationDTO;
import com.example.fashion.model.notification.Notification;
import com.example.fashion.model.notification.ViewNotification;
import com.example.fashion.repository.notificationRepository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void createNotification( Notification notification) {
        iNotificationRepository.createNotification(notification);
    }

    @Override
    public Notification findById(Integer id) {
        return iNotificationRepository.findByIdNotifi(id);
    }

    @Override
    public void readNotifi(Integer id) {
        iNotificationRepository.readNotifi(id);
    }

    @Override
    public int countNotification() {
        return iNotificationRepository.countDeletedNotifications();
    }



    @Override
    public void addDeatailNotification(Long roleId) {
        iNotificationRepository.createNotificationDetail(roleId);
    }

    @Override
    public Page<Notification> getNotificationByAccountId(Long accountId, Pageable pageable) {
        return iNotificationRepository.getNotificationByAccountId(accountId, pageable);
    }

    @Override
    public void createNotification(NotificationDTO notificationDTO) {
        for (Long roleId: notificationDTO.getRole()) {
            iNotificationRepository.createNotification(notificationDTO.getContent(),roleId,notificationDTO.getNoticePostingDate().toString(),notificationDTO.getTitle());
        }
    }

    @Override
    public List<Notification> getNotificationNotViewByAccountId(Long accountId) {
        return iNotificationRepository.getNotificationNotViewByAccountId(accountId);
    }
}
