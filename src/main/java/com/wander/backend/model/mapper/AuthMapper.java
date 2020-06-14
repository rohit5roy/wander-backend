package com.wander.backend.model.mapper;

/**
 * @author Rohit Roy
 */
import com.wander.backend.model.Role;
import com.wander.backend.model.User;
import com.wander.backend.model.UserBasicInfo;
import com.wander.backend.model.dto.request.RegisterDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AuthMapper {

    public User mapToUser(RegisterDTO registerDTO) {
        UserBasicInfo userBasicInfo = new UserBasicInfo(null, registerDTO.getName(), registerDTO.getLastName(),
                registerDTO.getDocumentNumber(), false, registerDTO.getEmail());
        return new User(null, registerDTO.getUserName().toLowerCase(), registerDTO.getPassword(), true,
                Arrays.asList(new Role("USER")), userBasicInfo);
    }

}
