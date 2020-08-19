package com.app.registration.repository;

import com.app.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<User,Integer> {
    public User findByEmailId(String emailId);
}
