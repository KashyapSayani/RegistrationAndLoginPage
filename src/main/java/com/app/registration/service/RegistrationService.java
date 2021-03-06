package com.app.registration.service;

import com.app.registration.model.User;
import com.app.registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService{

    @Autowired
    private RegistrationRepository registrationRepository;

    public User saveUser(User user) {
        return registrationRepository.save(user);
    }

    public User fetchUserByEmailId(String emailId){
        return registrationRepository.findByEmailId(emailId);
    }
}
