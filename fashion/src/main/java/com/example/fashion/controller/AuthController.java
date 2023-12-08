package com.example.fashion.controller;

import com.example.fashion.dto.ErrorMessage;
import com.example.fashion.dto.Login;
import com.example.fashion.dto.ResponseToken;
import com.example.fashion.model.MyUserDetail;
import com.example.fashion.security.jwt.JwtUtils;
import com.example.fashion.service.impl.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/api")
@RestController
public class AuthController {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private JwtUtils jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        try {
            myUserDetailService.loadUserByUsername(login.getUsername());
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.createToken((MyUserDetail) authentication.getPrincipal());
            return new ResponseEntity<>(new ResponseToken(jwt), HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.UNAUTHORIZED);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new ErrorMessage("Mật khẩu nhập vào không hợp lệ"), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/test2")
    public ResponseEntity<String> test2() {
        return new ResponseEntity<>("Oke", HttpStatus.OK);
    }
}
