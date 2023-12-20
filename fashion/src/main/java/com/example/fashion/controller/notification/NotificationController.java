package com.example.fashion.controller.notification;


import com.example.fashion.dto.notificationDto.NotificationDTO;
import com.example.fashion.model.auth.MyUserDetail;
import com.example.fashion.model.auth.Role;
import com.example.fashion.model.notification.Notification;
import com.example.fashion.model.notification.ViewNotification;
import com.example.fashion.repository.auth.IRoleRepository;
import com.example.fashion.service.auth.IRoleService;
import com.example.fashion.service.impl.MyUserDetailService;
import com.example.fashion.service.notification.INotificationService;
import com.example.fashion.service.notification.IViewNotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    private IViewNotificationService viewNotificationService;
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private IRoleService roleService;

    @GetMapping("list")
    public ResponseEntity<?> getListNotificationById(@RequestParam Long id,
                                                     @PageableDefault(size = 5,sort = "notice_posting_date", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Notification> notificationList = iNotificationService.getNotificationByAccountId(id,pageable);
        return new ResponseEntity<>(notificationList, HttpStatus.OK);
    }

    @GetMapping("view")
    public ResponseEntity<?> getListNotificationIsView(@RequestParam Long id) {
        List<ViewNotification> notificationList = viewNotificationService.getNotificationIsView(id);
        return new ResponseEntity<>(notificationList, HttpStatus.OK);
    }

    //    @Autowired
//    private IRoleService iRoleService;
//
//    /**
//     * author: TriVN
//     * date: 12/12/2023
//     * goal: notification
//     *
//     * @param page
//     * @param pageSize
//     * @return HttpStatus
//     */
//    @GetMapping("list/sales")
//    public ResponseEntity<?> showNotificationEmployee(
//            @RequestParam(name = "page", defaultValue = "0") int page,
//            @RequestParam(name = "limit", defaultValue = "5") int pageSize) {
//        Pageable pageable = PageRequest.of(page, pageSize);
//        Page<Notification> notifications = iNotificationService.findAllEmployee(pageable);
//        if (notifications.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(notifications, HttpStatus.OK);
//    }
//
//    /**
//     * author: TriVN
//     * date: 12/12/2023
//     * goal: notification
//     *
//     * @param page
//     * @param pageSize
//     * @return HttpStatus
//     */
//    @GetMapping("list/warehouse")
//    public ResponseEntity<?> showNotificationWarehouse(
//            @RequestParam(name = "page", defaultValue = "0") int page,
//            @RequestParam(name = "limit", defaultValue = "5") int pageSize) {
//        Pageable pageable = PageRequest.of(page, pageSize);
//        Page<Notification> notifications = iNotificationService.findAllWarehouse(pageable);
//        if (notifications.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(notifications, HttpStatus.OK);
//    }
//
//    /**
//     * author: TriVN
//     * date: 12/12/2023
//     * goal: notification
//     *
//     * @param notificationDTO
//     * @return http status
//     */
    @PostMapping("add")
    public ResponseEntity<?> saveNotification(@Valid @RequestBody NotificationDTO notificationDTO,
                                              BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        new NotificationDTO().validate(notificationDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        iNotificationService.createNotification(notificationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //
//    /**
//     * TriVN
//     * thay doi trang thai notification
//     *
//     * @param id
//     * @return
//     */
    @PatchMapping("/read/{id}")
    public ResponseEntity<?> readNotification(Principal principal, @PathVariable Integer id) {
        try {
            MyUserDetail myUserDetail = (MyUserDetail) myUserDetailService.loadUserByUsername(principal.getName());
            viewNotificationService.saveViewNotification(myUserDetail.getAccount().getId(), id);
            return new ResponseEntity<>(myUserDetail, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * TriVN
     * đếm số lượng chưa đọc
     *
     * @return
     */
    @GetMapping("list/count")
    public ResponseEntity<?> getCountOfDeletedNotifications(Principal principal) {
        MyUserDetail myUserDetail = (MyUserDetail) myUserDetailService.loadUserByUsername(principal.getName());
        List<Notification> listNotificationNotView = iNotificationService.getNotificationNotViewByAccountId(myUserDetail.getAccount().getId());
        return ResponseEntity.ok(listNotificationNotView);
    }

    /**
     * TriVN
     * hien thi danh sach role
     * @return
     */
    @GetMapping("add/roles")
    public ResponseEntity<?> getRole() {
        List<Role> roleList = roleService.findRole();
        if (roleList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }
}
