package org.example.validateformdangky.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User implements Validator {
    String lastname;
    String firstname;
    String phonenumber;
    String age;
    String email;

//    Firstname, lastname bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự
//    Phonenumber đúng quy tắc của sđt
//    Age >=18
//    Email đúng quy tắc của email

    public User() {
    }

    public User(String lastname, String firstname, String phonenumber, String age) {
        this.lastname = lastname;

        this.firstname = firstname;
        this.phonenumber = phonenumber;
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //phải implement Validator thì moi ghi de duoc
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }


//    Validation Utils (Validation Utilities) là một tập hợp các công cụ hoặc phương tiện được sử dụng để hỗ trợ việc kiểm tra và xác thực dữ liệu
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String lastname = user.getLastname();
        String firstname = user.getFirstname();
        String phonenumber = user.getPhonenumber();
        String age = user.getAge();
        String email = user.getEmail();
        ValidationUtils.rejectIfEmpty(errors,"lastname","lastname.empty");
        ValidationUtils.rejectIfEmpty(errors,"firstname","firstname.empty");
        ValidationUtils.rejectIfEmpty(errors,"phonenumber","phonenumber.empty");
        ValidationUtils.rejectIfEmpty(errors,"age","age.empty");
        ValidationUtils.rejectIfEmpty(errors,"email","email.empty");
        if ( lastname.length() < 5 && lastname.length() > 45 ) {
            errors.rejectValue("lastname","lastname.length");
        }
        if ( firstname.length() < 5 && firstname.length() > 45) {
            errors.rejectValue("firstname","firstname.length");
        }
        if (!phonenumber.matches("(^&|[0-9]*$)")) {
            errors.rejectValue("phonenumber","phonenumber.matches");
        }

        if (age.length() > 18) {
            errors.rejectValue("age","age.length");
        }
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            errors.rejectValue("email", "email.matches");
        }
    }

}
