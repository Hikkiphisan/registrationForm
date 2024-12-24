package org.example.validateformdangky.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String lastname;
    String firstname;
    String phonenumber;
    String age;
    String email;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String lastname = user.getLastname();
        String firstname = user.getFirstname();
        String phonenumber = user.getPhonenumber();
        String age = user.getAge();
        String email = user.getEmail();
        ValidationUtils.rejectIfEmpty(errors, "lastname", "lastname.empty");
        ValidationUtils.rejectIfEmpty(errors, "firstname", "firstname.empty");
        ValidationUtils.rejectIfEmpty(errors, "phonenumber", "phonenumber.empty");
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");

        if (lastname.length() < 1 || lastname.length() > 45) {
            errors.rejectValue("lastname", "lastname.length");
        }
        if (firstname.length() < 1 || firstname.length() > 45) {
            errors.rejectValue("firstname", "firstname.length");
        }
        if (!phonenumber.matches("(^&|[0-9]*$)")) {
            errors.rejectValue("phonenumber", "phonenumber.matches");
        }
        if (Integer.parseInt(age) < 18) {
            errors.rejectValue("age", "age.length");
        }
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            errors.rejectValue("email", "email.matches");
        }
    }
}
