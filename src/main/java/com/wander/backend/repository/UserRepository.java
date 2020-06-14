package com.wander.backend.repository;

/**
 * @author Rohit Roy
 */
import com.wander.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserNameIgnoreCaseAndEnabledTrue(String userName);

}
