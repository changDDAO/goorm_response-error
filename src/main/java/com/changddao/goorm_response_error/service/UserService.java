package com.changddao.goorm_response_error.service;
import com.changddao.goorm_response_error.entity.User;
import com.changddao.goorm_response_error.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> findAllGradeASC() {
        return userRepository.findAll(Sort.by("grade"));
    }
    public List<User> findAllGradeDESC() {
        return userRepository.findAll(Sort.by("grade").descending());
    }
    public List<User> findAllEqualGrade(Integer grade) {
        return userRepository.getUsersEqualGrade(grade);
    }
}
