//package com.CashRichUser.CashRichUser.Validator;
//
//import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
//import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
//
//public class UserNameValidator extends SpringConstraintValidatorFactory {
//
//
//    public UserNameValidator(AutowireCapableBeanFactory beanFactory) {
//        super(beanFactory);
//    }
//
//    public boolean isValid() {
//        String regex = "^[A-Za-z]\\w{3,16}$";
//        Pattern p = Pattern.compile(regex);
//
//        // If the username is empty
//        // return false
//        if (name == null) {
//            return false;
//        }
//
//        // Pattern class contains matcher() method
//        // to find matching between given username
//        // and regular expression.
//        Matcher m = p.matcher(name);
//
//        // Return if the username
//        // matched the ReGex
//        return m.matches();
//    }
//}
