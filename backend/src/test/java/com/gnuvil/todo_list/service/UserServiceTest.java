package com.gnuvil.todo_list.service;

import com.gnuvil.todo_list.domain.LoginRequest;
import com.gnuvil.todo_list.domain.LoginResponse;
import com.gnuvil.todo_list.domain.SignupRequest;
import com.gnuvil.todo_list.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional //rollback 자동
class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    public void 회원추가(){
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail("min@naber.com");
        signupRequest.setName("김민형");
        signupRequest.setPasswd("1234");
        userService.join(signupRequest);
    }
    @Test
    public void findByEmail(){
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail("min@naber.com");
        signupRequest.setName("김민형");
        signupRequest.setPasswd("1234");
        userService.join(signupRequest);
        String email = signupRequest.getEmail();
        Optional<User> findUser = userService.findByEmail(email);
        Assertions.assertThat(signupRequest.getEmail()).isEqualTo(findUser.get().getEmail());

    }

    @Test
    public void login(){
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail("minhyeong123@gmail.com");
        signupRequest.setPasswd("0000");
        signupRequest.setName("김민형");
        userService.join(signupRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("minhyeong123@gmail.com");
        loginRequest.setPasswd("0000");

        LoginResponse login = userService.login(loginRequest);
        Assertions.assertThat(login.getEmail()).isEqualTo("minhyeong123@gmail.com");

        System.out.println("login = " + login.getEmail());

    }


}