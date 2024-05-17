package com.CashRichUser.CashRichUser.Controller;

import com.CashRichUser.CashRichUser.Entity.User;
import com.CashRichUser.CashRichUser.Service.CoinService;
import com.CashRichUser.CashRichUser.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CoinService coinService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user){
        User newuser=userService.signup(user);
        coinService.saveCoin((int)user.getId());
        return ResponseEntity.ok().body(newuser);
    }

    @PostMapping("/login/{username}/{password}")
    public ResponseEntity<User> logIn(@PathVariable("username") String userName, @PathVariable("password") String password){
        System.out.println(userName+"-----"+password);
        User returnerUser=userService.login(userName,password);
        return ResponseEntity.ok().body(returnerUser);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> signUp(@PathVariable Long userId, @RequestBody User newUser){
        User returnedUser=userService.updateProfile(userId, newUser);
        return ResponseEntity.ok().body(returnedUser);
    }



}
