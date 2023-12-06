package com.changddao.goorm_response_error.service;
import com.changddao.goorm_response_error.entity.User;
import com.changddao.goorm_response_error.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public Long joinUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
    public void updateUsername(Long id, String username) {
        userRepository.findById(id).ifPresent(user -> user.changeUsername(username));
    }
    public void updateGrade(Long id, Integer grade) {
        userRepository.findById(id).ifPresent(user -> user.changeGrade(grade));
    }
}
