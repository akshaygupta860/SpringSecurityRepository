package com.shashi.userservice.Repository;

import com.shashi.userservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>
{
    @Query("SELECT user FROM User user WHERE user.name = ?1")
    User findUserByName(String name);

}

