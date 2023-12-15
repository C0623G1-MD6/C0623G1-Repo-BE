package com.example.fashion.repository.notificationRepository;

import com.example.fashion.model.notification.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface INotificationRepository extends JpaRepository<Notification,Integer> {
    @Query(value = " select notifi.id as id , notifi.title as title, notifi.content as content, notifi.deleted as deleted, notifi.notice_posting_date " +
            " from notification notifi " +
            " join notication_details nodt on notifi.id = nodt.notification_id " +
            " join  employees emp on nodt.employee_id = emp.id " +
            " join accounts acc on emp.account_id = acc.id " +
            " join user_roles usr on acc.id = usr.user_id " +
            " join roles ro on usr.role_id = ro.id " +
            " WHERE (usr.role_id = 1 OR usr.role_id = 3 )  ", nativeQuery = true)
    Page<Notification> findAllEmployee(Pageable pageable);

    @Query(value = " select notifi.id as id , notifi.title as title, notifi.content as content, notifi.deleted as deleted, notifi.notice_posting_date " +
            " from notification notifi " +
            " join notication_details nodt on notifi.id = nodt.notification_id " +
            " join  employees emp on nodt.employee_id = emp.id " +
            " join accounts acc on emp.account_id = acc.id " +
            " join user_roles usr on acc.id = usr.user_id " +
            " join roles ro on usr.role_id = ro.id " +
            " WHERE (usr.role_id = 2 OR usr.role_id = 3 )  ", nativeQuery = true)
    Page<Notification> findAllWarehouse(Pageable pageable);


    @Transactional
    @Modifying
    @Query(value = " INSERT INTO notification (title, content, deleted, notice_posting_date) " +
            " Value (:#{#notification.title},:#{#notification.content},:#{#notification.deleted}, :#{#noticePostingDate}) ", nativeQuery = true)
    void createNotification(Notification notification);
}
