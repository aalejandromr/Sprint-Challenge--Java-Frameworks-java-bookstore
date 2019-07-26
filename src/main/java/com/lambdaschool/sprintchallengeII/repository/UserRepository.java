package com.lambdaschool.sprintchallengeII.repository;

import com.lambdaschool.sprintchallengeII.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
