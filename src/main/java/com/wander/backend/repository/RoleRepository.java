package com.wander.backend.repository;

/**
 * @author Rohit Roy
 */
import com.wander.backend.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
}
