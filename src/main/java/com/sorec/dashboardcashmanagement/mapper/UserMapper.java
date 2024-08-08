package com.sorec.dashboardcashmanagement.mapper;

import com.sorec.dashboardcashmanagement.dto.UserDTO;
import com.sorec.dashboardcashmanagement.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper  implements EntityMapper<User, UserDTO>{

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId( entity.getId() );
        userDTO.setUsername( entity.getUsername() );
        userDTO.setRole( entity.getRole() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toDtos(List<User> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    @Override
    public User toEntity(UserDTO dto) {
       return null;
    }

    @Override
    public List<User> toEntities(List<UserDTO> dtos) {
        return null;
    }

}
