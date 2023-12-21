package com.example.fashion.model.auth;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@Entity
public class PasswordResetToken {
    private static final int EXPIRATION = 600;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @OneToOne(fetch = FetchType.EAGER)
    private Account account;
    private Date expiryDate;
    public PasswordResetToken() {
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }
    private Date calculateExpiryDate(int expiryTimeInSeconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.SECOND, expiryTimeInSeconds);
        return cal.getTime();
    }
}
