package com.example.jwt.demo.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;


@Configuration
public class CustomValidateException {

    public String validationException(BindingResult bindingResult) {
        String validException;
        StringBuilder sbf = new StringBuilder();
        for (Object object : bindingResult.getAllErrors()) {
            if (object instanceof ObjectError) {
                ObjectError objectError = (ObjectError) object;
                validException = objectError.getDefaultMessage();
                sbf.append(validException);
                sbf.append(" \n ");
            }
        }
        return sbf.toString();
    }

}
