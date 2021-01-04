package com.eijteam.swarm.and.hive.modules.user.factories;

import com.eijteam.swarm.and.hive.common.interfaces.IDTOFactory;
import com.eijteam.swarm.and.hive.modules.user.DTOs.RegisterReqDTO;
import com.eijteam.swarm.and.hive.modules.user.DTOs.RegisterResDTO;
import com.eijteam.swarm.and.hive.modules.user.entities.User;
import org.springframework.stereotype.Component;

@Component
public class RegisterDTOFactory implements IDTOFactory<User, RegisterReqDTO, RegisterResDTO> {
    @Override
    public RegisterResDTO createResDTO(User entity) {
        RegisterResDTO resDTO = new RegisterResDTO();
        resDTO.username = entity.getUsername();
        resDTO.email = entity.getEmail();
        resDTO.id = entity.getId();
        return resDTO;
    }

    @Override
    public User reqDTOToEntity(RegisterReqDTO dto) {
        return new User(null, dto.username, dto.email, dto.password);
    }
}
