package com.example.fashion.model.notification;

import com.example.fashion.model.auth.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "view_notification")
public class ViewNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer viewNotificationId;
    @ManyToOne
    private Notification notification;
    @JsonIgnore
    @ManyToOne
    private Account account;
}