package com.example.fashion.dto.newsdto;

import com.example.fashion.model.news.NewsCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewsDto implements Validator {
    private Integer id;

    private String name;

    private String content;

    private String image;

    private LocalDateTime dateCreate;

    private boolean deleted;
    private NewsCategory newsCategory;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    private static final String REGEX_NAME = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*$";
    private static final String REGEX_CONTENT = "";

    @Override
    public void validate(Object target, Errors errors) {
        NewsDto newsDto = (NewsDto) target;
//        if (newsDto.getName() == null) {
//            errors.rejectValue("name", "", "Vui lòng nhập");
//        } else if (newsDto.getName().trim().equals("")) {
//            errors.rejectValue("name", "", "Vui lòng nhập");
//        } else if (newsDto.getName().length() == 0) {
//            errors.rejectValue("name", "", "Không đủ độ dài");
//        } else if (newsDto.getName().length() > 200) {
//            errors.rejectValue("name", "", "Tên quá dài, không được quá 200 kí tự");
//        } else if (!newsDto.getName().matches(REGEX_NAME)) {
//            errors.rejectValue("name", "", "Không đúng định dạng hoặc chứa kí tự đặc biệt");
//        }
//        if (newsDto.getContent() == null) {
//            errors.rejectValue("content", "", "Vui lòng nhập");
//        } else if (newsDto.getContent().trim().equals("")) {
//            errors.rejectValue("content", "", "Vui lòng nhập");
//        } else if (newsDto.getContent().length() == 0) {
//            errors.rejectValue("content", "", "Không đủ độ dài");
//        } else if (newsDto.getContent().length() > 2000) {
//            errors.rejectValue("content", "", "Tên quá dài, không được quá 2000 kí tự");
//        } else if (!newsDto.getContent().matches(REGEX_CONTENT)) {
//            errors.rejectValue("content", "", "Không đúng định dạng hoặc chứa kí tự đặc biệt");
//        }
    }
}
