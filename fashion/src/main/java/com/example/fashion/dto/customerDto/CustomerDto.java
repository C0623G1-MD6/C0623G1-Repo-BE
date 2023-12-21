package com.example.fashion.dto.customerDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * method validate
 * create by ThienLCH
 * date 11-12-2023
 * param
 * return
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Validator {
    private Integer id;
    private String customerCode;
    private String name;
    private boolean gender;
    private String birthday;
    private String phone;
    private Integer point;
    private String email;
    private String address;
    private boolean isDeleted;
    private Integer customerTypeId;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    private static final String REGEX_CODE = "^KH-\\d{4}$";
    private static final String REGEX_PHONE = "^0[0-9]{9}$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String REGEX_NAME = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈ" +
            "ẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*$";

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        // check validate for customer's code
        if (customerDto.getCustomerCode() == null) {
            errors.rejectValue("customerCode", "", "Vui lòng nhập");
        } else if (customerDto.getCustomerCode().trim().equals("")) {
            errors.rejectValue("customerCode", "", "Vui lòng nhập");
        } else if (!customerDto.getCustomerCode().matches(REGEX_CODE)) {
            errors.rejectValue("customerCode", "", "Không đúng định dạng, ex: KH-001");
        }
        // check validate for customer's name
        if (customerDto.getName() == null) {
            errors.rejectValue("name", "", "Vui lòng nhập");
        } else if (customerDto.getName().trim().equals("")) {
            errors.rejectValue("name", "", "Vui lòng nhập");
        } else if (customerDto.getName().length() <= 0) {
            errors.rejectValue("name", "", "Không đủ độ dài");
        } else if (customerDto.getName().length() > 100) {
            errors.rejectValue("name", "", "Tên quá dài, không được quá 100 kí tự");
        } else if (!customerDto.getName().matches(REGEX_NAME)) {
            errors.rejectValue("name", "", "Không đúng định dạng hoặc chứa kí tự đặc biệt");
        }
        // check validate for customer's birthday
        if (customerDto.getBirthday() == null) {
            errors.rejectValue("birthday", "", "Vui lòng nhập");
        } else if (customerDto.getBirthday().trim().equals("")) {
            errors.rejectValue("birthday", "", "Vui lòng nhập");
        } else if (!check5(customerDto.getBirthday())) {
            errors.rejectValue("birthday", "", "Phải lớn hơn 5 tuổi");
        } else if (!check100(customerDto.getBirthday())) {
            errors.rejectValue("birthday", "", "Phải bé hơn 100 tuổi");
        }
        // check validate for customer's email
        if (customerDto.getEmail().trim().equals("")) {
            errors.rejectValue("email", "", "Vui lòng nhập");
        } else if (customerDto.getEmail() == null) {
            errors.rejectValue("email", "", "Vui lòng nhập");
        } else if (!customerDto.getEmail().matches(REGEX_EMAIL)) {
            errors.rejectValue("email", "", "Không đúng định dạng hoặc chứa kí tự đặc biệt");
        } else if (customerDto.getEmail().length() > 100) {
            errors.rejectValue("email", "", "email quá dài, không được quá 100 kí tự");
        }
        // check validate for customer's email
        if (customerDto.getPhone() == null) {
            errors.rejectValue("phone", "", "Vui lòng nhập");
        } else if (customerDto.getPhone().trim().equals("")) {
            errors.rejectValue("phone", "", "Vui lòng nhập");
        } else if (!customerDto.getPhone().matches(REGEX_PHONE)) {
            errors.rejectValue("phone", "", "SĐT bào gồm 10 số ex:012312312");
        }
    }

    public boolean check5(String birthdayCus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(birthdayCus, formatter);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dob, currentDate);
        if (age.getYears() > 5) {
            return true;
        } else return false;
    }

    public boolean check100(String birthdayCus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(birthdayCus, formatter);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dob, currentDate);
        if (age.getYears() < 100) {
            return true;
        } else return false;
    }
}
