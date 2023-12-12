//package com.example.fashion.controller;
//
//import com.example.fashion.dto.ChangePassword;
//import com.example.fashion.dto.Login;
//import com.example.fashion.dto.JwtResponse;
//import com.example.fashion.model.Account;
//import com.example.fashion.model.MyUserDetail;
//import com.example.fashion.model.Role;
//import com.example.fashion.security.jwt.JwtUtils;
//import com.example.fashion.service.IAccountService;
//import com.example.fashion.service.impl.MyUserDetailService;
//import jakarta.validation.Valid;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@RequestMapping("/api")
//@RestController
//public class AuthController {
//    @Autowired
//    private MyUserDetailService myUserDetailService;
//
//    @Autowired
//    private JwtUtils jwtProvider;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private IAccountService accountService;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@Valid @RequestBody Login login,BindingResult bindingResult) {
//        Map<String, String> errors = new HashMap<>();
//        try {
//            login.validate(login,bindingResult);
//            if (bindingResult.hasErrors()) {
//                for (FieldError error : bindingResult.getFieldErrors()) {
//                    errors.put(error.getField(), error.getDefaultMessage());
//                }
//                return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
//            }
//            myUserDetailService.loadUserByUsername(login.getUsername());
//            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();
//
//            // Tạo đối tượng để trả về
//            JwtResponse jwtResponse = new JwtResponse();
//            BeanUtils.copyProperties(myUserDetail.getAccount(),jwtResponse);
//            // Create Token cho đối tượng trả về;
//            String jwt = jwtProvider.createToken((MyUserDetail) authentication.getPrincipal());
//            jwtResponse.setAccessToken(jwt);
//
//            // Lấy ra name Role trả về
//            List<String> roles = myUserDetail.getAuthorities().stream()
//                    .map(item -> item.getAuthority())
//                    .collect(Collectors.toList());
//            jwtResponse.setRoles(roles);
//            return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
//        } catch (UsernameNotFoundException e) {
//            errors.put("username",e.getMessage());
//            return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
//        } catch (BadCredentialsException e) {
//            errors.put("password","Mật khẩu không chính xác");
//            return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
//        }
//    }
//
//    @PostMapping("/changePassword")
//    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePassword changePassword,BindingResult bindingResult ) {
//        Map<String, String> errors = new HashMap<>();
//        try {
//            changePassword.validate(changePassword,bindingResult);
//            if (bindingResult.hasErrors()) {
//                for (FieldError error : bindingResult.getFieldErrors()) {
//                    errors.put(error.getField(), error.getDefaultMessage());
//                }
//                return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
//            }
//            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(changePassword.getUsername(), changePassword.getPassword()));
//            Account account = accountService.findByUsername(authentication.getName()).get();
//            account.setPassword(passwordEncoder.encode(changePassword.getPasswordNew()));
//            accountService.saveAccount(account);
//            return new ResponseEntity<>("Đổi mật khẩu thành công !", HttpStatus.OK);
//        } catch (BadCredentialsException e) {
//            errors.put("password","Mật khẩu không chính xác");
//            return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
//        }
//    }
//}
