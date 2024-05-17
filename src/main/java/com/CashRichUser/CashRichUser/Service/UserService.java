package com.CashRichUser.CashRichUser.Service;

import com.CashRichUser.CashRichUser.Entity.User;
import com.CashRichUser.CashRichUser.Exception.EmailAlreadyPresentException;
import com.CashRichUser.CashRichUser.Exception.PassworNotCorrectException;
import com.CashRichUser.CashRichUser.Exception.UserNameAlreadyPresentException;
import com.CashRichUser.CashRichUser.Exception.UserIncorrectException;
import com.CashRichUser.CashRichUser.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User login(String userName, String password) {
        User user = userRepository.findByUsername(userName);
        if(user==null){
            throw new UserIncorrectException("User is not Correct!! Please Try Again!!");
        }

            if(!passwordEncoder.matches(password,user.getPassword())){
            throw new PassworNotCorrectException("Password Not Correct!! Please Try Again!!");
        }

    return user;
    }

    public User signup(User user){
        Optional<User> isEmailPresent= Optional.ofNullable(userRepository.findByEmail(user.getEmail()));
        Optional<User> isUserNamePresent= Optional.ofNullable(userRepository.findByUsername(user.getUserName()));

        if(isEmailPresent.isPresent()){
            throw new EmailAlreadyPresentException("Email is already present!! Please another email");
        }
        if(isUserNamePresent.isPresent()){
            throw new UserNameAlreadyPresentException("User name is already taken!! Please try another");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateProfile(Long userId,User newUser){
        User checkUser =userRepository.findById(userId).orElseThrow(()->new UserIncorrectException("No User found with this user name"));
            checkUser.setFirstName(newUser.getFirstName());


            checkUser.setLastName(newUser.getLastName());


            checkUser.setMobile(newUser.getMobile());


            checkUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        return userRepository.save(checkUser);
    }
}
