package com.example.fashion.repository.notificationRepository;

import com.example.fashion.model.auth.Role;
import com.example.fashion.model.notification.Notification;
import com.example.fashion.model.notification.ViewNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Integer> {
    /**
     * TriVN
     * danh sach
     * @param pageable
     * @return
     */
    @Query(value = " select notifi.id as id , notifi.title as title, notifi.content as content, notifi.deleted as deleted, notifi.notice_posting_date " +
            " from notification notifi " +
            " join notication_details nodt on notifi.id = nodt.notification_id " +
            " join roles ro on nodt.roles_id = ro.id  ", nativeQuery = true)
    Page<Notification> findAllEmployee(Pageable pageable);

    @Query(value = " select notifi.id as id , notifi.title as title, notifi.content as content, notifi.deleted as deleted, notifi.notice_posting_date " +
            " from notification notifi " +
            " join notication_details nodt on notifi.id = nodt.notification_id " +
            " join roles ro on nodt.roles_id = ro.id " +
            " where nodt.roles_id = 2 or nodt.roles_id 3 ", nativeQuery = true)
    Page<Notification> findAllWarehouse(Pageable pageable);

    /**
     * TriVN
     * them moi notification
     * @param notification
     */
    @Transactional
    @Modifying
    @Query(value = " INSERT INTO notification (title, content, deleted, notice_posting_date) " +
            " Value (:#{#notification.title},:#{#notification.content},:#{#notification.deleted}, CURRENT_TIMESTAMP()) ", nativeQuery = true)
    void createNotification(Notification notification);


    /**
     * TriVN
     * set gia tri deleted
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value = " UPDATE notification set deleted = 0 where id = :id ", nativeQuery = true)
    void readNotifi(@Param("id") Integer id);

    /**
     * TriVN
     * tim id
     * @param id
     * @return
     */
    @Query(value = " select * from notification where id = :id ", nativeQuery = true)
    Notification findByIdNotifi(@Param("id") Integer id);

    /**
     * TriVN
     * dem so luong thong báo chưa đọc
     * @return
     */
    @Query(value = " SELECT COUNT(*) FROM notification WHERE deleted = 1 ", nativeQuery = true)
    int countDeletedNotifications();

    @Transactional
    @Modifying
    @Query(value = " INSERT INTO notication_details (notification_id, roles_id) VALUES ((SELECT MAX(id) FROM notification), :#{#roleId}) ", nativeQuery = true)
    void createNotificationDetail(@Param("roleId") Long roleId);

    @Query(value = " select * from roles ", nativeQuery = true)
    List<Role> findRole();

    @Query(value = "SELECT n.id, n.content, n.role_id, n.notice_posting_date, n.title FROM notification n JOIN user_roles ur ON ur.role_id = n.role_id JOIN accounts a ON a.id = ur.user_id WHERE a.id = :accountId",
            countQuery = "SELECT COUNT(n.id) FROM notification n JOIN user_roles ur ON ur.role_id = n.role_id JOIN accounts a ON a.id = ur.user_id WHERE a.id = :accountId",nativeQuery = true)
    Page<Notification> getNotificationByAccountId(@Param("accountId") Long accountId, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `notification` (`content`, `role_id`, `notice_posting_date`, `title`) VALUES (:content,:roleId,:noticePostingDate,:title)",nativeQuery = true)
    void createNotification(@Param("content") String content,@Param("roleId") Long roleId,@Param("noticePostingDate") String noticePostingDate,@Param("title") String title);

    @Query(value = "SELECT n.id, n.content, n.role_id, n.notice_posting_date, n.title FROM notification n JOIN user_roles ur ON ur.role_id = n.role_id JOIN accounts a ON a.id = ur.user_id LEFT JOIN view_notification vn ON vn.notification_id = n.id AND vn.account_id = a.id WHERE a.id = :accountId AND vn.view_notification_id IS NULL ORDER BY notice_posting_date DESC", nativeQuery = true)
    List<Notification> getNotificationNotViewByAccountId(Long accountId);
}
