package com.app.registration.controller;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registerUser")
    public User RegisterUser(@RequestBody User user) throws Exception {

        String tempEmailid = user.getEmailId();
        if (tempEmailid != null &&  !"".equals(tempEmailid)) {
            User userObj = registrationService.fetchUserByEmailId(tempEmailid);
            if (userObj != null) {
                System.out.println("TempEmailId : "+tempEmailid);
                System.out.println("GetEmailId : "+userObj.getEmailId());
                throw new Exception("User With "+tempEmailid+" Already Exists");
            }
        }

        User userObj = null;
        userObj = registrationService.saveUser(user);


        return userObj;
    }
}
