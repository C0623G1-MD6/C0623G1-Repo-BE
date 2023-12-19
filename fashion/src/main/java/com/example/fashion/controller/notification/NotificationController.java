package com.example.fashion.controller.notification;


import com.example.fashion.dto.notificationDto.NotificationDTO;
import com.example.fashion.model.auth.Role;
import com.example.fashion.model.notification.NoticationDetails;
import com.example.fashion.model.notification.Notification;
import com.example.fashion.service.auth.IRoleService;
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
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/notification/")
public class NotificationController {
    @Autowired
    private INotificationService iNotificationService;
    @Autowired
    private IRoleService iRoleService;

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
    public ResponseEntity<?> saveNotification(@Valid @RequestBody NotificationDTO notificationDTO,
                                              BindingResult bindingResult
//                                              ,@RequestParam("roleId") Long roleId
    ) {
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
//        iNotificationService.addDeatailNotification(roleId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * TriVN
     * thay doi trang thai notification
     *
     * @param id
     * @return
     */
    @PatchMapping("list/read/{id}")
    public ResponseEntity<?> readNotification(@PathVariable Integer id) {
        Notification notification = iNotificationService.findById(id);
        if (notification == null) {
            return new ResponseEntity<>("Khong tim thay id", HttpStatus.NOT_FOUND);
        }
        iNotificationService.readNotifi(id);
        return new ResponseEntity<>("Da doc thanh cong", HttpStatus.OK);
    }

    /**
     * TriVN
     * đếm số lượng chưa đọc
     *
     * @return
     */
    @GetMapping("list/count")
    public ResponseEntity<Integer> getCountOfDeletedNotifications() {
        int count = iNotificationService.countNotification();
        return ResponseEntity.ok(count);
    }

    /**
     * TriVN
     * hien thi danh sach role
     * @return
     */
    @GetMapping("add/roles")
    public ResponseEntity<?> getRole() {
        List<Role> roleList = iRoleService.findRole();
        if (roleList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }
}
