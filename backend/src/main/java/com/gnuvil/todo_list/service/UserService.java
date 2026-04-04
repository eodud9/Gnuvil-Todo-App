package com.gnuvil.todo_list.service;

import com.gnuvil.todo_list.config.SecurityConfig;
import com.gnuvil.todo_list.domain.LoginRequest;
import com.gnuvil.todo_list.domain.LoginResponse;
import com.gnuvil.todo_list.domain.SignupRequest;
import com.gnuvil.todo_list.domain.User;
import com.gnuvil.todo_list.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long join(SignupRequest request) { //회원가입
        validateDuplicateEmail(request.getEmail());
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPasswd(passwordEncoder.encode(request.getPasswd()));
        userRepository.save(user);
        return user.getId();
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다"));

        if (!passwordEncoder.matches(request.getPasswd(), user.getPasswd())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        return new LoginResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                "로그인 완료!"
        );
    }

    public User findOne(Long id) {
        User findUser = userRepository.findById(id);
        return findUser;
    }

    public Optional<User> findByEmail(String email) {
        Optional<User> findUser = userRepository.findByEmail(email);
        return findUser;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }


    private void validateDuplicateEmail(String email) {
        userRepository.findByEmail(email)
                .ifPresent( m ->{
                    throw new IllegalStateException("이미 존재하는 이메일 입니다");
                });
    }
}
