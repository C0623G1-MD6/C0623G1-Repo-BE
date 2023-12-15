package com.example.fashion.controller.notification;


import com.example.fashion.dto.notificationDto.NotificationDTO;
import com.example.fashion.model.notification.Notification;
import com.example.fashion.service.notification.INotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/notification/")
public class NotificationController {
    @Autowired
    private INotificationService iNotificationService;

    /**
     * author: TriVN
     * date: 12/12/2023
     * goal: notification
     *
     * @param page
     * @param pageSize
     * @return HttpStatus
     */
    @GetMapping("list/sales")
    public ResponseEntity<?> showNotificationEmployee(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "limit", defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Notification> notifications = iNotificationService.findAllEmployee(pageable);
        if (notifications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    /**
     * author: TriVN
     * date: 12/12/2023
     * goal: notification
     *
     * @param page
     * @param pageSize
     * @return HttpStatus
     */
    @GetMapping("list/warehouse")
    public ResponseEntity<?> showNotificationWarehouse(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "limit", defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Notification> notifications = iNotificationService.findAllWarehouse(pageable);
        if (notifications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    /**
     * author: TriVN
     * date: 12/12/2023
     * goal: notification
     *
     * @param notificationDTO
     * @return http status
     */
    @PostMapping("add")
    public ResponseEntity<?> saveWarehouse(@Valid @RequestBody NotificationDTO notificationDTO,
                                                BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        new NotificationDTO().validate(notificationDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        Notification notification = new Notification();
        notification.setNoticePostingDate(notificationDTO.getNoticePostingDate());
        notification.setContent(notificationDTO.getContent());
        notification.setTitle(notificationDTO.getTitle());
        notification.setDeleted(notificationDTO.getDeleted());
        iNotificationService.createNotification(notification);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
