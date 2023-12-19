package com.example.fashion.controller.auth;

import com.example.fashion.dto.auth.ChangePassword;
import com.example.fashion.dto.auth.Login;
import com.example.fashion.dto.auth.JwtResponse;
import com.example.fashion.model.auth.Account;
import com.example.fashion.model.auth.MyUserDetail;
import com.example.fashion.security.jwt.JwtUtils;
import com.example.fashion.service.auth.IAccountService;
import com.example.fashion.service.impl.MyUserDetailService;
import com.example.fashion.utils.PasswordGenerator;
import com.example.fashion.utils.JavaMailUtils;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class AuthController {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private JwtUtils jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private JavaMailUtils javaMailUtils;

    /**
     * Handles user login requests.
     *
     * @param login         The login request object.
     * @param bindingResult The result of the validation.
     * @return ResponseEntity containing the JWT response or map error messages.
     * @author: ThanhPV
     * @date: 12/12/2023
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody Login login, BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        login.validate(login, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
        }
        try {
            myUserDetailService.loadUserByUsername(login.getUsername());
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();

            // Tạo đối tượng để trả về
            JwtResponse jwtResponse = new JwtResponse();
            BeanUtils.copyProperties(myUserDetail.getAccount(), jwtResponse);
            // Create Token cho đối tượng trả về;
            String jwt = jwtProvider.createToken((MyUserDetail) authentication.getPrincipal());
            jwtResponse.setAccessToken(jwt);

            // Lấy ra name Role trả về
            List<String> roles = myUserDetail.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());
            jwtResponse.setRoles(roles);
            return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            errors.put("username", e.getMessage());
            return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
        } catch (BadCredentialsException e) {
            errors.put("password", "Mật khẩu không chính xác");
            return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Handles user password change requests.
     *
     * @param changePassword The change password request object.
     * @param bindingResult  The result of the validation.
     * @return ResponseEntity containing success message or error messages.
     * @author: ThanhPV
     * @date: 12/12/2023
     */
    @PatchMapping("/changePassword")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePassword changePassword, BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        if (changePassword.getPasswordNew() == null || changePassword.getPasswordNew().equals("")) {
            errors.put("passwordNew", "Mật khẩu mới không được trống hoặc null");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        changePassword.validate(changePassword, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        try {

            myUserDetailService.loadUserByUsername(changePassword.getUsername());
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(changePassword.getUsername(), changePassword.getPassword()));
            Account account = accountService.findByUsername(authentication.getName()).get();
            account.setPassword(passwordEncoder.encode(changePassword.getPasswordNew()));
            accountService.updatePassword(account);
            return new ResponseEntity<>("Đổi mật khẩu thành công !", HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            errors.put("username", "Username không tồn tại");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } catch (BadCredentialsException e) {
            errors.put("password", "Mật khẩu không chính xác");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Recover password by email.
     *
     * @param emailRecover The email link account.
     * @return ResponseEntity containing success message or error messages.
     * @author: ThanhPV
     * @date: 12/12/2023
     */
    @PostMapping("/recoverPassword")
    public ResponseEntity<String> recoverPassword(@RequestParam String emailRecover ) {
        Account account = accountService.getAccountByEmail(emailRecover);
        if (account == null) {
            return new ResponseEntity<>("Email này không liên kết với tài khoản nào !",HttpStatus.BAD_REQUEST);
        } else {
            try {
                String passwordNew = PasswordGenerator.generateRandomPassword(10);
                account.setPassword(passwordEncoder.encode(passwordNew));
                accountService.updatePassword(account);
                javaMailUtils.sendPasswordNew(emailRecover,account.getUsername(), passwordNew);
                return new ResponseEntity<>("Đặt lại mật khẩu thành công !, vui lòng kiểm tra lại email",HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Đã có lỗi xảy ra, vui lòng thử lại sau",HttpStatus.NOT_FOUND);
            }
        }
    }
}
