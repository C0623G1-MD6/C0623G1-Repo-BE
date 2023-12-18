package com.example.fashion.model.notification;

import com.example.fashion.model.auth.Employee;
import com.example.fashion.model.auth.Role;
import jakarta.persistence.*;

@Entity
public class NoticationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "notification_id", referencedColumnName = "id")
    private Notification notification;

    public NoticationDetails() {
    }

    public NoticationDetails(Integer id, Role role, Notification notification) {
        this.id = id;
        this.role = role;
        this.notification = notification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}