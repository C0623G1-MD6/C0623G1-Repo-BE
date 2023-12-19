package com.example.fashion.service.notification;

import com.example.fashion.model.auth.Role;
import com.example.fashion.model.notification.NoticationDetails;
import com.example.fashion.model.notification.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INotificationService {
    Page<Notification> findAllEmployee(Pageable pageable);
    Page<Notification> findAllWarehouse(Pageable pageable);

    void createNotification( Notification notification);

    Notification findById(Integer id);

    void readNotifi(Integer id);

    int countNotification();

    void addDeatailNotification( Long roleId);


}
