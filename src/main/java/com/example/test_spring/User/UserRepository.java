package com.example.test_spring.User;

import com.example.test_spring.User.model.User;
import com.example.test_spring.User.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDto.ResLogin findByEmailAndPassword(String email, String password);
}
