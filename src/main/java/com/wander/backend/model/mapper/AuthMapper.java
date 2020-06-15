package com.wander.backend.model.mapper;

/**
 * @author Rohit Roy
 */
import com.wander.backend.model.Role;
import com.wander.backend.model.User;
import com.wander.backend.model.UserBasicInfo;
import com.wander.backend.model.dto.request.RegisterDTO;
import com.wander.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AuthMapper {

    @Autowired
    RoleRepository roleRepository;

    public User mapToUser(RegisterDTO registerDTO) {
        UserBasicInfo userBasicInfo = new UserBasicInfo(null, registerDTO.getName(), registerDTO.getLastName(),
                registerDTO.getDocumentNumber(), false, registerDTO.getEmail());
        return new User(null, registerDTO.getUserName().toLowerCase(), registerDTO.getPassword(), true,
                Arrays.asList(roleRepository.findById("ADMIN").orElse(new Role("ADMIN"))), userBasicInfo);
    }

}
